package com.ypw.code.java.ex.email.controller;

import com.ypw.code.java.ex.email.aon.EmailNumber;
import com.ypw.code.java.ex.email.service.TestService;
import com.ypw.code.java.ex.email.vo.ApiRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EmailNumber("ypwcode@126.com")
@RestController
public class ExController {

    @Autowired
    private TestService testService;

    @EmailNumber("ypwcode@yeah.net")
    @GetMapping("/ex")
    public ApiRespVo get(@RequestParam(defaultValue = "-1") Integer type) throws Exception {
        testService.test(type);
        return new ApiRespVo();
    }
}
