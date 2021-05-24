package com.ypw.code.java.ex.email.ex;

import com.ypw.code.java.ex.email.job.EmailSyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: yangpengwei
 * @time: 2021/5/19 5:41 下午
 * @description 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private EmailSyncService emailSyncService;

    @ExceptionHandler(Exception.class)
    public Exception onEx(Exception e) {
        emailSyncService.sendByEx(e);
        return e;
    }
}
