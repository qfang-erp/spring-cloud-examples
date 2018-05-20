package com.qfang.examples.spring.cloud.eureka.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-20
 * @since: 1.0
 */
@RestController
public class ErrorGatewayController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error() {
        return "{\"result\":\"service error!!!\"}";
    }

}
