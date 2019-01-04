package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.sql.*;
import java.util.*;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.AdminUser;
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
		boolean flag = false;		
		Connection conn = DBTool.getConnection();
		Statement state = conn.createStatement();
		String sql = "delete from users where id ="+id;
		int result = state.executeUpdate(sql);
		if(result == 1) 			
			flag = true;
		System.out.println("删除成功");
		state.close();				
		return flag;
	}

	@Override
	public boolean addUser(AdminUser user) throws Exception {
		boolean flag = false;
		int id = user.getId();
		String name = user.getName();
		String passward = user.getPassward();
		boolean power = false;
		boolean frozen = false;//用户基本信息
		
		Connection conn = DBTool.getConnection();
		
		String sql = "insert into users(id,name,passW,power,frozen) values(?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, id);
		state.setString(2, name);
		state.setString(3, passward);
		state.setBoolean(4, power);
		state.setBoolean(5, frozen);
							
		int result = state.executeUpdate();
		if(result == 1) {			
			flag = true;
			System.out.println("添加成功");
		}
		state.close();
		return flag;//将用户信息添加到数据库
	}

	@Override
	public boolean updateUser(AdminUser user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

}
