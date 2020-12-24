package com.example.springbootdemo.service;



import com.example.springbootdemo.error.BusinessException;
import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.model.AyUserRoleRel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
* 自定义用户服务类
* ye
* 2020.11.10
* */
@Service
public class CustomUserService implements UserDetailsService {
    //log4j
    Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private AyUserService ayUserService;

    @Resource
    private AyUserRoleRelService ayUserRoleRelService;

    @Resource
    private AyRoleService ayRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AyUser ayUser = ayUserService.findByName(s);
        if (ayUser == null){
            throw new BusinessException("用户不存在");
        }

        //获取用户所有的关联角色
        List<AyUserRoleRel> ayUserRoleRels = ayUserRoleRelService.findByUserId(ayUser.getId());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if(ayUserRoleRels != null && ayUserRoleRels.size()>0){
            for (AyUserRoleRel ayUserRoleRel:ayUserRoleRels){
                //获取用户关联角色名称
                String roleName = ayRoleService.find(ayUserRoleRel.getRoleId()).getName();
                //加上ROLE_前缀
                roleName = "ROLE_" +roleName;
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
        }
        logger.info(ayUser.getName()+"    "+ayUser.getPassword()+"   "+authorities);
        return new User(ayUser.getName(),ayUser.getPassword(),authorities);
    }
}
