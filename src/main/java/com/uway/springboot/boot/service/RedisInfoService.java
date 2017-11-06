package com.uway.springboot.boot.service;

import com.uway.springboot.boot.entity.RedisInfo;

import java.util.Optional;

/**
 * Created by uwayxs on 2017/11/6.
 */
public interface RedisInfoService {
    RedisInfo findById(Long id);
    void deleteFromCache(Long id);
    RedisInfo save(RedisInfo redisInfo);
}
