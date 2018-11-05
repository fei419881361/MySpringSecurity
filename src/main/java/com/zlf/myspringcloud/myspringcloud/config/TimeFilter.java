package com.zlf.myspringcloud.myspringcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 22:05
 * Description: ${DESCRIPTION}
 */
@Component
public class TimeFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("time filter dofilter");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("time filter useTime:{}", new Date().getTime() - start);
        logger.info("time filter finish");
    }

    @Override
    public void destroy() {
        logger.info("time filter destroy");
    }
}
