package com.zlf.myspringcloud.myspringcloud.rest;

import com.zlf.myspringcloud.myspringcloud.holder.DeferredResultHolder;
import com.zlf.myspringcloud.myspringcloud.queue.MockQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 13:27
 * Description: rest接口异步处理业务逻辑例子
 */
@RestController
public class AsynController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MockQueue mockQueue;
    @Autowired
    DeferredResultHolder deferredResultHolder;

    @RequestMapping("/asyn")
    public DeferredResult<String> asyn() throws InterruptedException {
        logger.info("主线程开始");
        //模拟生成一个订单号
        String orderNo = UUID.randomUUID().toString();
        mockQueue.setPlaceOrder(orderNo);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNo, result);
//        Callable<String> result = () -> {
//            logger.info("副线程开始");
//            Thread.sleep(1000);
//            logger.info("副线程结束");
//            return "success";
//        };
        logger.info("主线程结束");
        return result;
    }
}
