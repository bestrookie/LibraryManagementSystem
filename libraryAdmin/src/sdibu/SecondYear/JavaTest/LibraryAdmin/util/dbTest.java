package sdibu.SecondYear.JavaTest.LibraryAdmin.util;

import java.sql.Connection;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.UserDaoImpl;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.UsersDao;


public class dbTest {

	public static void main(String[] args) throws Exception {
		//Connection  conn = DBTool.getConnection();
		/*users user = new users("10005", "���", "wasd51236", false, false);
		UserDaoImpl us = new UserDaoImpl();
		us.addUser(user);//����û�*/
		
		
		/*UserDaoImpl us = new UserDaoImpl();
		us.deleteUserById(10004);//ɾ���û�*/
		
		
		users user = new users("10006", "pony��", "123456", false, true);
		UserDaoImpl us = new UserDaoImpl();
		us.updateUser(user);//�޸���Ϣ
	}

}
