package com.qfang.examples.spring.cloud.consumer.controller;

import com.qfang.examples.spring.cloud.consumer.biz.remote.user.UserRemote;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-28
 * @since: 1.0
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    @Qualifier("userRemoteHystrixSemaphore")
    private UserRemote userRemote;

    @ResponseBody
    @GetMapping(value = "/user/list")
    public List<User> listUser() {
        return userRemote.listUser();
    }

    @ResponseBody
    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable long id) {
        return userRemote.findById(id);
    }

}
