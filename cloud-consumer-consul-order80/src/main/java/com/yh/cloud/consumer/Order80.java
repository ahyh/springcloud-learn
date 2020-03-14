package com.yh.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consul Consumer Run Class
 *
 * @author yanhuan
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class, args);
    }
}
