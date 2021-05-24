package com.ypw.code.java.ex.email.aon;

import java.lang.annotation.*;

/**
 * @author: yangpengwei
 * @time: 2021/5/20 2:19 下午
 * @description 邮箱号注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EmailNumber {

    String value() default "";
}
