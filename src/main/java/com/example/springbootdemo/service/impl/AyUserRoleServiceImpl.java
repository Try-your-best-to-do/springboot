package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.model.AyUserRoleRel;
import com.example.springbootdemo.repository.AyUserRoleRelRepository;
import com.example.springbootdemo.service.AyUserRoleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
* 用户角色关联Service
* ye
* 2020.11.10
* */
@Service
public class AyUserRoleServiceImpl implements AyUserRoleRelService {
    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;

    @Override
    public List<AyUserRoleRel> findByUserId(String userId) {
        return ayUserRoleRelRepository.findByUserId(userId);
    }
}
