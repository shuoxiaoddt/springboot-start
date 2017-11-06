package com.uway.springboot.boot.service.impl;

import com.uway.springboot.boot.dao.RedisInfoRepository;
import com.uway.springboot.boot.entity.RedisInfo;
import com.uway.springboot.boot.service.RedisInfoService;
import com.uway.springboot.boot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by uwayxs on 2017/11/6.
 */
@Service
public class RedisInfoServiceImpl implements RedisInfoService {

    @Autowired
    private RedisInfoRepository redisInfoRepository;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public RedisInfo findById(Long id) {
        String cacheKey = "RedisInfoServiceImplfindById"+id;
        RedisInfo obj = (RedisInfo) redisUtil.get(cacheKey);
        if(obj == null){
            System.err.println("RedisInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
            Optional<RedisInfo> redisInfoOps = redisInfoRepository.findById(2L);
            RedisInfo redisInfo = redisInfoOps.orElse(new RedisInfo());
            System.out.println(redisInfo);
            redisUtil.set(cacheKey,redisInfo);
            return redisInfo;
        }
        System.err.println("RedisInfoServiceImpl.findById()=========从Redis中进行获取的....id="+id);
        return obj;
    }

    @Override
    public void deleteFromCache(Long id) {
        System.out.println("RedisInfoServiceImpl.delete().从缓存中删除.");
    }

    @Override
    public RedisInfo save(RedisInfo redisInfo) {
        return redisInfoRepository.save(redisInfo);
    }
}
