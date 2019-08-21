package JDBCutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Utils {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //注册驱动获得连接
    public static Connection getcon(){
        Connection con=null;
        try {

             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day19_db","root","root");
        } catch (Exception e) {//                    jdbc:mysql://localhost:3306/day19_db
            e.printStackTrace();
        }
    return con;
    }
                //释放资源
    public static void closes(ResultSet rs,  Statement sta,Connection con){
        if(rs!=null&&con!=null&&sta!=null){
            try {
                rs.close();
                con.close();
                sta.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
