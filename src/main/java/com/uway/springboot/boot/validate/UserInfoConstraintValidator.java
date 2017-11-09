package com.uway.springboot.boot.validate;

import com.uway.springboot.boot.entity.UserInfo;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by uwayxs on 2017/11/9.
 */
@Component
public class UserInfoConstraintValidator
        implements ConstraintValidator<CustomerUserInfoValidate,UserInfo> {

    @Override
    public void initialize(CustomerUserInfoValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserInfo userInfo, ConstraintValidatorContext constraintValidatorContext) {
        if (userInfo.getUid() > 10000){
            return false;
        }else if(StringUtils.hasText(userInfo.getUsername())){
            return false;
        }
        return true;
    }
}
