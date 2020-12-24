package com.example.springbootdemo.repository;



import com.example.springbootdemo.model.AyUserRoleRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* 用户角色关联Repository
* ye
* 2020.11.10
* */
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel,String> {
    List<AyUserRoleRel> findByUserId(@Param("userId") String userID);
}
