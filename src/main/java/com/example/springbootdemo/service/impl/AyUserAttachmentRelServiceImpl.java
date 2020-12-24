package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.model.AyUserAttachmentRel;
import com.example.springbootdemo.repository.AyUserAttachmentRelRepository;
import com.example.springbootdemo.service.AyUserAttachmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/*
* MongoDB接口实现
* ye
* 2020.11.09
* */
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {
    @Resource
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;

    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}
