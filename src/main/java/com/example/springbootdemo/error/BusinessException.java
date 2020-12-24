package com.example.springbootdemo.error;

/*
* 业务异常返回的类
* ye
* 2020.11.07
* */
public class BusinessException extends RuntimeException{
    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }
}
