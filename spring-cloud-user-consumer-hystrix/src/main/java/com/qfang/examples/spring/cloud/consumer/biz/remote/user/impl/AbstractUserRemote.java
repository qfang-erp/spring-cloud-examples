package com.qfang.examples.spring.cloud.consumer.biz.remote.user.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qfang.examples.spring.cloud.consumer.biz.remote.user.UserRemote;
import com.qfang.examples.spring.cloud.user.provider.api.UserFacade;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-19
 * @since: 1.0
 */
public abstract class AbstractUserRemote implements UserRemote {

    protected static final Logger LOGGER = Logger.getLogger(UserRemoteHystrixFallback.class);

    @Autowired
    protected UserFacade userFacade;

    @Override
    @HystrixCommand(fallbackMethod = "findByUsernameFallback")
    public User findByUsername(String username) {
        return userFacade.findByUsername(username);
    }

    protected List<User> listUserFallback(Throwable t) {
        LOGGER.error("UserRemote#listUser error.", t);

        List<User> fallbackList = new ArrayList<>();
        fallbackList.add(new User(-1L, "AbstractUserRemote#listUserFallback"));
        return fallbackList;
    }

    protected User findByIdFallback(long id, Throwable t) {
        LOGGER.error("UserRemote#findByIdFallback error. id: " + id, t);
        return new User(-1L, "AbstractUserRemote#findByIdFallback");
    }

    protected User findByUsernameFallback(String username, Throwable t) {
        LOGGER.error("UserRemote#findByIdFallback error. username: " + username, t);
        return new User(-1L, "AbstractUserRemote#findByUsernameFallback");
    }

    protected void saveUserFallback(Throwable t) {
        LOGGER.error("UserRemote#saveUserFallback error.", t);
    }

}
