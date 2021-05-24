package com.ypw.code.java.ex.email.aon;

import java.lang.reflect.Method;

/**
 * @author: yangpengwei
 * @time: 2021/5/24 11:29 上午
 * @description 注解处理类
 */
public class EmailNumberHelper {

    public static String getEmailNumber(Class<?> clazz, String methodName) {
        EmailNumber number;
        try {
            Method method = clazz.getDeclaredMethod(methodName);
            number = method.getAnnotation(EmailNumber.class);
            if (number != null) {
                return number.value();
            }
        } catch (NoSuchMethodException e) {}

        number = clazz.getAnnotation(EmailNumber.class);
        if (number != null) {
            return number.value();
        }
        return "";
    }
}
