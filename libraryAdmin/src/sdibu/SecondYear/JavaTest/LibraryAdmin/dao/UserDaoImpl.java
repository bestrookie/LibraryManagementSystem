package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.sql.*;
import java.util.*;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.util.DBTool;

public class UserDaoImpl implements UsersDao {

	@Override
	public List<users> searchById(String id) throws Exception {
		List<users> list = new ArrayList<users>();
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		PreparedStatement pst = conn.prepareStatement("select * from "
				+ "users where id like ? order by "
				+ "convert(id using GBK)");
		pst.setString(1, id);
		rs = pst.executeQuery();
		while(rs.next()) {
			String ID = rs.getString(1);
			String n = rs.getString(2);
			String pw = rs.getString(3);
			boolean sf = rs.getBoolean(4);
			boolean fr = rs.getBoolean(5);
			users user = new users(ID, n, pw,sf,fr);
			list.add(user);
			
		}
		rs.close();
		pst.close();
		return list;
	}

	@Override
	public boolean deleteUserById(String id) throws Exception {
		boolean flag = false;		
		Connection conn = DBTool.getConnection();
		Statement state = conn.createStatement();
		String sql = "delete from users where id ="+id;
		int result = state.executeUpdate(sql);
		if(result == 1) 			
			flag = true;
		//System.out.println("删除成功");
		state.close();				
		return flag;
	}

	@Override
	public boolean addUser(users user) throws Exception {
		boolean flag = false;
		String id = user.getId();
		String name = user.getName();
		String passward = user.getPassward();
		boolean power = false;
		boolean frozen = false;//用户基本信息
		
		Connection conn = DBTool.getConnection();
		
		String sql = "insert into users(id,name,passW,power,frozen) values(?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, id);
		state.setString(2, name);
		state.setString(3, passward);
		state.setBoolean(4, power);
		state.setBoolean(5, frozen);
							
		int result = state.executeUpdate();
		state.close();
		return flag;//将用户信息添加到数据库
	}

	@Override
	public boolean updateUser(users user) throws Exception {
		boolean flag = false;
		String id = user.getId();
		String name = user.getName();
		String passward = user.getPassward();
		boolean power = user.isPower();
		boolean frozen = user.isFrozen();//用户基本信息
		
		Connection conn = DBTool.getConnection();
		String sql = "update users set name=?,passW=?,power=?,frozen=? where id=?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, name);
		state.setString(2, passward);
		state.setBoolean(3, power);
		state.setBoolean(4, frozen);
		state.setString(5, id);
		
		int result = state.executeUpdate();
		state.close();
		
		return flag;
	}
	

}
