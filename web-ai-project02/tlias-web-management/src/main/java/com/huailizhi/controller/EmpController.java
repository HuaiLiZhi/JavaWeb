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
import java.util.Arrays;
import java.util.List;

/*
* 员工管理的controller
* */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;


    /*
    * 分页查询员工信息
    * */
    @GetMapping
    public Result getPageResult(EmpQueryParam empQueryParam){
        log.info("分页查询:{}", empQueryParam);
        PageResult<Emp> pageResult = empService.getPageResult(empQueryParam);
        return Result.success(pageResult);
    }

    /*
    * 新增员工
    * */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工:{}", emp);
        empService.save(emp);
        return Result.success();
    }


//    @DeleteMapping
//    public Result delete(Integer[] ids){
//        log.info("删除员工：{}", Arrays.toString(ids));
//        return Result.success();
//    }

    /*
    * 批量删除员工
    * */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /*
    * 根据id查询员工信息
    * */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工信息：{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }


    /*
    * 修改员工信息
    * */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }

}
