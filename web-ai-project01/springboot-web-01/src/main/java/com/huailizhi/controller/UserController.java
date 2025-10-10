package com.huailizhi.controller;

import cn.hutool.core.io.IoUtil;
import com.huailizhi.pojo.User;
import com.huailizhi.service.UserService;
import com.huailizhi.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    //方式1：属性注入
//    @Qualifier("userServiceImpl2")
    @Resource(name = "userServiceImpl2")
    @Autowired
    private UserService userService;

//    //方式2：构造器注入
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    //方式3：setter注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        List<User> userList = userService.findAll();
        //返回json数据
        return userList;
    }
}
