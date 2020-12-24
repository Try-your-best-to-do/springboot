package com.example.springbootdemo.mail.impl;

import com.example.springbootdemo.mail.SendJunkMailService;
import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

/*
 * 发送邮件服务接口实现
 * ye
 * 2020.10.28
 * */
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {
    @Autowired
    JavaMailSender mailSender;

    @Resource
    private AyUserService ayUserService;

    @Value("${spring.mail.username}")
    private String from;
    public static final Logger logger = LogManager.getLogger(SendJunkMailServiceImpl.class);

    @Override
    public boolean sendJunkMail(List<AyUser> ayUserList){
        try{
            if (ayUserList==null||ayUserList.size()<=0) return Boolean.FALSE;
            for (AyUser ayUser:ayUserList){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                //邮件发送方
                message.setFrom(from);
                //邮件主题
                message.setSubject("18软件工程 1班 1814080902157 叶本国");
                //邮件接收方
                message.setTo("hzujavaweb@126.com");
                //    message.setTo("2637809808@qq.com");
                //             message.setTo("2793690016@qq.com");
                //邮件内容
                message.setText("课程意见："+ ayUser.getName());
                //发送邮件
                this.mailSender.send(mimeMessage);
            }
        }catch (Exception e){
            logger.error("sendJunkMail error and ayUser=%s",ayUserList,e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

