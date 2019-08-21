package MysqlZhuanZhang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo01 {
    public static void main(String[] args) {
        String from="zhangsan";
        String to="lisi";
        zz(from,to,1000);

    }
    public static void zz(String from, String to,double moeny){
        Connection con=null;
        Statement st=null;
       try {
           //注册驱动
           Class.forName("com.mysql.jdbc.Driver");
           //获取连接
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db", "root", "root");
           con.setAutoCommit(false);
           //编写SQL语句
           String sql="update user1 set moeny=moeny-1000 where name='zhangsan'";
           String sql2="update user1 set moeny=moeny+1000 where name='lisi'";
           //获取执行对象
          st = con.createStatement();
           //调用方法执行语句并获得结果集对象
           int a= st.executeUpdate(sql);
//           int c=1/0;
           int b = st.executeUpdate(sql2);
           //处理结果集
           if(a>0&&b>0){
               System.out.println("转账成功");
               con.commit();
           }
           //释放资源
       } catch (Exception e) {
           try {
               con.rollback();
               System.out.println("转账失败.................");
           }catch (SQLException e1){
               e1.printStackTrace();
           }

       } finally {
           if(st!=null){
               try {
                   st.close();
               }catch (Exception e){
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
