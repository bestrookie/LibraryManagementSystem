package sdibu.SecondYear.JavaTest.LibraryAdmin.Service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.UserDaoImpl;

public class addUser {
	UserDaoImpl addU = new UserDaoImpl();
	
	public boolean addUser(users user) throws Exception {
		List<users> list = new ArrayList<users>();
		list = addU.searchById(user.getId());
		if(list.isEmpty()) {
			addU.addUser(user);
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "该账号已存在，不可重复创建", "错误", 
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}

//	public static void main(String[] args) {
//		users user = new users("10008", "史珍香", "123456", false, false);
//		try {
//			addUser addUser = new addUser(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
