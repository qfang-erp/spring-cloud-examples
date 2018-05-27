package com.qfang.examples.spring.cloud.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-12
 * @since: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.qfang.examples.spring.cloud.user.provider.api"})
@EnableEurekaClient
@EnableCircuitBreaker  // 开启服务降级断路器
@EnableHystrix
@EnableHystrixDashboard
public class UserConsumerHystrixApplication {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerHystrixApplication.class, args);
    }

}
