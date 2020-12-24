package com.example.springbootdemo.security;


import com.example.springbootdemo.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/*
* security配置类
* ye
* 2020.11.10
* */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomUserService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        //路由策略和访问权限的简单配置
        httpSecurity
                .authorizeRequests()
                //要求有管理员的权限
                .antMatchers("/Ajax").access("hasRole('ADMIN')")
                .antMatchers("/**")
                .permitAll()
                .and()
                .formLogin()                  //启用默认登录页面
                .failureForwardUrl("/error")  //登录失败返回URL: /error
                .defaultSuccessUrl("/index")  //登录成功跳转URL，这里跳转到首页
                .permitAll();                 //登录页面全部权限可访问
        super.configure(httpSecurity);
    }


    @Resource
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserService())
                .passwordEncoder(new MyPasswordEncoder());
//                .inMemoryAuthentication()
//                .withUser("ye").password("123456").roles("ADMIN")
//                .and()
//                .withUser("lu").password("123456").roles("USER");

    }

}
