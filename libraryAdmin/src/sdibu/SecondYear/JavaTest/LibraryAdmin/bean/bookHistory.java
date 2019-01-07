package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.util.*;
import java.text.*;
public class bookHistory {
	private String userId;
	private String bookId;
	private Date lend;
	private Date giveBack;
	private boolean isBorrow;
	
	public bookHistory() {
		// TODO Auto-generated constructor stub
	}
	public bookHistory(String user,String book,Date lend,Date giveBack,boolean isBorrow) {
		this.userId = user;
		this.bookId = book;
		this.lend = lend;
		this.giveBack = giveBack;
		this.isBorrow = isBorrow;
	}
	public bookHistory(String user, String book, String lend, String giveBack, boolean isBorrow){
		// TODO Auto-generated constructor stub
		this.userId = user;
		this.bookId = book;
		try {
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
			this.lend = time.parse(lend);		
			this.giveBack = time.parse(giveBack);
		}catch(Exception e) {
			System.out.println("时间不合法");
		}
		this.isBorrow = isBorrow;
	}
	//借书
	public boolean borrowBook(String user,Date lend,Date giveBack) {
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
	public void returnBook(Date giveBack) {
		this.isBorrow = false;
		this.giveBack=giveBack;
		//数据库操作
	}
	//续借
	public void renew(int days) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, days);
		this.giveBack=ca.getTime();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getLend() {
		return lend;
	}
	public void setLend(Date lend) {
		this.lend = lend;
	}
	public Date getGiveBack() {
		return giveBack;
	}
	public void setGiveBack(Date giveBack) {
		this.giveBack = giveBack;
	}
	public boolean isBorrow() {
		return isBorrow;
	}
	public void setBorrow(boolean isBorrow) {
		this.isBorrow = isBorrow;
    }
	
	
}
