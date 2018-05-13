package com.qfang.examples.spring.cloud.consumer.biz.remote;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

}
