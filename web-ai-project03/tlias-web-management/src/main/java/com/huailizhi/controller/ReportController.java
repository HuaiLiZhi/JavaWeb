package com.huailizhi.controller;

import com.huailizhi.pojo.JobOption;
import com.huailizhi.pojo.Result;
import com.huailizhi.pojo.StudentCount;
import com.huailizhi.service.ReportService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /*
    * 查询员工职位数量
    * */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("查询员工职位数量");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }


    /*
    * 查询员工性别数量
    * */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("查询员工性别数量");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }


    @GetMapping("/studentCountData")
    public Result getClazzCountData(){
        log.info("查询学生数量");
        Map<String, Object> studentCount = reportService.getStudentCountData();
        return Result.success(studentCount);
    }

    @GetMapping("/studentDegreeData")
    public Result getDegreeCountData(){
        log.info("查询学生学历数量");
        List<Map<String, Object>> degreeCount = reportService.getDegreeCount();
        return Result.success(degreeCount);
    }
}
