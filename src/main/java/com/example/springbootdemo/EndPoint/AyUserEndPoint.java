package com.example.springbootdemo.EndPoint;



import com.example.springbootdemo.service.AyUserService;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
*  自定义端点
*  ye
*  2020.11.8
* */
@Component
@Endpoint(id = "userEndPoints")
public class AyUserEndPoint {

    @Resource
    private AyUserService ayUserService;

    @ReadOperation
    public Map<String,Object> invoke(){
        Map<String,Object> map = new HashMap<String, Object>();
        //当地时间
        map.put("current_time",new Date());
        //用户总数量
        map.put("user_num",ayUserService.findAll().size());
        return map;
    }
}
