package TestUtils;

import JDBCutils.Utils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入SQL语句,仅支持查询");
        String sql = sc.nextLine();
        ResultSet rs=null;
        Statement sta=null;
        Connection con=null;
      try {
          //注册驱动
          //获取连接
         con = Utils2.getconnection();
          //编写SQL语句
          //获取执行对象
           sta = con.createStatement();
          //调用方法执行
           rs = sta.executeQuery(sql);
          //处理结果集
          System.out.println("你要查询的结果是:");
          while (rs.next()){
              System.out.println("用户名:"+rs.getString("username")+",密码:"+rs.getString("password"));

          }
          //释放资源
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          Utils2.clos(rs,sta,con);
      }
    }

}
