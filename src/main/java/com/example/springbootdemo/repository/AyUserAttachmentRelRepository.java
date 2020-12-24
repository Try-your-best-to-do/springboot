package com.example.springbootdemo.repository;


import com.example.springbootdemo.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;


/*
* 用户附件Repository
* ye
* 2020.11.09
* */

public interface AyUserAttachmentRelRepository extends MongoRepository<AyUserAttachmentRel,String> {

}
