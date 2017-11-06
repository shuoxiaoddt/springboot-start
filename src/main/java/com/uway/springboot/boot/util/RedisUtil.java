package com.uway.springboot.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by uwayxs on 2017/11/6.
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**读取缓存
     * 单个key
     * @param key
     * @return
     */
    public Object get(String key){
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    /**
     * 多个key
     * @param keys
     * @return
     */
    public Collection<Object> get(Collection<String> keys){
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.multiGet(keys);
    }

    /**
     * 根据模式匹配
     * @param pattern
     * @return
     */
    public Collection<Object> getByPattern(String pattern){
        Set<String> keys = redisTemplate.keys(pattern);
        if(keys != null && keys.size() > 0){
            ValueOperations<String, Object> ops = redisTemplate.opsForValue();
            return ops.multiGet(keys);
        }
        return null;
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key , Object value){
        boolean result = false;
        try{
            ValueOperations<String, Object> ops = redisTemplate.opsForValue();
            ops.set(key, value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean set(String key , Object value , Long timeout){
        boolean result = false;
        try {
            ValueOperations<String, Object> ops = redisTemplate.opsForValue();
            ops.set(key,value,timeout, TimeUnit.MILLISECONDS);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     * @param key       单个key
     * @return
     */
    public boolean delete(String key) {
        boolean result = false;
        try {
            if(redisTemplate.hasKey(key)) {
                redisTemplate.delete(key);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     * @param keys  多个key
     * @return
     */
    public boolean delete(Collection<String> keys) {
        boolean result = false;
        try {
            redisTemplate.delete(keys);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 是都存在键key
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 向频道发布消息
     * @param channel       频道名称
     * @param message       消息体
     */
    public void sendMessage(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }

}
