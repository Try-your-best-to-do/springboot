package com.example.springbootdemo.controller;


import com.example.springbootdemo.error.BusinessException;
import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.model.Listener;
import com.example.springbootdemo.service.AyUserService;
import com.example.springbootdemo.service.ListenerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/*
* ye
* 2020.10.15
* 控制层
* */

@Controller
public class IndexController {
    @Resource
    private ListenerService listenerService;

    @Resource
    private AyUserService ayUserService;

    @RequestMapping("/count")
    public String count(Model model){
        Listener listener = listenerService.findById("1");
        String msg = "这是第"+listener.getQuantity()+"次访问网站！";
        model.addAttribute("count",msg);
        return "count";
    }

    @RequestMapping("/index")
    public String index(Model model){
        return "search";
    }

    @RequestMapping("/failed")
    public String error(Model model) {
        throw new BusinessException("业务异常！");
    }

    @RequestMapping("/Ajax")
    public String ajax(Model model){
        return "ajax";
    }

    @RequestMapping("/mood")
    public String mood(Model model){
        return "ayMood";
    }

    @RequestMapping("/retry")
    public String retry(Model model) {
        AyUser ayUser = ayUserService.findByNameAndPassword("xxx", "xxx");
        model.addAttribute("user", ayUser);
        return "index";
    }


}