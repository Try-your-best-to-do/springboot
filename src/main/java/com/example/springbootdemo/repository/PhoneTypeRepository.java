package com.example.springbootdemo.repository;


import com.example.springbootdemo.model.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneTypeRepository extends JpaRepository<PhoneType,String> {

}
