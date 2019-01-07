package sdibu.SecondYear.JavaTest.LibraryAdmin.util.dbBookHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbBookHistoryDriver {
	private String url="jdbc:mysql://localhost:3306/db_library?useUnicode=true&useSSL=false&characterEncoding=utf-8";//书籍历史的url(地址)
    private String user="root";//数据库账号
    private String password="123456";//数据库密码
    private String driver="com.mysql.jdbc.Driver";//数据库的驱动
    
    public Connection getCon() throws Exception{
        Class.forName(driver);//加载数据库驱动
        //System.out.print("加载成功");
        Connection con=DriverManager.getConnection(url, user, password);
        return con;
    }
    public void close(Statement stmt, Connection con) throws Exception{
        if(con!=null){
            con.close();
        }    
    }
}
