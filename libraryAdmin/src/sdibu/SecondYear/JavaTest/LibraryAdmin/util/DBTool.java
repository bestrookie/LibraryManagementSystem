package sdibu.SecondYear.JavaTest.LibraryAdmin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;

public class DBTool {
	private static Connection conn  = null;
	public static Connection getConnection(){
		try {
			if(conn == null || conn.isClosed()){
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false","visitor","123456");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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

