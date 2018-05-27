package com.qfang.examples.spring.cloud.consumer.security;

import com.qfang.examples.spring.cloud.consumer.biz.remote.user.UserRemote;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    @Qualifier("userRemoteHystrixSemaphore")
    private UserRemote userRemote;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRemote.findByUsername(username);
        if (user == null || user.getId() == -1) {
            throw new UsernameNotFoundException("invalid username or password");
        }
        return new ClientUserDetails(user);
    }

}
