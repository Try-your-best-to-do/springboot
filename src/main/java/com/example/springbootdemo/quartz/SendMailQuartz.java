//package com.example.springbootdemo.quartz;
//
//import com.example.springbootdemo.mail.SendJunkMailService;
//import com.example.springbootdemo.service.AyUserService;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.apache.logging.log4j.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//import com.example.springbootdemo.model.AyUser;
///*
//* 定时器
//* ye
//* 2020.10.27
//*
//* */
//@Component
//@Configurable
//@EnableScheduling
//public class SendMailQuartz {
//
//    //日志对象
//    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);
//
//    @Resource
//    private SendJunkMailService sendJunkMailService;
//
//    @Resource
//    private AyUserService ayUserService;
//
//    //每60秒执行一次
//    @Scheduled(cron = "*/60 * * * *  *")
//    public void reportCurrentByCron(){
//        List<AyUser> userList = ayUserService.findAll();
//        if (userList == null || userList.size() <= 0) return;
//        //发送邮件
//        sendJunkMailService.sendJunkMail(userList);
//        logger.info("定时器运行了！！！");
//    }
//}
