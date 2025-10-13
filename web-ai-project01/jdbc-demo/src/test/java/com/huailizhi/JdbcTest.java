package com.huailizhi;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01?serverTimezone=UTC";
        String username = "root";
        String password = "1221005a";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();

        //4.执行SQL
        int i = statement.executeUpdate("update user set age = 25 where id = 1");
        System.out.println("SQL执行完毕影响的记录数为：" + i);

        //5.释放资源
        statement.close();
        connection.close();
    }
}
