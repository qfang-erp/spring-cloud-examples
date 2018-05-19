package com.qfang.examples.spring.cloud.consumer.biz.remote.user.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 信号量隔离
 *
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-19
 * @since: 1.0
 */
@Component
public class UserRemoteHystrixSemaphore extends AbstractUserRemote {

    @HystrixCommand(fallbackMethod = "listUserFallback",
            commandProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"),// 信号量 隔离
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "100"), //信号量最大并发度
                    @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "200000")  // fallback 最大并发度
            })
    @Override
    public List<User> listUser() {
        return userFacade.listUser();
    }

    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "200000")  // fallback 最大并发度
    })
    @Override
    public User findById(long id) {
        return userFacade.findById(id);
    }

    @Override
    public void saveUser(User uer) {
        userFacade.saveUser(uer);
    }
}
