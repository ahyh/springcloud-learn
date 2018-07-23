package com.yh.cloud.dept.consumer;

import com.yh.cloud.dept.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * SpringBoot主启动类
 *
 * @author yanhuan1
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
