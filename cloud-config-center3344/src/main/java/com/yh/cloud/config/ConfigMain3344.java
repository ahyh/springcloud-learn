package com.yh.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config Main Class
 *
 * @author yanhuan
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
