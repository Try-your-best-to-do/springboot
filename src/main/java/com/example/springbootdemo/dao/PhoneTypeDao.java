package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.model.PhoneType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
*  mybatis的Phone_type接口
*  ye
*  2020.11.4
* */

@Mapper
public interface PhoneTypeDao {
    String findTypeNameByTypeNumber(@Param("numberPart")String numberPart);

    AyUser save(PhoneType phoneType);

    AyUser update(PhoneType phoneType);

    int delete(String id);
}
