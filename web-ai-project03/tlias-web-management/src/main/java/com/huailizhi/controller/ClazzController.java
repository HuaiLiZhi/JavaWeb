package com.huailizhi.controller;

import com.huailizhi.anno.Log;
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
    public Result getPageResult(ClazzQueryParam clazzQueryParam){
        log.info("分页查询班级数据");
        PageResult<Clazz> pageResult = clazzService.getPageResult(clazzQueryParam);
        return Result.success(pageResult);
    }

    /*
    * 添加班级数据
    * */
    @Log
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

    /*
    * 修改班级数据
    * */
    @Log
    @PutMapping
    public Result updateClazzById(@RequestBody Clazz clazz){
        log.info("修改id为{}的班级数据", clazz.getId());
        clazzService.updateClazzById(clazz);
        return Result.success();
    }


    /*
    * 删除班级数据
    * */
    @Log
    @DeleteMapping("/{id}")
    public Result deleteClazzById(@PathVariable Integer id){
        log.info("删除id为{}的班级数据", id);
        clazzService.deleteClazzById(id);
        return Result.success();
    }


    /*
    * 查询所有班级数据
    * */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级数据");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }


}