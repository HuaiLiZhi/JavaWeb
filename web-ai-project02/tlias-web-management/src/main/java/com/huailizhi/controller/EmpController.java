package com.huailizhi.controller;

import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.EmpQueryParam;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/*
* 员工管理的controller
* */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result getPageResult(EmpQueryParam empQueryParam){
        log.info("分页查询:{}", empQueryParam);
        PageResult<Emp> pageResult = empService.getPageResult(empQueryParam);
        return Result.success(pageResult);
    }


}
