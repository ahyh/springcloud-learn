package com.yh.cloud.dept.consumer.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 *
 * @author yanhuan1
 */
@Configuration
public class CfgBean {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
