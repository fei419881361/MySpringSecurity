package com.zlf.myspringcloud.myspringcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 22:28
 * Description: ${DESCRIPTION}
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("time interceptor pre");
        request.setAttribute("startTime", new Date().getTime());
        logger.info(((HandlerMethod)handler).getBean().toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("time interceptor post");
        Long startTime = (Long) request.getAttribute("startTime");
        logger.info("time use:{}", new Date().getTime() - startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("time interceptor after");
        Long startTime = (Long) request.getAttribute("startTime");
        logger.info("after time use:{}", new Date().getTime() - startTime);
    }
}
