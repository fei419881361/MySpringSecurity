package com.zlf.myspringcloud.myspringcloud.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 13:43
 * Description: mock一个消息队列
 */
@Component
public class MockQueue {
    Logger logger = LoggerFactory.getLogger(getClass());
    //代表下单
    private String placeOrder;
    //代表下单完成
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() ->{
            logger.info("收到下单 placeOrder:{}", placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕");
            this.placeOrder = placeOrder;
        }).start();
    }


    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }

    @Override
    public String toString() {
        return "MockQueue{" +
                "placeOrder='" + placeOrder + '\'' +
                ", completeOrder='" + completeOrder + '\'' +
                '}';
    }
}
