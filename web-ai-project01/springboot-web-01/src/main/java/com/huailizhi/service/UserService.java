package com.huailizhi.service;

import com.huailizhi.pojo.User;
import jakarta.annotation.Resource;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return 用户信息列表
     */

    public List<User> findAll();
}
