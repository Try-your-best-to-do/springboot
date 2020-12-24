package com.example.springbootdemo;

import com.example.springbootdemo.mail.SendJunkMailService;
import com.example.springbootdemo.model.AyMood;
import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.model.AyUserAttachmentRel;
import com.example.springbootdemo.model.PhoneType;
import com.example.springbootdemo.repository.AyUserRoleRelRepository;
import com.example.springbootdemo.service.*;
import com.example.springbootdemo.utils.QRCodeUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootTest
class SpringbootdemoApplicationTests {
    @Resource
    private AyMoodProducer ayMoodProducer;

    @Resource
    SendJunkMailService sendJunkMailService;


    @Resource
    AyUserService ayUserService;

    @Resource
    private AyUserAttachmentRelService ayUserAttachmentRelService;

    @Resource
    private AyMoodService ayMoodService;

    @Autowired
    PhoneTypeService phoneTypeService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    ListenerService listenerService;
    //需要添加的代码
    Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;

    @Test
    public void findByUserId() {
        logger.info(ayUserRoleRelRepository.findByUserId("1"));
    }
    @Test
    public void testRedis(){
        //增
        redisTemplate.opsForValue().set("name","Test");
        String name = (String)redisTemplate.opsForValue().get("name");
        logger.info(name);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll() {
        System.out.println(phoneTypeService.findAll().get(0).toString());
    }

    @Test
    public void testFindById() {
        logger.info(listenerService.findById("1"));
    }

    @Test
    public void testUpdate() {
        PhoneType phoneType = new PhoneType();
        phoneType.setType_id("2");
        phoneType.setNumber_part("52063098756");
        phoneType.setType_name("中国地洞");
        phoneType.setType_remark("修改测试");
        phoneTypeService.save(phoneType);
        logger.info(phoneTypeService.findAll().toString());
    }

    @Test
    void testAdd() {
        PhoneType phoneType = new PhoneType();
        phoneType.setNumber_part("656");
        phoneType.setType_name("466");
        phoneType.setType_remark("boss");
        phoneTypeService.save(phoneType);
        logger.info(phoneTypeService.findAll().toString());
    }

    @Test
    void testDelete() {
        phoneTypeService.delete("1");
        logger.info(phoneTypeService.findAll().toString());
    }


    @Test
    public void testFindById_redis(){
        Long redisUserSize = 0L;
        //查询id = 2 的数据，该数据存在于Redis缓存中
        PhoneType phoneType = phoneTypeService.findById("2");
        redisUserSize = redisTemplate.opsForList().size("ALL_USER_LIST");
        logger.info("目前缓存中的用户数量为：" + redisUserSize);
        logger.info("----> id: " + phoneType.getType_id() + "   name: " + phoneType.getType_name());

    }

    @Test
    public void testFindById_redis1(){
        Long redisUserSize = 0L;
        //查询id = 12 的数据，该数据存不在于Redis缓存中，存在于数据库中，所有会把数据库查询的数据更新到缓存
        PhoneType phoneType1 = phoneTypeService.findById("12");
        redisUserSize = redisTemplate.opsForList().size("ALL_USER_LIST");
        logger.info("目前缓存中的用户数量为：" + redisUserSize);
        logger.info("----> id: " + phoneType1.getType_id() + "   name: " + phoneType1.getType_name());
    }

    @Test
    public void testLog4j2(){
        //创建日志对象
        Logger logger = LogManager.getLogger(this.getClass());
        logger.info("测试Log4j2!");
    }

    @Test
    public void testMybatis(){
        //创建日志对象
        logger.info(ayUserService.findByName("Ye"));
    }


    @Test
    public void testMybatis1(){
        //创建日志对象
        logger.info(ayUserService.findById("1"));
    }

    @Test
    public void testMongoDB(){
        AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
        ayUserAttachmentRel.setId("123456");
        ayUserAttachmentRel.setUserId("666");
        ayUserAttachmentRel.setFileName("个人简历.doc");
        AyUserAttachmentRel ayUserAttachmentRel1 = ayUserAttachmentRelService.save(ayUserAttachmentRel);
        logger.info(ayUserAttachmentRel1 + "保存成功！");
    }

    @Test
    public void test() throws Exception {
        // 存放在二维码中的内容
        String text = "一起入门到入土？";
        // 嵌入二维码的图片路径
        String imgPath = "G:/qrcode/bg.jpg";
        // 生成的二维码的路径及名称
        String destPath = "G:/qrcode/qrcode/emn.png";
        //生成二维码
        QRCodeUtil.encode(text,imgPath,destPath,true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
    }

    @Test
    public void testMood(){

        AyMood ayMood = new AyMood();
        ayMood.setId("1");
        ayMood.setUserId("1");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第一条说说！！！");
        ayMood.setPublishTime(new Date());
        AyMood mood = ayMoodService.save(ayMood);
        logger.info(mood);


    }

    @Test
    public void testActiveMQ(){
        Destination destination = new ActiveMQQueue("ay.queue");
        ayMoodProducer.sendMessage(destination,"hello,mq!!!");
    }

    @Test
    public void testActiveMQAsynSave(){
        AyMood ayMood = new AyMood();
        ayMood.setId("4");
        ayMood.setUserId("4");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第四条说说！！！");
        ayMood.setPublishTime(new Date());
        String msg = ayMoodService.asynSave(ayMood);
        logger.info("异步发表说说："+msg);
    }

    @Test
    public void testAsync(){
        Long startTime = System.currentTimeMillis();
        logger.info("第一次查询用户！");
        List<AyUser> ayUserList = ayUserService.findAll();
        logger.info("第二次查询用户！");
        List<AyUser> ayUserList2 = ayUserService.findAll();
        logger.info("第三次查询用户！");
        List<AyUser> ayUserList3 = ayUserService.findAll();
        Long endTime = System.currentTimeMillis();
        logger.info("总共消耗："+(endTime-startTime)+"毫秒");
    }

    @Test
    public void testAsync2() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        logger.info("第一次查询用户！");
        Future<List<AyUser>> ayUserList = ayUserService.findAsynAll();
        logger.info("第二次查询用户！");
        Future<List<AyUser>> ayUserList2 = ayUserService.findAsynAll();
        logger.info("第三次查询用户！");
        Future<List<AyUser>> ayUserList3 = ayUserService.findAsynAll();
        while(true){
            if (ayUserList.isDone()&&ayUserList2.isDone()&&ayUserList3.isDone()){
                break;
            }else {
                Thread.sleep(10);
            }
        }
        Long endTime = System.currentTimeMillis();
        logger.info("总共消耗："+(endTime-startTime)+"毫秒");
    }

    @Test
    public void test1(){
        AyUser ayUser = new AyUser();
        ayUser.setName("老师讲得很好，没有意见，不过我觉得如果早点检查作业就好了");
        List<AyUser> ayUsers = new ArrayList<>();
        ayUsers.add(ayUser);
        sendJunkMailService.sendJunkMail(ayUsers);
    }

}
