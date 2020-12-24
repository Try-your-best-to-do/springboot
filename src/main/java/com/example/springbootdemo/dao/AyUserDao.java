package com.example.springbootdemo.dao;


import com.example.springbootdemo.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
* 用户Dao
* ye
* 2020.10.29
* */
@Mapper
public interface AyUserDao {
    /*
    * 通过用户名查询用户
    * @param name
    * @param password
    * */
    AyUser findByName(@Param("name") String name);

    AyUser findByNameAndPassword(@Param("name") String name,@Param("password")String password);

    AyUser save(AyUser ayUser);

    AyUser update(AyUser ayUser);

    int delete(String id);
}
