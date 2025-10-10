package com.huailizhi.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.huailizhi.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//@Component
@Repository//("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findAll() {
        //加载并读取resources中的user.txt文件，获取用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        return lines;
    }
}
