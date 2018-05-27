package com.qfang.examples.spring.cloud.consumer.security;

import org.springframework.security.core.GrantedAuthority;
import com.qfang.examples.spring.cloud.user.provider.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class ClientUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    private User user;

    public ClientUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public String getPassword() {
        // TODO mock password
        return "123456";
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
