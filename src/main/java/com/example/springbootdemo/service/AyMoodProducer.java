package com.example.springbootdemo.service;


import com.example.springbootdemo.model.AyMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import javax.jms.Destination;
import javax.annotation.Resource;


/*
*  生产者
*  ye
*  2020.11.23
* */
@Service
public class AyMoodProducer {


    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    //同步消费者
    public void sendMessage(Destination destination,final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    //异步消费者
    public void sendMessage(Destination destination,final AyMood ayMood){
        jmsMessagingTemplate.convertAndSend(destination,ayMood);
    }
}
