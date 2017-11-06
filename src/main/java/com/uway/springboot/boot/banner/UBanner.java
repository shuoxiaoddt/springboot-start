package com.uway.springboot.boot.banner;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Created by uwayxs on 2017/11/3.
 */
public class UBanner implements Banner{
    @Override
    public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
        printStream.println("哇哈哈哈哈哈");
        printStream.println("哇哈哈哈哈哈");
        printStream.println("哇哈哈哈哈哈");
    }
}
