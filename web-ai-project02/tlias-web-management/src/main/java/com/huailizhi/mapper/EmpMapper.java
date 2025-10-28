package com.huailizhi.mapper;


import com.huailizhi.pojo.Emp;
import com.huailizhi.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/*
* 员工信息
* */
@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    Long getTotal();
//
//    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start}, #{pageSize}")
//    List<Emp> getRows(Integer start, Integer pageSize);

    /*
    * 查询员工信息
    * */
    List<Emp> list(EmpQueryParam empQueryParam);


    /*
    * 新增员工
    * */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)\n" +
            "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /*
    * 批量删除员工
    * */
    void deleteById(List<Integer> ids);

    /*
    * 根据id查询员工信息
    * */
    Emp getById(Integer id);

    /*
    * 修改员工信息
    * */
    void updateById(Emp emp);


    /*
    * 查询员工职位数量
    * */
    List<Map<String, Object>> countEmpJobData();

    /*
    * 查询员工性别数量
    * */
    List<Map<String, Object>> countEmpGenderData();
}
