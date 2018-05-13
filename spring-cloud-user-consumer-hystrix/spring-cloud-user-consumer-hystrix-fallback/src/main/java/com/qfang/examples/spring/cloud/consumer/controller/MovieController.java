package com.qfang.examples.spring.cloud.consumer.controller;

import com.qfang.examples.spring.cloud.consumer.biz.remote.user.UserRemote;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    private UserRemote userRemote;

    @ResponseBody
    @GetMapping(value = "/user/list")
    List<User> listUser() {
        return userRemote.listUser();
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public User findById(@PathVariable long id) {
        return userRemote.findById(id);
    }

    @ResponseBody
    @PutMapping(value = "/user/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveUser(User user) {
        return userRemote.saveUser(user);
    }

}
