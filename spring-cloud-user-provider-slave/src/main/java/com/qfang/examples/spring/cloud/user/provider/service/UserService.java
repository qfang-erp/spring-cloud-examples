package com.qfang.examples.spring.cloud.user.provider.service;

import com.qfang.examples.spring.cloud.user.provider.dao.UserRepository;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-28
 * @since: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUser() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return this.userRepository.findOne(id);
    }

    @Transactional
    public boolean saveUser(User user) {
        this.userRepository.save(user);
        return true;
    }

    @Transactional
    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    @Transactional
    public boolean deleteUser(long id) {
        this.userRepository.delete(id);
        return true;
    }

}
