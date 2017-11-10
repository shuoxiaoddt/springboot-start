package com.uway.springboot.boot.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Created by uwayxs on 2017/11/10.
 */
@Component
public class CustomerMailSender {

    @Autowired
    private JavaMailSender javaMailSender;
    private String[] senders ;

    public CustomerMailSender(){
        senders = new String[]{"394661930@qq.com"};
    }

    public void sendSimpleMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("shuoxiaoddt@163.com");
        mailMessage.setTo(senders);
        mailMessage.setSubject("测试邮件");
        mailMessage.setText("邮件内容");
        javaMailSender.send(mailMessage);
    }


}
