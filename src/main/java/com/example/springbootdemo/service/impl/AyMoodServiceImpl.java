package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.dao.AyMoodDao;
import com.example.springbootdemo.model.AyMood;
import com.example.springbootdemo.repository.AyMoodRepository;
import com.example.springbootdemo.service.AyMoodProducer;
import com.example.springbootdemo.service.AyMoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.jms.Destination;


/*
*  说说服务实现
*  ye
*  2020.11.23
* */

@Service
public class AyMoodServiceImpl implements AyMoodService {

    @Resource
    private AyMoodDao ayMoodDao;

    @Override
    public AyMood save(AyMood ayMood) {
        return ayMoodDao.save(ayMood);
    }

    //队列
    private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");

    @Resource
    private AyMoodProducer ayMoodProducer;

    @Override
    public String asynSave(AyMood ayMood) {
        //往队列ay.queue.asyn.save推送消息，消息内容为说说实体
        ayMoodProducer.sendMessage(destination,ayMood);
        return "success";
    }
}
