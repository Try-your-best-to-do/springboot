package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.AyUserDao;
import com.example.springbootdemo.error.BusinessException;
import com.example.springbootdemo.model.AyUser;
import com.example.springbootdemo.repository.AyUserRepository;
import com.example.springbootdemo.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/*
 * ye
 * 用户层接口实现类
 * 2020.10.13
 * */
@Service
public class AyUserServiceImpl implements AyUserService {

    @Resource
    private AyUserRepository ayUserRepository;

    Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private AyUserDao ayUserDao;

    @Override
    public AyUser findById(String id) {
        return ayUserRepository.findById(id).get();
    }

    @Override
    public List<AyUser> findAll() {
        try{
            logger.info("开始做任务！");
            Long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            Long end = System.currentTimeMillis();
            logger.info("总共消耗："+(end-start)+"毫秒");
            return ayUserList;
        }catch (Exception e){
            logger.error("method [findAll] error",e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public AyUser save(AyUser ayUser) {
        return ayUserRepository.save(ayUser);
    }

    @Override
    public void delete(String id) {
        ayUserRepository.deleteById(id);
    }


    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }


    @Override
    @Async
    public AyUser findByName(String name) {
        return ayUserDao.findByName(name);
    }

    @Override
    @Retryable(value = {BusinessException.class},maxAttempts = 5)
    public AyUser findByNameAndPassword(String name, String password) {
        logger.info("findByNameAndPassword  方法重试了！");
        throw new BusinessException();
    }

    @Override
    @Async
    public Future<List<AyUser>> findAsynAll() {
        try{
            logger.info("开始做任务！");
            Long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            Long end = System.currentTimeMillis();
            logger.info("总共消耗："+(end-start)+"毫秒");
            return new AsyncResult<List<AyUser>>(ayUserList);
        }catch (Exception e){
            logger.error("method [findAll] error",e);
            return new AsyncResult<List<AyUser>>(null);
        }
    }


}
