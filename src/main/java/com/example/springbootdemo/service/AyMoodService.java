package com.example.springbootdemo.service;


import com.example.springbootdemo.model.AyMood;

/*
*  说说服务层接口
*  ye
*  2020.11.23
* */
public interface AyMoodService {
    AyMood save(AyMood ayMood);
    String asynSave(AyMood ayMood);
}
