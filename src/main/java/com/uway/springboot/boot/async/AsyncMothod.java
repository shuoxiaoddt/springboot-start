package com.uway.springboot.boot.async;

import java.util.Random;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by uwayxs on 2017/11/10.
 */
@Component
public class AsyncMothod {
    @Async
    public void task1(){
        try {
            System.out.println("task1() start");
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task1() end");
    }
    @Async
    public void task2(){
        try {
            System.out.println("task2() start");
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task2() end");
    }
    @Async
    public void task3(){
        try {
            System.out.println("task3() start");
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task3() end");
    }


}
