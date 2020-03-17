package com.yh.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main Class
 * EnableCircuitBreaker: 回路，使用Hystrix服务降级
 *
 * @author yanhuan
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix8001.class, args);
    }
}
