package com.huailizhi.service;

import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.EmpQueryParam;
import com.huailizhi.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

//    PageResult<Emp> getPageResult(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
    PageResult<Emp> getPageResult(EmpQueryParam empQueryParam);

}
