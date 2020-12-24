package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.AyMood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
*  说说dao
*  ye
*  2020.12.11
* */

@Mapper
public interface AyMoodDao {

    AyMood findById(@Param("name") String name);

    AyMood save(AyMood ayMood);

    AyMood update(AyMood ayMood);

    int delete(String userId);
}
