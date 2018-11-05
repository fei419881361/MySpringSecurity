package com.zlf.myspringcloud.security.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/28 9:21
 * Description: ${DESCRIPTION}
 */
@RestController
public class UserController {
    @RequestMapping("/user")
    public String user(){
        return "hello user";
    }
}
