package com.example.springbootdemo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*
* 统一业务异常处理类
* ye
* 2020.11.07
* */
@ControllerAdvice(basePackages = {"com.example.springbootdemo",})
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    //如果返回的为json数据或其他对象，添加该注解
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest req,Exception e)throws Exception{
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        return errorInfo;
    }

}
