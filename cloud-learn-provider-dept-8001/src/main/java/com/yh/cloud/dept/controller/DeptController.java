package com.yh.cloud.dept.controller;

import com.yh.cloud.dept.service.DeptService;
import com.yh.cloud.pojo.Dept;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/dept/add", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }


}
