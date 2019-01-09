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

	public BooksInformation searById(String BookId) throws SQLException {
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
	@Override
	public int addBooksInformation(BooksInformation c) throws Exception {
		int key = -1;
		days day = new days(c.getPublishedDate());
		
		Connection conn = DBToolTwo.getConnection();
		Statement state = (Statement) conn.createStatement();
		String sql = "insert into booksinformations(id,BookName,TheAuthor,publishedDtae,Category) values ('"+c.getId()+"','"
				+c.getBookName()+ "','"+c.getTheAuthor()+"','"+day.toString()+"','"+c.getCategory()+"')";
		int result = state.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		if(result == 1) {			
			ResultSet keys = state.getGeneratedKeys();
			keys.next();
			key = keys.getInt(1);			 
		}
		state.close();
		return key;
	}
	public boolean deleteInformation(int id) throws Exception {
		boolean flag = false;		
		Connection conn = DBToolTwo.getConnection();
		Statement state = (Statement) conn.createStatement();
		String sql = "delete from booksinformations where id ="+id;
		int result = state.executeUpdate(sql);
		if(result == 1) 			
			flag = true;
		state.close();				
		return flag;
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

}