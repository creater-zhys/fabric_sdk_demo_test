package com.example.demo.aspect;

import com.example.demo.common.Enum.UserTypeEnum;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RequireAuth {
    UserTypeEnum role() default UserTypeEnum.UNKNOWN;
}
