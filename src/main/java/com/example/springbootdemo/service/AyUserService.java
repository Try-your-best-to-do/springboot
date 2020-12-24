package com.example.springbootdemo.service;


import com.example.springbootdemo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.concurrent.Future;

public interface AyUserService {
    AyUser findById(String id);
    List<AyUser> findAll();
    AyUser save(AyUser ayUser);
    void  delete(String id);
    //分页
    Page<AyUser> findAll(Pageable pageable);

    AyUser findByName(String name);

    AyUser findByNameAndPassword(String name,String password);

    //异步查询
    Future<List<AyUser>> findAsynAll();
}
