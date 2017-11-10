package com.uway.springboot.boot.controller;

import com.uway.springboot.boot.entity.UserInfo;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uwayxs on 2017/11/9.
 */
@RestController
public class ValidateController {

    @PostMapping("/validate/useradd")
    public Map<String,Object> userAdd(@Valid UserInfo userInfo, BindingResult result){
        Map<String,Object> resultMap = new HashMap<>();
        if(result.hasErrors()){
            resultMap.put("message","error");
            resultMap.put("data",result.getAllErrors());
            return resultMap;
        }
        resultMap.put("message","success");
        resultMap.put("data",userInfo);
        return resultMap;
    }

}
