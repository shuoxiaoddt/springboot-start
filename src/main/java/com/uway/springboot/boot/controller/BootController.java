package com.uway.springboot.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uwayxs on 2017/10/31.
 */
@RestController
public class BootController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
    @RequestMapping("/exception")
    public String execepetion(){
        throw new NullPointerException();
    }
}
