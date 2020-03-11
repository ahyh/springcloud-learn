package com.yh.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server
 *
 * @author yanhuan
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceMain7002.class, args);
    }
}
