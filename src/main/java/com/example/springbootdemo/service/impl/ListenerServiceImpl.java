package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.model.Listener;
import com.example.springbootdemo.repository.ListenerRepository;
import com.example.springbootdemo.service.ListenerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*
 * ye
 * 2020.10.15
 * 业务层接口实现类
 * */

@Service
public class ListenerServiceImpl implements ListenerService {

    @Resource
    private ListenerRepository listenerRepository;

    @Override
    public List<Listener> findAll() {
        return listenerRepository.findAll();
    }

    @Override
    public Listener findById(String id) {
        return listenerRepository.findById(id).orElse(null);
    }

    @Override
    public Listener save(Listener listener) {
        return listenerRepository.save(listener);
    }

    @Override
    public void delete(String id) {
        listenerRepository.deleteById(id);
    }
}
