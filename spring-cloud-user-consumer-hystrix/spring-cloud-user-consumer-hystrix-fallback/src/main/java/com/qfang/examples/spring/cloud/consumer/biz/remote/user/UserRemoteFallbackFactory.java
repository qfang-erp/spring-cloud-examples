package com.qfang.examples.spring.cloud.consumer.biz.remote.user;

import feign.hystrix.FallbackFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
@Component
public class UserRemoteFallbackFactory implements FallbackFactory<UserRemote> {

    private static final Logger LOGGER = Logger.getLogger(UserRemoteFallbackFactory.class);

    @Override
    public UserRemote create(Throwable throwable) {
        LOGGER.error("UserRemote: " + throwable.getMessage(), throwable);

        return new UserRemoteFallback();
    }
}
