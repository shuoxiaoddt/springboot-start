package com.uway.springboot.boot.config;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by uwayxs on 2017/11/4.
 */
@Configuration
public class CustomConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("256KB");
        //factory.setLocation("路径地址");
        return  factory.createMultipartConfig();
    }
}
