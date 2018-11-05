package com.zlf.myspringcloud.myspringcloud.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 22:47
 * Description: ${DESCRIPTION}
 */
@Aspect
@Component
public class TimeAspect {
    Logger logger = LoggerFactory.getLogger(getClass());
    //Controller 中的方法
    @Around("execution(* com.zlf.myspringcloud.myspringcloud.rest.TestEndpoints.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("aspect");
        Object result = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object o : args) {
                logger.info("method arg:{}", o);
            }
            Long start = new Date().getTime();
            result = proceedingJoinPoint.proceed();
            logger.info("aspect use time:{}", new Date().getTime() - start);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
