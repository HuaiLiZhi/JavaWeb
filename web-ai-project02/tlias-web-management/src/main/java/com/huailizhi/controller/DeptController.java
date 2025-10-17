package com.huailizhi.controller;

import com.huailizhi.pojo.Dept;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result findAll(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result deleteById(Integer id){
        log.info("根据ID删除部门：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("插入部门数据：{}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询id为{}的部门数据", id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateById(@RequestBody Dept dept){
        log.info("更新id为{}的部门数据", dept.getId());
        deptService.updateById(dept);
        return Result.success();
    }
}
