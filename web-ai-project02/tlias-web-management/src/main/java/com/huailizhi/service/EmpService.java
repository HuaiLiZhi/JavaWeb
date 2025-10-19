package com.huailizhi.service;

import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> getPageResult(Integer page, Integer pageSize);
}
