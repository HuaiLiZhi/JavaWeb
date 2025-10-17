package com.huailizhi.controller;

import com.huailizhi.pojo.Dept;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping(value = "/depts")
    public Result findAll(){
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping(value = "/depts")
    public Result deleteById(Integer id){
        System.out.println("根据ID删除部门：" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping(value = "/depts")
    public Result insert(@RequestBody Dept dept){
        System.out.println("插入部门数据：" + dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping(value = "/dept/1")
    public Result findById(Integer id){
        System.out.println("查询id为"+ id +"的部门数据");
    }
}
