package com.yh.cloud.dept.service;

import com.yh.cloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
