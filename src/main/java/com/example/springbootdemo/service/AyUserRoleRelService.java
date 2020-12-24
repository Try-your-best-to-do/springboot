package com.example.springbootdemo.service;




import com.example.springbootdemo.model.AyUserRoleRel;

import java.util.List;

/*
* 用户角色关联
* ye
* 2020.11.10
* */
public interface AyUserRoleRelService {
    List<AyUserRoleRel> findByUserId(String userId);
}
