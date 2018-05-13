package com.qfang.examples.spring.cloud.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-12
 * @since: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker  // 开启服务降级断路器
public class UserConsumerHystrixFallbackApplication {

    @Bean
    public IRule ribbonRule() {
        // 设置 ribbon 的负载均衡算法，使用随机算法
        return new RoundRobinRule();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerHystrixFallbackApplication.class, args);
    }

}
