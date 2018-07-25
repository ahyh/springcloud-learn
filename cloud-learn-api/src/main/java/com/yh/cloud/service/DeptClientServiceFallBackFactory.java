package com.yh.cloud.service;

import com.yh.cloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实现熔断机制的解耦
 *
 * @author yanhuan1
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该id:" + id + "没有对应的部门信息").setDb_source("no this in database");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
