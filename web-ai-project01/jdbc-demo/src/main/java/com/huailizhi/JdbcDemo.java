package com.huailizhi;

import com.huailizhi.pojo.User;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/web01?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "1221005a";
        
        // 要查询的用户信息
        String queryUsername = "daqiao";
        String queryPassword = "123456";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // 1. 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. 打开连接
            conn = DriverManager.getConnection(url, username, password);
            
            // 3. 执行查询
            String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, queryUsername);
            stmt.setString(2, queryPassword);
            
            rs = stmt.executeQuery();
            
            // 4. 处理结果集
            while (rs.next()) {
                // 封装数据到User对象
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                
                // 输出User对象数据到控制台
                System.out.println("查询到的用户信息:");
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Name: " + user.getName());
                System.out.println("Age: " + user.getAge());
                System.out.println("------------------------");
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}