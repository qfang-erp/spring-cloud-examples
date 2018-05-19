package com.qfang.examples.spring.cloud.consumer.biz.remote.user.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-19
 * @since: 1.0
 */
@Component
public class UserRemoteHystrixFallback extends AbstractUserRemote {

    @HystrixCommand(fallbackMethod = "listUserFallback")
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
