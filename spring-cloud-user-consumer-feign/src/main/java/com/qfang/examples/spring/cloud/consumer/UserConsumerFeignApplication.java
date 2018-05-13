package com.qfang.examples.spring.cloud.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-12
 * @since: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class UserConsumerFeignApplication {

    @Bean
    public IRule ribbonRule() {
        // 设置 ribbon 的负载均衡算法，使用随机算法
        return new RandomRule();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerFeignApplication.class, args);
    }

}
