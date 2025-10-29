package com.huailizhi.controller;

import com.huailizhi.pojo.Clazz;
import com.huailizhi.pojo.ClazzQueryParam;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /*
    * 分页查询班级数据
    * */
    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam){
        log.info("分页查询班级数据");
        PageResult<Clazz> pageResult = clazzService.list(clazzQueryParam);
        return Result.success(pageResult);
    }

    /*
    * 添加班级数据
    * */
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        log.info("添加班级数据：{}", clazz);
        clazzService.addClazz(clazz);
        return Result.success();
    }

    /*
    * 根据id查询班级数据
    * */
    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id){
        log.info("查询id为{}的班级数据", id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }




}
