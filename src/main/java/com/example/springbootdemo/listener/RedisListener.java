//package com.example.demojpa.listener;
//import com.example.demojpa.model.PhoneType;
//import com.example.demojpa.service.PhoneTypeService;
//import org.springframework.data.redis.core.RedisTemplate;
//import javax.annotation.Resource;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.util.List;
//import org.apache.logging.log4j.*;
//
///*
//* 监听器
//* ye
//* 2020.10.26
//* */
//
//@WebListener
//public class RedisListener implements ServletContextListener {
//    @Resource
//    private RedisTemplate redisTemplate;
//    //需要添加的代码
//    Logger logger = LogManager.getLogger(this.getClass());
//    @Resource
//    private PhoneTypeService phoneTypeService;
//    private static final String ALL_USER = "ALL_USER_LIST";
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent){
//        //查询数据库所有用户
//        List<PhoneType> phoneListenerList = phoneTypeService.findAll();
//        //清除缓存中的用户数据
//        redisTemplate.delete(ALL_USER);
//        //将数据存放到Redis缓存中
//        redisTemplate.opsForList().leftPushAll(ALL_USER,phoneListenerList);
//        //真实项目中需要注解掉，查询所有的用户数据
//        List<PhoneType> queryPhoneTypeList = redisTemplate.opsForList().range(ALL_USER,0,-1);
//        //System.out.println("缓存中目前的用户数：" + queryPhoneTypeList.size() + "人");
//        logger.info("缓存中目前的用户数：" + queryPhoneTypeList.size() + "人");
//        //System.out.println("ServletContext 上下文初始化");
//        logger.info("ServletContext 上下文初始化");
//    }
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent){
//        //System.out.println("ServletContext 上下文销毁");
//        logger.info("ServletContext 上下文销毁");
//    }
//}
