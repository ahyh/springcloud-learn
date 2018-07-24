package com.yh.cloud.dept.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot主启动类
 *
 * @author yanhuan1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.yh.cloud"})
@ComponentScan("com.yh.cloud")
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
