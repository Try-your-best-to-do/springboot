//package com.example.springbootdemo.listener;
//
//
//import com.example.springbootdemo.model.Listener;
//import com.example.springbootdemo.service.ListenerService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebListener;
//
///*
//* ye
//* 2020.10.15
//* 监听器
//* */
//
//@WebListener
//public class PhoneListener implements ServletRequestListener {
//    @Resource
//    private ListenerService listenerService;
//    Logger logger = LogManager.getLogger(this.getClass());
//    @Override
//    public  void requestDestroyed(ServletRequestEvent servletRequestEvent){
//        Listener listener = listenerService.findById("1");
//        logger.info(listener);
//        //每次访问数量加1，并保存到数据表
//        listener.setQuantity(listener.getQuantity() + 1);
//        listenerService.save(listener);
//    }
//    @Override
//    public void requestInitialized(ServletRequestEvent servletRequestEvent){
//
//    }
//
//}

