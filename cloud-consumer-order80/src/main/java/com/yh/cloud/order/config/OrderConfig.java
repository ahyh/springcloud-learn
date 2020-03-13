package com.yh.cloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Order Config Class
 *
 * @author yanhuan
 */
@Configuration
public class OrderConfig {

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
