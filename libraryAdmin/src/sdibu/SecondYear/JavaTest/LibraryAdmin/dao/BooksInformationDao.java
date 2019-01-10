package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.sql.SQLException;
import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;

public interface BooksInformationDao {
	//按照书名收索书籍
          List<BooksInformation> searByName(String BookName) throws SQLException;
          //增加书籍信息
          int addBooksInformation(BooksInformation c) throws Exception;
          //修改书籍信息
          boolean updateInformation(BooksInformation c) throws Exception;
          //删除书籍信息
		 void deleteInformation(int id) throws Exception;
		List<BooksInformation> searchAll() throws Exception;
          
}
