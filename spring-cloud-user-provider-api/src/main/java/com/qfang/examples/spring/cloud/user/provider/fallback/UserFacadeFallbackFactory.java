package com.qfang.examples.spring.cloud.user.provider.fallback;

import com.qfang.examples.spring.cloud.user.provider.api.UserFacade;
import feign.hystrix.FallbackFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
@Component
public class UserFacadeFallbackFactory implements FallbackFactory<UserFacade> {

    private static final Logger LOGGER = Logger.getLogger(UserFacadeFallbackFactory.class);

    @Override
    public UserFacade create(Throwable throwable) {
        LOGGER.error("UserRemote: " + throwable.getMessage(), throwable);

        return new UserFacadeFallback();
    }
}
