package com.huailizhi.controller;

import com.huailizhi.pojo.JobOption;
import com.huailizhi.pojo.Result;
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
}
