package com.yh.cloud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从配置中心读取配置
 * RefreshScope: 刷新配置的功能，需要发送一次post请求，http://localhost:3355/actuator/refresh
 *
 * @author yanhuan
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
