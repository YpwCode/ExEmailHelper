package com.ypw.code.java.ex.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ExEmailDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExEmailDemoApplication.class, args);
    }

}
