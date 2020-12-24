//package com.example.springbootdemo.EndPoint;
//
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
///*
//*   自定义健康类
//*   ye
//*   2020.11.08
//* */
//@Component
//public class MyHealthIndicator implements HealthIndicator {
//    @Override
//    public Health health() {
//        Long totalSpace = cheakTocalSpace();
//        Long free = checkFree();
//        String status = checkStatus();
//        checkFree();
//        return new Health.Builder()
//                .up()
//                .withDetail("status",status)
//                .withDetail("total",totalSpace)
//                .withDetail("free",free)
//                .build();
//    }
//    private String checkStatus(){
//        //可以根据实际项目，获取相关参数
//        return "UP";
//    }
//
//    private Long cheakTocalSpace(){
//        //可以根据实际项目，获取相关参数
//        return 10L;
//    }
//    private Long checkFree(){
//        //可以根据实际项目，获取相关参数
//        return 100L;
//    }
//}
