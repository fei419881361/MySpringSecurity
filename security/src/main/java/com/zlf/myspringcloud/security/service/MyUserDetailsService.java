package com.zlf.myspringcloud.security.service;

import com.zlf.myspringcloud.security.util.MyPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/28 9:44
 * Description: ${DESCRIPTION}
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("登录名：{}", userName);
        //数据库操作
        String pwd = new MyPasswordEncoder().encode("123456");
        String role = "admin";
        //User user = new User(userName, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList(role));
        //处理用户状态信息 冻结 锁定 过期
        User user = new User(userName, pwd,
                true, true, true, true
                ,AuthorityUtils.commaSeparatedStringToAuthorityList(role));
        return user;
    }

}
