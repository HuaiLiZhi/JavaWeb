package com.huailizhi.mapper;

import com.huailizhi.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {



    /**
     * 查询所有用户信息
     * @return 用户列表
     */
//    @Select("select * from user")
    public List<User> findAll();

    /**
     * 根据ID删除用户信息
     * @param id 用户ID
     */
    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);


    /**
     * 插入用户信息
     * @param user 用户对象，包含用户名、密码、姓名和年龄
     * @return 插入成功的记录数
     */
    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public Integer insert(User user);


    /**
     * 根据ID更新用户信息
     * @param user 用户对象，包含需要更新的用户信息和用户ID
     */
    @Update("update user set username=#{username}, password=#{password}, name=#{name}, age=#{age} where id=#{id}")
    public void updateById(User user);


    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户对象，如果未找到则返回null
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}