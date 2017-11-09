package com.uway.springboot.boot.validate;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created by uwayxs on 2017/11/9.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {UserInfoConstraintValidator.class}
)
public @interface CustomerUserInfoValidate {

    String message() default "{com.uway.springboot.boot.validate.CustomerUserInfoValidate.message}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}
