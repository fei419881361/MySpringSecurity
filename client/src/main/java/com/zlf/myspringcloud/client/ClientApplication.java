package com.zlf.myspringcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/30 20:30
 * Description: 模拟客户端服务
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class ClientApplication {
    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
