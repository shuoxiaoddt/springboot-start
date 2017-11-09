package com.uway.springboot.boot.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.time.Duration;

/**
 * Created by uwayxs on 2017/11/6.
 */
@Configuration
public class RedisCustomConfiguration{



    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        setSerializer(template);
        return template;
    }
    private void setSerializer(RedisTemplate<String, Object> template) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(
                new ObjectMapper()
                        .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
                        .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        );
        template.setValueSerializer(jackson2JsonRedisSerializer);
    }

//    @Nullable
//    @Override
//    public KeyGenerator keyGenerator() {
//        System.out.println("RedisCustomConfiguration.keyGenerator()");
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(o.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : objects) {
//                    sb.append(obj.toString());
//                }
//                System.out.println("keyGenerator=" + sb.toString());
//                return sb.toString();
//            }
//        };
//    }
}
