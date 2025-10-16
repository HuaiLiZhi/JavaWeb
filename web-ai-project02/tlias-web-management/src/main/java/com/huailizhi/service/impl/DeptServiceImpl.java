package com.huailizhi.service.impl;

import com.huailizhi.mapper.DeptMapper;
import com.huailizhi.pojo.Dept;
import com.huailizhi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
