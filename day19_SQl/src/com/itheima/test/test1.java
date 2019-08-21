package com.itheima.test;

import org.junit.Test;

import java.sql.*;

////1.注册驱动
//        //2.建立连接
//        //3.编写SQL语句
//        //4.获得执行SQL语句的对象
//        //5.使用执行SQL语句对象调用方法执行SQL语句
//        //6.处理结果集
//        //7.释放资源
public class test1 {
    @Test
    public void demo01() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//暂时可以理解为固定格式
        //2.建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db", "root", "root");
        System.out.println(conn);//com.mysql.jdbc.JDBC4Connection@4c15e7fd
        //3.编写SQL语句(首先需要给用一个字符串接收)
        String sql="select * from user";
        //4.获得执行SQL语句的对象
        Statement atmt = conn.createStatement();
        //5.使用执行SQL语句对象调用方法执行SQL语句
        ResultSet rs = atmt.executeQuery(sql);
        //6.处理结果集
        while (rs.next()){
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println("用户名:"+username+",密码是:"+password);
            //System.out.println("用户名是:"+rs.getString("username")+",密码是:"+rs.getString("password"));

        }
        //7.释放资源
        if(rs!=null){
            rs.close();
        }
        if (atmt!=null)
            atmt.close();
        if (conn!=null)
            conn.close();

    }

}
