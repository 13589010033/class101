package com.itheima.test;

import org.junit.Test;

import java.sql.*;

public class TryCatchFindAllUser {
    //1.注册驱动
    //2.用驱动管理器获得连接(DriverManager.getConnection)
    //3.编写SQL语句
    //4.获取用获得的连接对象调用执行SQL语句的方法
    //5.执行SQL语句并且获得了结果集对象
    //6.处理结果集对象(也就是while循环迭代器思想(指针思想next))
    //7.使用try catch 方法释放资源
    @Test
    public void demo(){
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
    try {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver这是固定的必须记住
        // 获取连接
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db", "root", "root");
        // 编写SQL语句                          jdbc:mysql://localhost:3306/day19_db----//容易出错**切记***
        //String sql="select * from user";
        // 获取执行语句对象
         stat = conn.createStatement();
        // 执行语句并且得到结果集
        //rs = stat.executeQuery(sql);
        rs = stat.executeQuery("select * from user");
        // 处理结果集
        while (rs.next()){
            System.out.println("用户名:"+rs.getString("username")+",密码是:"+rs.getString("password"));
        //用户名:jack,密码是:123
            //        用户名:rose,密码是:234
            //        用户名:tom,密码是:345
            //        用户名:lucy,密码是:456
        }
        // 释放资源
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat!=null){
            try {
                stat.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    }

}
