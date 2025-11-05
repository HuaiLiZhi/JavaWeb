package com.huailizhi.controller;

import com.huailizhi.anno.Log;
import com.huailizhi.pojo.PageResult;
import com.huailizhi.pojo.Result;
import com.huailizhi.pojo.Student;
import com.huailizhi.pojo.StudentQueryParam;
import com.huailizhi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result getPageResult(StudentQueryParam studentQueryParam){
        log.info("分页查询学生数据");
        PageResult<Student> studentList = studentService.getPageResult(studentQueryParam);
        return Result.success(studentList);
    }

    @Log
    @PostMapping
    public Result addStudent(@RequestBody Student student){
        log.info("添加学生数据：{}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable Integer id){
        log.info("查询id为{}的学生数据", id);
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }


    @Log
    @PutMapping
    public Result updateStudentById(@RequestBody Student student){
        log.info("修改id为{}的学生数据", student.getId());
        studentService.updateStudentById(student);
        return Result.success();
    }


    @Log
    @DeleteMapping("/{ids}")
    public Result deleteStudentsByIds(@PathVariable List<Integer> ids){
        log.info("删除id为{}的学生数据", ids);
        studentService.deleteStudentsByIds(ids);
        return Result.success();
    }

    @Log
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Short score){
        log.info("学生id为{}的学生违纪扣分{}分", id, score);
        studentService.violation(id, score);
        return Result.success();
    }
}