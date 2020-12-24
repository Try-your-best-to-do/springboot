package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.AyMood;
import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.service.AyMoodProducer;
import com.example.springbootdemo.service.AyMoodService;
import com.example.springbootdemo.service.AyUserService;
import com.example.springbootdemo.service.PayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@RestController
public class AyMoodController {
    @Resource
    private AyMoodProducer ayMoodProducer;

    @Resource
    private AyUserService ayUserService;

    @Resource
    private AyMoodService ayMoodService;
    //需要添加的代码
    Logger logger = LogManager.getLogger(this.getClass());


    @RequestMapping("/findT")
    public String find(){
        return ayUserService.findById("1").toString();
    }

    @RequestMapping("/ayMood")
    public String testActiveMQAsynSave(AyMood ayMood){
        if (ayMood.getContent()==null||ayMood.getContent()==""){
            return "请输入内容！";
        }
        ayMood.setPraiseNum(0);
        ayMood.setPublishTime(new Date());
        String msg = ayMoodService.asynSave(ayMood);
        logger.info(ayMood.getId());
        logger.info("异步发表说说："+msg);
        return "成功！";
    }

    @RequestMapping("/async")
    public String async() throws InterruptedException {
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
        return "总共消耗："+(endTime-startTime)+"毫秒";
    }

    @Resource
    private PayService payService;

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam int num) throws Exception{
        int remainingnum = payService.minGoodsnum(num == 0 ? 1: num);
        logger.info("剩余的数量==="+remainingnum);
        return "库库存成功";
    }

}
