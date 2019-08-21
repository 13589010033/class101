package com.itheima.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class deleteUser {
    @Test
    public void demo(){
        Statement st=null;
        Connection con=null;
       try {
           //注册驱动
           Class.forName("com.mysql.jdbc.Driver");
           //获得连接(用到驱动管理获取)
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db","root","root");
           //编写SQL语句
           String sql="delete from user where uid=4";
           //获取执行语句对象
            st = con.createStatement();
           //调用方法执行语句并且返回结果集对象
           int i = st.executeUpdate(sql);
           //处理结果集对象
           if(i>0){
               System.out.println("修改成功");
           }else{
               System.out.println("修改失败");
           }
           //释放资源
       }catch(Exception e){
           e.printStackTrace();
       }finally {
           if(st!=null&&con!=null){
               try {
                   st.close();
                   con.close();
               }catch(Exception e){
                   e.printStackTrace();
               }
           }

       }



    }
}
