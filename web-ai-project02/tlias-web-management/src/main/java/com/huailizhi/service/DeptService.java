package com.huailizhi.service;


import com.huailizhi.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void deleteById(Integer id);


    void insert(Dept dept);
}
