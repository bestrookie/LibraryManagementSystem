package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.sql.SQLException;
import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;

public interface BooksInformationDao {
	//�������������鼮
          List<BooksInformation> searByName(String BookName) throws SQLException;
          //�����鼮��Ϣ
          int addBooksInformation(BooksInformation c) throws Exception;
          //�޸��鼮��Ϣ
          boolean updateInformation(BooksInformation c) throws Exception;
          //ɾ���鼮��Ϣ
		 void deleteInformation(int id) throws Exception;
		List<BooksInformation> searchAll() throws Exception;
          
}
