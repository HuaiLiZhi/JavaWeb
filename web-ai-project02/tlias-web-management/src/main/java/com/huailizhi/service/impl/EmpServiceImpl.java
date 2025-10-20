package com.huailizhi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huailizhi.mapper.EmpMapper;
import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.EmpQueryParam;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageResult<Emp> getPageResult(Integer page, Integer pageSize) {
//        Long total = empMapper.getTotal();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.getRows(start, pageSize);
//        return new PageResult<>(total, rows);
//    }

    @Override
    public PageResult<Emp> getPageResult(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> empList = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) empList;

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
