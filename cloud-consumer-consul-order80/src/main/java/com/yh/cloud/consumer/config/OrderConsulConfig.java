package com.yh.cloud.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Consul Consumer Config Class
 *
 * @author yanhuan
 */
@Configuration
public class OrderConsulConfig {


    /**
     * LoadBalanced enable load balance
     *
     * @return a bean named restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
