package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.util.*;

import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.days;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryDriver;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

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
	public bookHistory() {
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
	//借书
	public boolean borrowBook(String user,days lend,days giveBack) {
		if(this.isBorrow) {
			this.lend=lend;
			this.giveBack=giveBack;
			this.userId=user;
			this.isBorrow = true;
			return true;
		}
		return false;
	}
	//还书
	public void returnBook(days giveBack) {
		bookHistory now = this;
		now.isBorrow = false;
		now.giveBack=giveBack;
		dbBookHistoryFuncion db = new dbBookHistoryFuncion();
		try {
			db.updateBookHistory(this, now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//续借
	public void renew(int days) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, days);
		bookHistory now = this;
		now.giveBack = (days) ca.getTime();
		dbBookHistoryFuncion db = new dbBookHistoryFuncion();
		try {
			db.updateBookHistory(this, now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
