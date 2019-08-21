package TestUtils;

import JDBCutils.Utils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Connection con=null;
        ResultSet rs=null;
        Statement sta=null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入SQL语句");
        String sql=sc.nextLine();
        try {
            //注册驱动
            //获取连接
             con = Utils2.getconnection();
            //编写SQl语句
            //利用连接对象获取执行对象
            sta = con.createStatement();
            if(sql.contains("select")){
                rs = sta.executeQuery(sql);
                while (rs.next()){
                    System.out.println("用户名是:"+rs.getString("username")+",密码是"+rs.getString("password"));
                }//用户名是:jack,密码是123
//                用户名是:rose,密码是234
//                用户名是:tom,密码是345
            }else if(sql.contains("update")||sql.contains("delete")||sql.contains("alter")||sql.contains("insert")){
                int i = sta.executeUpdate(sql);
                System.out.println("修改成功,受影响的行数是:"+i);
            }
            //调用方法执行语句
            //处理结果集
            //释放资源
        }catch(Exception e){
            System.out.println("失败..");
            e.printStackTrace();

        }finally {
            Utils2.clos(rs,sta,con);
        }
    }
}
