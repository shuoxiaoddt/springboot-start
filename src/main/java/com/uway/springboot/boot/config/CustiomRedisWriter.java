package com.uway.springboot.boot.config;

import java.time.Duration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.lang.Nullable;

/**
 * Created by uwayxs on 2017/11/8.
 */
public class CustiomRedisWriter implements RedisCacheWriter {
    @Override
    public void put(String s, byte[] bytes, byte[] bytes1, @Nullable Duration duration) {

    }

    @Nullable
    @Override
    public byte[] get(String s, byte[] bytes) {
        return new byte[0];
    }

    @Nullable
    @Override
    public byte[] putIfAbsent(String s, byte[] bytes, byte[] bytes1, @Nullable Duration duration) {
        return new byte[0];
    }

    @Override
    public void remove(String s, byte[] bytes) {

    }

    @Override
    public void clean(String s, byte[] bytes) {

    }
}
