package com.example.springbootdemo.quartz;

import org.apache.logging.log4j.*;
/*
* 定时器类
* ye
* 2020.10.27
* */
public class TestTask {
    //日志对象
    private static final Logger logger = LogManager.getLogger(TestTask.class);

    public void run(){
        logger.info("定时器运行了！！！");
    }
}
