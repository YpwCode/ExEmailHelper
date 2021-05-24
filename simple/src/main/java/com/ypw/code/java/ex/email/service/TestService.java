package com.ypw.code.java.ex.email.service;

import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;

@Service
public class TestService {

    public void test(Integer type) throws Exception {
        switch (type) {
            case 0: throw new NumberFormatException("number");
            case 1: throw new NullPointerException("null");
            case 2: throw new InvalidPropertiesFormatException("invalid");
            default:
        }
    }
}
