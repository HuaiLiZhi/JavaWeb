package com.huailizhi.service.impl;

import com.huailizhi.dao.UserDao;
import com.huailizhi.dao.impl.UserDaoImpl;
import com.huailizhi.pojo.User;
import com.huailizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<String> lines = userDao.findAll();

        //解析用户信息，封装为User对象 -> list集合
        List<User> userList = lines.stream().map(line -> {
            String[] split = line.split(",");
            Integer id = Integer.parseInt(split[0]);
            String username = split[1];
            String password = split[2];
            String name = split[3];
            Integer age = Integer.parseInt(split[4]);
            LocalDateTime updateTime = LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();

        return userList;
    }
}
