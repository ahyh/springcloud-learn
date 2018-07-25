package com.yh.cloud.dept.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yh.cloud.dept.service.DeptService;
import com.yh.cloud.pojo.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * DeptController
 *
 * @author yanhuan1
 */
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet") //抛出异常后执行的方法，类中指定的方法
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("id:" + id + "对应的Dept为空!");
        }
        return dept;
    }

    /**
     * 熔断后处理方法
     *
     * @param id
     * @return
     */
    public Dept processHystrixGet(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该id:" + id + "没有对应的部门信息").setDb_source("no this in database");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    /**
     * 服务发现
     *
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("CLOUD-DEPT8001");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

}
