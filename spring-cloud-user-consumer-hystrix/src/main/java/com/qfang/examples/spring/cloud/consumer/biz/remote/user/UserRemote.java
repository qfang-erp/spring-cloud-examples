package com.qfang.examples.spring.cloud.consumer.biz.remote.user;

import com.qfang.examples.spring.cloud.user.provider.model.User;

import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
public interface UserRemote {

    List<User> listUser();

    User findById(long id);

    void saveUser(User uer);

}
