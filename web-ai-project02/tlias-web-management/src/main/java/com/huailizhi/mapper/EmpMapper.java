package com.huailizhi.mapper;


import com.huailizhi.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
* 员工信息
* */
@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long getTotal();

    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc limit #{start}, #{pageSize}")
    List<Emp> getRows(Integer start, Integer pageSize);
}
