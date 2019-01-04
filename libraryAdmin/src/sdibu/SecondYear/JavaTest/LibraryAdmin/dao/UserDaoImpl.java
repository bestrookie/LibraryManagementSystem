package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.sql.*;
import java.util.*;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.util.DBTool;

public class UserDaoImpl implements UsersDao {

	@Override
	public List<users> searchByName(String name) throws Exception {
		List<users> list = new ArrayList<users>();
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		PreparedStatement pst = conn.prepareStatement("select * from "
				+ "contracts where name like ? order by "
				+ "convert(name using GBK)");
		pst.setString(1, "%"+name+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String n = rs.getString(2);
			String pw = rs.getString(3);
			users user = new users(id, n, pw);
			list.add(user);
			
		}
		rs.close();
		pst.close();
		return list;
	}

	@Override
	public boolean deleteUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(users user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(users user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
