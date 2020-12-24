package com.example.springbootdemo.repository;


import com.example.springbootdemo.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyUserRepository extends JpaRepository<AyUser,String> {
}
