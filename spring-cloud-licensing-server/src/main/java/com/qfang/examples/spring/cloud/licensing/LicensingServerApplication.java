package com.qfang.examples.spring.cloud.licensing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-29
 * @since: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class LicensingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicensingServerApplication.class, args);
    }

}
