package com.qfang.examples.spring.cloud.consumer.biz.remote.user;

import com.qfang.examples.spring.cloud.consumer.biz.remote.FeignLogConfiguration;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-13
 * @since: 1.0
 */
@FeignClient(name = "spring-cloud-examples-user-provider",
        configuration = FeignLogConfiguration.class,
        fallbackFactory = UserRemoteFallbackFactory.class)
public interface UserRemote {

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    List<User> listUser();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") long id);

    @RequestMapping(value = "/user/save", method = RequestMethod.PUT)
    boolean saveUser(@RequestBody User user);

}
