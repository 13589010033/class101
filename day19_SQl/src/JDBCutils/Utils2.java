package JDBCutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Utils2 {
    private static final String dc ;

    private static final ResourceBundle rb ;

    private static final String url ;

    private static final String username ;

    private static final String password ;

    static{
        rb = ResourceBundle.getBundle("db");//读取配置文件*************
        dc = rb.getString("Driverclass");//获取的是注册驱动com.mysql.jdbc.Driver
       url = rb.getString("url");//获取的是协议以及主机端口号jdbc:mysql://localhost:3306/day19_db;
       username = rb.getString("username");//账号root
       password = rb.getString("password");//密码root
        try {   //注册驱动
         Class.forName(dc);
     }catch(Exception e){
         e.printStackTrace();
     }
    }
    // 获取连接
    public static Connection getconnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    //释放资源
    public static void clos(ResultSet r, Statement s,Connection c){
        if (r!=null&&s!=null&&c!=null){
            try {
                r.close();s.close();c.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
