package com.example.springbootdemo.mail;

import com.example.springbootdemo.model.AyUser;

import java.util.List;

/*
* 发送用户邮件服务接口
* ye
* 2020.10.28
* */
public interface SendJunkMailService {
    boolean sendJunkMail(List<AyUser> ayUsers);

}
