package com.yh.cloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Loader Balancer interface
 *
 * @author yanhuan
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instanceList);

}
