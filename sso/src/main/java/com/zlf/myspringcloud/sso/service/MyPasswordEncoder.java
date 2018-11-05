package com.zlf.myspringcloud.sso.service;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/25 21:01
 * Description: ${DESCRIPTION}
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
