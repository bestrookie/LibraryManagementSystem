package sdibu.SecondYear.JavaTest.LibraryAdmin.util;

import java.sql.*;
import java.util.*;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;

public class DBTool {
	private static Connection conn  = null;
	public static Connection getConnection(){
		try {
			String user = "visitor";
			String url = "jdbc:mysql://localhost:3306/users?useSSL=false";
			if(conn == null || conn.isClosed()){
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//System.out.println("加载数据库驱动成功");
					conn = DriverManager.getConnection(url,user,"123456");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//System.out.println("连接数据库成功");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return conn;			
	}
	public static void closeConnection(){
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
				conn = null;
				}
		    }catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/*public static void main() {
		Connection conn = DBTool.getConnection();
		List<users> list = new ArrayList<users>();
		ResultSet rs;
		int id = rs.getInt(1);
		System.out.println(id);
		rs.close();
		}

	}*/
}	

