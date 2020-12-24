package com.example.springbootdemo.repository;


import com.example.springbootdemo.model.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;
/*
*  说说repository
*  ye
*  2020.11.23
* */
public interface AyMoodRepository extends JpaRepository<AyMood,String> {
}
