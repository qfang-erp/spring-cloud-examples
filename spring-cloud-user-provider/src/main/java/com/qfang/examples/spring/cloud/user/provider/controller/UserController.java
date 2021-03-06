package com.qfang.examples.spring.cloud.user.provider.controller;

import com.qfang.examples.spring.cloud.user.provider.api.UserFacade;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import com.qfang.examples.spring.cloud.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-28
 * @since: 1.0
 */
@RestController
public class UserController implements UserFacade {
    @Autowired
    private UserService userService;

    @Override
    public List<User> listUser() {
        return userService.listUser();
    }

    public User findById(@PathVariable long id) {
        System.out.println("### provider master #####");
        return userService.findById(id);
    }

    @Override
    public User findByUsername(@RequestParam("username") String username) {
        return userService.findByUsername(username);
    }

    @Override
    public boolean saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @Override
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(@PathVariable long id) {
        this.userService.deleteUser(id);
        return true;
    }

}
