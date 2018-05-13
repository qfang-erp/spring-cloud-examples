package com.qfang.examples.spring.cloud.user.consumer.controller;

import com.qfang.examples.spring.cloud.user.consumer.form.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-28
 * @since: 1.0
 */
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable long id) {
        return restTemplate.getForObject("http://spring-cloud-examples-user-provider/" + id, User.class);
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        // ribbon 负载均衡
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("spring-cloud-examples-user-provider");
        MovieController.LOGGER.info("{}:{}:{}",
                serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
