package com.uway.springboot.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by uwayxs on 2017/11/7.
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "bootsession")
public class RedisSessionConfig {
}
