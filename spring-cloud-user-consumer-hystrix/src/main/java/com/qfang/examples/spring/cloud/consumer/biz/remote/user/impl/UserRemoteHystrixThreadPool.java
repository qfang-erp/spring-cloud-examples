package com.qfang.examples.spring.cloud.consumer.biz.remote.user.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-19
 * @since: 1.0
 */
@Component
public class UserRemoteHystrixThreadPool extends AbstractUserRemote {

    @HystrixCommand(groupKey="example-user-provider", commandKey = "listUser",
            threadPoolKey="example-user-provider",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),//线程池大小
                    @HystrixProperty(name = "maxQueueSize", value = "100"),//最大队列长度
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),//线程存活时间
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")//拒绝请求
            },
            fallbackMethod = "listUserFallback")
    @Override
    public List<User> listUser() {
        return userFacade.listUser();
    }

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @Override
    public User findById(long id) {
        return userFacade.findById(id);
    }

    @HystrixCommand(fallbackMethod = "saveUserFallback")
    @Override
    public void saveUser(User uer) {
        userFacade.saveUser(uer);
    }

}
