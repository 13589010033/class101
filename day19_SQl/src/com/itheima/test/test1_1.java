package com.itheima.test;

import org.junit.Test;

import java.sql.*;

public class test1_1 {
    @Test
    public void demo() throws ClassNotFoundException, SQLException {

        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db", "root", "root");
        //编写SQL语句
        String sql="select * from user";
        //获取执行语句对象
        Statement stat = conn.createStatement();
        //调用方法执行语句并获得结果集
        ResultSet resu = stat.executeQuery(sql);
        //处理结果集
        while (resu.next()){
//            String name=resu.getString("username");
//            String password=resu.getString("password");
            System.out.println("用户名是:"+resu.getString("username")+",密码是:"+resu.getString("password"));
        }

        //释放资源
        if (resu!=null)
            resu.close();
        if (stat!=null)
            stat.close();
        if (conn!=null)
            conn.close();
    }
}
