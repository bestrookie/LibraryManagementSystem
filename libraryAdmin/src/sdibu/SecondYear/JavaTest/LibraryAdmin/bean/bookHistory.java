package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.util.*;


import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.days;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryDriver;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
public class bookHistory {
	private String userId;
	private String bookName;
	private int bookId;
	private days lend;
	private days giveBack;
	private boolean isBorrow;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public bookHistory getbookHistory() {
		return this;
		// TODO Auto-generated constructor stub
	}
	public bookHistory(String user,String bookName,int book,days lend,days giveBack,boolean isBorrow) {
		this.userId = user;
		this.bookId = book;
		this.bookName = bookName;
		this.lend = lend;
		this.giveBack = giveBack;
		this.isBorrow = isBorrow;
	}
	public bookHistory(String user, String bookName,int book,String lend, String giveBack, boolean isBorrow){
		// TODO Auto-generated constructor stub
		this.userId = user;
		this.bookName = bookName;
		this.bookId = book;
		try {
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
			this.lend = (days) time.parse(lend);		
			this.giveBack = (days) time.parse(giveBack);
		}catch(Exception e) {
			System.out.println("时间不合法");
		}
		this.isBorrow = isBorrow;
	}
	public boolean jugeId(int id) throws Exception  {
		dbBookHistoryDriver db= new dbBookHistoryDriver();
		java.sql.Connection con=db.getCon();
        ResultSet rs;
		PreparedStatement pst = con.prepareStatement("select * from "
				+ "bookhistory where bookId=?");
		pst.setInt(1, id);
		rs = pst.executeQuery();
		if(rs.next()) {
			int book = rs.getInt(3);
			boolean isBorrow = rs.getBoolean(6);	
			if(isBorrow) {
				rs.close();
				pst.close();
				return true;
			}
		}
		rs.close();
		pst.close();
		return false;
	}
	
	
	public String[] userToString() {
		String[] res ={bookName,lend.toString(),giveBack.toString()};
		return res;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public days getLend() {
		return lend;
	}
	public void setLend(days lend) {
		this.lend = lend;
	}
	public days getGiveBack() {
		return giveBack;
	}
	public void setGiveBack(days giveBack) {
		this.giveBack = giveBack;
	}
	public boolean isBorrow() {
		return isBorrow;
	}
	public void setBorrow(boolean isBorrow) {
		this.isBorrow = isBorrow;
    }
	
	
}
