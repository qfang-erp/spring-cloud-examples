package com.qfang.examples.spring.cloud.user.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-21
 * @since: 1.0
 */
//@RestController
public class ConfigTestController {

    @Value("${adminName}")
    private String adminName;

    @GetMapping("/user/config")
    public String config() {
        return this.adminName;
    }

}
