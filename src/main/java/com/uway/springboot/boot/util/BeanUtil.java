package com.uway.springboot.boot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by uwayxs on 2017/11/1.
 */
@Component
public class BeanUtil implements ApplicationContextAware {
    private static ApplicationContext ac = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(ac == null){
            ac = applicationContext;
        }
    }
    public static ApplicationContext getApplicationContext() {
        return ac;
    }
    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
