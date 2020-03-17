package com.yh.cloud.feign.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yh.cloud.feign.hystrix.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Order Hystrix Controller
 * <p>
 * DefaultProperties全局接口的fallback，需要在使用这个降级方法上加HystrixCommand注解即可
 *
 * @author yanhuan
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * HystrixCommand使用全局的降级方法来处理服务降级
     */
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/get/{id}")
    public String get(@PathVariable("id") Integer id) {
        String infoSuccess = paymentHystrixService.get(id);
        //抛出异常，验证服务降级是否使用global fallback方法
        //int i = 10/0;
        return infoSuccess;
    }

    /**
     * HystrixCommand单独方法对应的降级方案
     */
    @HystrixCommand(fallbackMethod = "failureHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @GetMapping(value = "/consumer/payment/get/f/{id}")
    public String getF(@PathVariable("id") Integer id) {
        String infoFailure = paymentHystrixService.getF(id);
        return infoFailure;
    }

    public String failureHandler(@PathVariable("id") Integer id) {
        return "consumer failureHandler" + id;
    }

    public String globalFallback() {
        return "global fallback";
    }
}
