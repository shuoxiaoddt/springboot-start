package com.uway.springboot.boot.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by uwayxs on 2017/11/3.
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
public class MyEnvironmentAware implements EnvironmentAware {
    //注入application.properties的属性到指定变量中.
    @Value("${spring.datasource.url}")
    private String myUrl;
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("myUrl="+myUrl);
}
}
