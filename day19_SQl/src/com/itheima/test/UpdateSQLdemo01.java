package com.itheima.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSQLdemo01 {
    @Test
    public void demo(){
        Statement st=null;
        Connection con=null;
         try {
             //1.注册驱动
             Class.forName("com.mysql.jdbc.Driver");
             //2.用驱动管理来获取连接(DriverManager.getconnection)
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db", "root", "root");
             //3.编写SQL语句
             String sql="update user set password='789' where username='lucy'";
             //4.获取执行SQL语句的对象
              st = con.createStatement();
             //5.调用方法执行SQL语句并且返回的是结果集对象
             int i = st.executeUpdate(sql);
             //6.处理结果集对象
            if(i>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
             //7.用try 和catch 来释放资源
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             if (st!=null){
                 try {
                     st.close();
                 }catch(Exception e){
                     e.printStackTrace();
                 }
             }
             if (con!=null){
                 try {
                     con.close();
                 }catch(Exception e){
                     e.printStackTrace();
                 }
             }
         }
    }
}
