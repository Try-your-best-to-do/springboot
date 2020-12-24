package com.example.springbootdemo.service;



import com.example.springbootdemo.model.AyMood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
*  消费者
*  ye
*  2020.11.30
* */
@Component
public class AyMoodConsumer {
    //loh4j
    Logger logger = LogManager.getLogger(this.getClass());

    //同步消息
    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String text){
        logger.info("用户发表说说【" + text + "】成功！");
    }

    @Resource
    private AyMoodService ayMoodService;
    //异步消息
    @JmsListener(destination = "ay.queue.asyn.save")
    public void receiveQueue(AyMood ayMood){
        ayMoodService.save(ayMood);
    }
}
