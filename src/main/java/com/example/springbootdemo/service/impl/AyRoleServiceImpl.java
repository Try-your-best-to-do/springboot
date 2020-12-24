package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.model.AyRole;
import com.example.springbootdemo.repository.AyRoleRepository;
import com.example.springbootdemo.service.AyRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/*
* 用户角色service
* ye
* 2020.11.10
* */
@Service
public class AyRoleServiceImpl implements AyRoleService {
    @Resource
    private AyRoleRepository ayRoleRepository;

    @Override
    public AyRole find(String id) {
        return ayRoleRepository.findById(id).get();
    }
}
