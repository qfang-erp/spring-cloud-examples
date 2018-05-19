package com.qfang.examples.spring.cloud.user.provider.fallback;

import com.qfang.examples.spring.cloud.user.provider.api.UserFacade;
import com.qfang.examples.spring.cloud.user.provider.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
public class UserFacadeFallback implements UserFacade {
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

    @Override
    public void updateUser(User user) {

    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }
}
