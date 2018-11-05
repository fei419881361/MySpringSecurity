package com.zlf.myspringcloud.sso.config;

import com.zlf.myspringcloud.sso.service.MyPasswordEncoder;
import com.zlf.myspringcloud.sso.service.SsoUserDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author:     zhanglingfei
 * Date:     2018/11/4 14:30
 * Description: ${DESCRIPTION}
 */
@Configuration
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests().anyRequest().authenticated();
    }
    //解决密码的编码问题
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new SsoUserDetails()).passwordEncoder(new MyPasswordEncoder());
    }
}
