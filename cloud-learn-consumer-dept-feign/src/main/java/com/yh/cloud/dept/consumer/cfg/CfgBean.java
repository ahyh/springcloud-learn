package com.yh.cloud.dept.consumer.cfg;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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

    /**
     * 负载均衡
     *
     * @return 向Spring容器中注入restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 使用随机算法代替轮询算法
     * @return 自己定义的算法
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
