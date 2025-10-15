package com.huailizhi;

import com.huailizhi.mapper.UserMapper;
import com.huailizhi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteById(){
        userMapper.deleteById(5);
    }


    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("huailizhi");
        user.setPassword("123456");
        user.setName("Huailizhi");
        user.setAge(18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(6);
        user.setUsername("huailizhi");
        user.setPassword("123456");
        user.setName("怀里之");
        user.setAge(18);
        userMapper.updateById(user);
    }

    @Test
    public void testFindByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("huailizhi", "123456");
        System.out.println(user);
    }

}
