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

    /**
     * Cacheable 支持如下几个参数：
     *value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
     *key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL
     *condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "addCache",key="#id + 'findById'" ,condition = "#id < 100000000")
    public RedisInfo findById(Long id) {
        Optional<RedisInfo> redisInfoOps = redisInfoRepository.findById(2L);
        return redisInfoOps.orElse(new RedisInfo());
    }

    /**
     * @CacheEvict 支持如下几个参数：
     *value：缓存位置名称，不能为空，同上
     *key：缓存的key，默认为空，同上
     *condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
     *allEntries：true表示清除value中的全部缓存，默认为false
     *
     * @CachePut 注释，这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中，
     * 实现缓存与数据库的同步更新，理解为update语句。
     *
     * @param id
     */
    @Override
    @CacheEvict(value = "addCache",allEntries = true)
    public void deleteFromCache(Long id) {
        System.out.println("RedisInfoServiceImpl.delete().从缓存中删除.");
    }

    @Override
    public RedisInfo save(RedisInfo redisInfo) {
        return redisInfoRepository.save(redisInfo);
    }
}
