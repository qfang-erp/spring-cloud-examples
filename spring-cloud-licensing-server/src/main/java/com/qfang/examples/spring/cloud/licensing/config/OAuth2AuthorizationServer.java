package com.qfang.examples.spring.cloud.licensing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认证服务器配置 - 基于授权码模式
 *
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-27
 * @since: 1.0
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("licensing-server")
                .secret("112233")
                .redirectUris("http://127.0.0.1:9001/callback")
                .authorizedGrantTypes("authorization_code", "refresh_token")  // 授权码模式
                .scopes("webClient", "mobileClient");
    }
}
