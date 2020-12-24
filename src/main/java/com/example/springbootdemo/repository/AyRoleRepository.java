package com.example.springbootdemo.repository;



import com.example.springbootdemo.model.AyRole;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* 用户角色Repository
* ye
* 2020.11.10
* */
public interface AyRoleRepository extends JpaRepository<AyRole,String> {
}
