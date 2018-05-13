package com.qfang.examples.spring.cloud.user.provider.dao;

import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-28
 * @since: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
