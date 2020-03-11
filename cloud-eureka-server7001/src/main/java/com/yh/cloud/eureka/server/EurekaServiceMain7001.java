package com.yh.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka server 7001
 *
 * @author yanhuan
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceMain7001.class, args);
    }
}
