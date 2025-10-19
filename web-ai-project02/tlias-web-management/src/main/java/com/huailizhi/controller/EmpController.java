package com.huailizhi.controller;

import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result getPageResult(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询:{}, {}", page, pageSize);
        PageResult<Emp> pageResult = empService.getPageResult(page, pageSize);
        return Result.success(pageResult);
    }
}
