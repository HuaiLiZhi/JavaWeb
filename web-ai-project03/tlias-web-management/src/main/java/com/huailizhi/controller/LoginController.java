package com.huailizhi.controller;

import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.LogInfo;
import com.huailizhi.pojo.Result;
import com.huailizhi.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* @Description: 登录控制类
* */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}", emp);
        LogInfo logInfo = empService.login(emp);
        if (logInfo != null){
            return Result.success(logInfo);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

}
