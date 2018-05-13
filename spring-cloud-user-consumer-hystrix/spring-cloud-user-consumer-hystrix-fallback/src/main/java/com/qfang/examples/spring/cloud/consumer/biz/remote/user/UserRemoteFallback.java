package com.qfang.examples.spring.cloud.consumer.biz.remote.user;

import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
public class UserRemoteFallback implements UserRemote {
    @Override
    public List<User> listUser() {
        return new ArrayList<User>();
    }

    @Override
    public User findById(long id) {
        return new User(-1L, "fallback");
    }

    @Override
    public boolean saveUser(User user) {
        return false;
    }
}
