package com.qfang.examples.spring.cloud.consumer.biz.remote.user.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.qfang.examples.spring.cloud.consumer.biz.remote.user.UserRemote;
import com.qfang.examples.spring.cloud.user.provider.api.UserFacade;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-19
 * @since: 1.0
 */
@Component
public class UserRemoteHystrixBreak extends AbstractUserRemote {

    @HystrixCommand(fallbackMethod = "listUserFallback",   // 不支持注解在接口
            commandProperties = {
                    // 默认20个;10s内请求数大于20个时就启动熔断器，当请求符合熔断条件时将触发getFallback()。
                    @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value="10"),
                    // 请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发getFallback()。
                    @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value="50"),
                    // 默认5秒;熔断多少秒后去尝试请求
                    @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value="5000"),
            })
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
