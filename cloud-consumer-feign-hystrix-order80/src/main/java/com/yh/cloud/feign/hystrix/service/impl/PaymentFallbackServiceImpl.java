package com.yh.cloud.feign.hystrix.service.impl;

import com.yh.cloud.feign.hystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 专门用于编写Hystrix服务降级代码的类
 *
 * @author yanhuan
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String get(Integer id) {
        return "PaymentFallbackServiceImpl get fallback: " + id;
    }

    @Override
    public String getF(Integer id) {
        return "PaymentFallbackServiceImpl getF fallback: " + id;
    }
}
