package com.yh.cloud.feign.hystrix.service;

import com.yh.cloud.feign.hystrix.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface
 *
 * @author yanhuan
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/get/{id}")
    String get(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/get/f/{id}")
    String getF(@PathVariable("id") Integer id);
}
