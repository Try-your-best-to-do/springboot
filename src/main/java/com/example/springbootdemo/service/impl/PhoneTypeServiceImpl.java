package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.dao.PhoneTypeDao;
import com.example.springbootdemo.model.PhoneType;
import com.example.springbootdemo.repository.PhoneTypeRepository;
import com.example.springbootdemo.service.PhoneTypeService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import org.apache.logging.log4j.*;


@Service
public class PhoneTypeServiceImpl implements PhoneTypeService {
    @Resource
    private PhoneTypeRepository phoneTypeRepository;
    //需要添加的代码
    Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private PhoneTypeDao phoneTypeDao;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public PhoneType findById(String id) {
        //step.1 查询Redis缓存中的所有数据
        List<PhoneType> phoneTypeList = redisTemplate.opsForList().range(ALL_USER,0,-1);
        if (phoneTypeList != null&&phoneTypeList.size() >0){
            for (PhoneType phoneType:phoneTypeList
            ) {
                if (phoneType.getType_id().equals(id)){
                    return phoneType;
                }
            }
        }

        //step.2 查询数据库中的数据
        PhoneType phoneType = phoneTypeRepository.findById(id).get();
        if (phoneType != null){
            //step.3 将数据插入到Redis缓存中
            redisTemplate.opsForList().leftPush(ALL_USER,phoneType);
        }

        return phoneType;
        //return phoneTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<PhoneType> findAll() {
        return phoneTypeRepository.findAll();
    }

    @Transactional
    @Override
    public PhoneType save(PhoneType phoneType) {
        PhoneType phoneType1 = phoneTypeRepository.save(phoneType);
        //制造空指针异常
        String error = null;
        error.split("/");
        return phoneType1;
    }

    @Override
    public void delete(String id) {
        phoneTypeRepository.deleteById(id);
        logger.info(("userId:" + id + "用户被删除"));
    }

    @Override
    public String findTypeNameByNumberPart(String numberPart) {
        return phoneTypeDao.findTypeNameByTypeNumber(numberPart);
    }
}
