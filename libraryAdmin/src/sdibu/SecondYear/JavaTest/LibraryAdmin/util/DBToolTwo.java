package sdibu.SecondYear.JavaTest.LibraryAdmin.util;

import java.sql.*;

public class DBToolTwo {
	public static Connection getConnection() {
    	Connection conn = null;
    	try {
            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
            System.out.println("加载数据库驱动成功");
            String url="jdbc:mysql://localhost:3306/db_library?useUnicode=true&useSSL=false&characterEncoding=utf-8";//声明数据库test的url
                               //?useUnicode=true&characterEncoding=utf-8作用是可以成功的把汉字的数据传输到文本中
            String user="root";//数据库的用户名
            String password="123456";//数据库的密码
            //建立数据库连接，获得连接对象conn(抛出异常即可)
            conn=DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库成功");
    	} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
        }//
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
    	return conn;
    }
}
