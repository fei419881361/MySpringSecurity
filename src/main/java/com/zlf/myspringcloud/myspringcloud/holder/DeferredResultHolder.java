package com.zlf.myspringcloud.myspringcloud.holder;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:     zhanglingfei
 * Date:     2018/10/27 13:51
 * Description: ${DESCRIPTION}
 */
@Component
public class DeferredResultHolder {
    //key:订单号 value:订单的处理结果
    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
