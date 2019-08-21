package TestUtils;

import JDBCutils.Utils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
    @Test
    public void demo(){
         //注册驱动
        //获取连接
        String sql="select * from user";
        //编写SQL语句
        //获取执行对象
        //调用方法执行语句
        Connection con = Utils.getcon();
        ResultSet rs=null;
        Statement sata=null;
        try {
             sata = con.createStatement();
            rs = sata.executeQuery(sql);
            while (rs.next()){
                System.out.println("用户名:"+rs.getString("username")+",密码:"+rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //处理结果集
        //释放资源
        Utils.closes(rs,sata,con);
    }
}
