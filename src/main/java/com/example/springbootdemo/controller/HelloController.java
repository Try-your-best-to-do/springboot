package com.example.springbootdemo.controller;



import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.service.AyUserService;
import com.example.springbootdemo.service.PhoneTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private PhoneTypeService phoneTypeService;
    @Resource
    private AyUserService ayUserService;
    @RequestMapping("/hello")
    public String hello(){
        return phoneTypeService.findAll().toString();
    }

    @RequestMapping("/ajax")
    public String ajax(){
        return "发送ajax请求成功！";
    }

    @RequestMapping("/findByName")
    private AyUser findByName(String name){
        return ayUserService.findByName(name);
    }

    @RequestMapping("/findByTypeName")
    private String findTypeName(String numberPart){
        return phoneTypeService.findTypeNameByNumberPart(numberPart);
    }
}
