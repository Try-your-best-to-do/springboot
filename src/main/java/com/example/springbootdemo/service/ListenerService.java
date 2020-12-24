package com.example.springbootdemo.service;


import com.example.springbootdemo.model.Listener;

import java.util.List;

/*
* ye
* 2020.10.15
* 业务层接口
* */
public interface ListenerService {
    List<Listener> findAll();
    Listener findById(String id);
    Listener save(Listener listener);
    void delete(String id);
}
