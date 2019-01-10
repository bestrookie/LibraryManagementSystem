package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.mysql.jdbc.Statement;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.util.DBTool;
import sdibu.SecondYear.JavaTest.LibraryAdmin.util.DBToolTwo;

public class BooksInformationDaoImpl implements BooksInformationDao {

	@Override
	public List<BooksInformation> searByName(String BookName) throws SQLException {
		List<BooksInformation> result = new ArrayList<BooksInformation>();
		Connection connection = DBToolTwo.getConnection();
		ResultSet rs;
		PreparedStatement pst = connection.prepareStatement("select *from booksinformations where BookName like ? ");
		pst.setString(1, "%"+BookName+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String Name = rs.getString(2);
			String TheAuThor = rs.getString(3);
			days date = new days(rs.getDate(4));
			String Category = rs.getString(5);
		 BooksInformation booksInformation = new BooksInformation(id,Name,TheAuThor,date,Category);		
		 result.add(booksInformation);
		}
		rs.close();
		pst.close();
		return result;
	}

	public BooksInformation searchById(String BookId) throws SQLException {
		BooksInformation result = new BooksInformation();
		Connection connection = DBToolTwo.getConnection();
		ResultSet rs;
		PreparedStatement pst = connection.prepareStatement("select *from booksinformations where Id =? ");
		pst.setString(1, BookId);
		rs = pst.executeQuery();
		if(rs.next()) {
			int id = rs.getInt(1);
			String Name = rs.getString(2);
			String TheAuThor = rs.getString(3);
			days date = new days(rs.getDate(4));
			String Category = rs.getString(5);
			BooksInformation booksInformation = new BooksInformation(id,Name,TheAuThor,date,Category);		
			result=booksInformation;
		}
		rs.close();
		pst.close();
		return result;
	}
	public boolean searchById(int BookId) throws SQLException {
		BooksInformation result = new BooksInformation();
		Connection connection = DBToolTwo.getConnection();
		ResultSet rs;
		PreparedStatement pst = connection.prepareStatement("select *from booksinformations where Id =? ");
		pst.setInt(1, BookId);
		rs = pst.executeQuery();
		boolean res = true;
		if(rs.next()) {
			res = false;
		}
		rs.close();
		pst.close();
		return res;
	}
	@Override
	public int addBooksInformation(BooksInformation c) throws Exception {
		Random rad = new Random();
		int key;
		do{
			key = rad.nextInt(10000);
		}while(!searchById(key));
		c.setId(key);
		days day = new days(c.getPublishedDate());
		dbBookHistoryFuncion db = new dbBookHistoryFuncion();
		db.addBookHistory(c.getBookName(), c.getId());
		Connection conn = DBToolTwo.getConnection();
		Statement state = (Statement) conn.createStatement();
		String sql = "insert into booksinformations(BookName,TheAuthor,publishedDate,Category,id) values ('"
				+c.getBookName()+ "','"+c.getTheAuthor()+"','"+day.toString()+"','"+c.getCategory()+"','"+key+"')";
		int result = state.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		if(result == 1) {			
			ResultSet keys = state.getGeneratedKeys();
			keys.next();
			key = keys.getInt(1);			 
		}
		state.close();
		return key;
	}
	public void deleteInformation(int id) throws Exception {
		Connection conn = DBToolTwo.getConnection();
		Statement state = (Statement) conn.createStatement();
		String sql = "delete from booksinformations where id ="+id;
		state.executeUpdate(sql);
		state.close();				
	}
	public void deleteInformation(String id) throws Exception {
		Connection conn = DBToolTwo.getConnection();
		Statement state = (Statement) conn.createStatement();
		String sql = "delete from booksinformations where id ="+id;
		state.executeUpdate(sql);
		state.close();				
	}
	@Override
	public List<BooksInformation> searchAll() throws Exception {
		List<BooksInformation> result = new ArrayList<BooksInformation>();
		Connection conn = DBToolTwo.getConnection();
		ResultSet rs;
		Statement st = (Statement) conn.createStatement();
		rs = st.executeQuery("select * from booksinformations");
		while(rs.next()) {
			result.add(new BooksInformation(rs.getInt(1),rs.getString(2)
					,rs.getString(3),new days(rs.getDate(4)),rs.getString(5)));
		}
		rs.close();
		st.close();
		return result;
	}

	@Override
	public boolean updateInformation(BooksInformation c) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}