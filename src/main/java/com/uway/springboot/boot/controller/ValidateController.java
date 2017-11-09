package com.uway.springboot.boot.controller;

import com.uway.springboot.boot.entity.UserInfo;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uwayxs on 2017/11/9.
 */
@RestController
public class ValidateController {

    @PostMapping("/validate/useradd")
    public UserInfo userAdd(@Valid UserInfo userInfo){
        return userInfo;
    }

}
