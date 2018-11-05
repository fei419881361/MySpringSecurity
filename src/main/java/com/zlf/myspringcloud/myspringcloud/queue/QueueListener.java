package com.zlf.myspringcloud.myspringcloud.queue;

import com.zlf.myspringcloud.myspringcloud.holder.DeferredResultHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 14:00
 * Description: 队列监听器 ContextRefreshedEvent:spring容器初始化完成的事件
 * 当容器启动完后就开始监听
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    MockQueue mockQueue;

    @Autowired
    DeferredResultHolder deferredResultHolder;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //放入线程 避免阻塞主线程
        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String orderNo = mockQueue.getCompleteOrder();
                    logger.info("处理订单orderNO:{}", orderNo);
                    mockQueue.setCompleteOrder(null);
                    logger.info("处理订单完成orderNo:{}", orderNo);
                    //异步处理完成 返回浏览器。
                    deferredResultHolder.getMap().get(orderNo).setResult("place order success");
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
