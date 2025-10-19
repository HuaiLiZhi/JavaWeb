package com.huailizhi.service.impl;

import com.huailizhi.mapper.EmpMapper;
import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> getPageResult(Integer page, Integer pageSize) {
        Long total = empMapper.getTotal();
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.getRows(start, pageSize);
        return new PageResult<>(total, rows);
    }
}
