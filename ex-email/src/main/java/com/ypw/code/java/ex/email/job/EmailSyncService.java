package com.ypw.code.java.ex.email.job;

import com.ypw.code.java.ex.email.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author: yangpengwei
 * @time: 2021/5/24 11:30 上午
 * @description 异步邮件服务
 */
@Component
@EnableAsync
public class EmailSyncService {

    @Autowired
    private IMailService mailService;

    @Async
    public void sendByEx(Exception e) {
        mailService.sendByEx(e);
    }
}
