package com.example.springbootdemo.service;



import com.example.springbootdemo.model.PhoneType;

import java.util.List;


public interface PhoneTypeService {
        PhoneType findById(String id);
        List<PhoneType> findAll();
        PhoneType save(PhoneType phoneType);
        void delete(String id);
        String findTypeNameByNumberPart(String numberPart);
        }
