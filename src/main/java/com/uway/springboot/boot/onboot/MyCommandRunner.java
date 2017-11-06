package com.uway.springboot.boot.onboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by uwayxs on 2017/11/3.
 */
@Component
@Order(2)
public class MyCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("MyCommandRunner order 2");
    }
}
