package com.ypw.code.java.ex.email.service;

import com.ypw.code.java.ex.email.aon.EmailNumberHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${my.email.username}")
    private String fromMail;

    @Value("${my.email.global-to}")
    private String globalToMail;

    @Value("${my.project-name}")
    private String projectName;

    @Override
    public boolean sendByEx(Exception ex) {
        // 构建一个邮件对象
        SimpleMailMessage message = exToMessage(ex);
        // 发送邮件
        javaMailSender.send(message);
        return true;
    }

    private SimpleMailMessage exToMessage(Exception ex) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String subject = projectName + "异常提醒";
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSentDate(new Date());
        setMessageToAndCcByEx(ex, simpleMailMessage);
        return simpleMailMessage;
    }

    private void setMessageToAndCcByEx(Exception ex,  SimpleMailMessage simpleMailMessage) {
        StringBuilder sb = new StringBuilder();
        String toEmailNumber = null;
        List<String> toCcEmailNumbers = new ArrayList<>();
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\n");
            try {
                Class<?> clazz = Class.forName(stackTraceElement.getClassName());
                String methodName = stackTraceElement.getMethodName();
                String emailNumber = EmailNumberHelper.getEmailNumber(clazz,methodName);
                if (!emailNumber.isEmpty()) {
                    if (toEmailNumber == null) {
                        toEmailNumber = emailNumber;
                    } else {
                        toCcEmailNumbers.add(emailNumber);
                    }
                }
            } catch (ClassNotFoundException ignored) { }
        }

        if (toEmailNumber == null) {
            toEmailNumber = globalToMail;
        }
        simpleMailMessage.setTo(toEmailNumber);

        if (!toCcEmailNumbers.isEmpty()) {
            simpleMailMessage.setCc(toCcEmailNumbers.toArray(new String[0]));
        }

        simpleMailMessage.setText(sb.toString());
    }
}
