package com.zlf.myspringcloud.security.config;

import com.zlf.myspringcloud.security.service.MyUserDetailsService;
import com.zlf.myspringcloud.security.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/28 9:18
 * Description: ${DESCRIPTION}
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录所有的请求都需要身份认证
        http.formLogin()
                //自定义登录页面
                .loginPage("/loginPage.html")
                //自定义发起的请求路径
                .loginProcessingUrl("/authentication/form")
                //自定义登录成功的处理handler
                .successHandler(myAuthenticationSuccessHandler)
                //自定义登录失败的handler
                .failureHandler(myAuthenticationFailureHandler)
         // http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/loginPage.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }

    //解决密码的编码问题
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new MyUserDetailsService()).passwordEncoder(new MyPasswordEncoder());
    }
}
