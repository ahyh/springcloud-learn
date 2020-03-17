package com.yh.cloud.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yh.cloud.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Payment Service Impl
 *
 * @author yanhuan
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String getInfoSuccess(Integer id) {
        return id + "ok";
    }

    /**
     * HystrixCommand 服务降级，超时了超过3秒后调用failureHandler方法
     */
    @HystrixCommand(fallbackMethod = "failureHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String getInfoFailure(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("sleep:{}", e);
        }
        return id + "failure";
    }

    public String failureHandler(Integer id) {
        return "provider failureHandler" + id;
    }

    //------------服务熔断-------------
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id cannot less 0");
        }
        String serial = UUID.randomUUID().toString();
        return "success:" + serial;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id cannot less 0";
    }
}
