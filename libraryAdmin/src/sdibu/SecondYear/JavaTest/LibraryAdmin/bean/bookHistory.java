package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.util.*;
import java.text.*;
public class bookHistory {
	private ArrayList<String> userId;
	private String bookId;
	private ArrayList<Date> lend;
	private ArrayList<Date> giveBack;
	private boolean isBorrow;
	
	public bookHistory() {
		// TODO Auto-generated constructor stub
	}
	public bookHistory(ArrayList<String> user,String book,ArrayList<Date> lend,ArrayList<Date> giveBack,boolean isBorrow) {
		this.userId = user;
		this.bookId = book;
		this.lend = lend;
		this.giveBack = giveBack;
		this.isBorrow = isBorrow;
	}
	//借书
	public boolean borrowBook(String user,Date lend,Date giveBack) {
		if(this.isBorrow) {
			this.lend.add(lend);
			this.giveBack.add(giveBack);
			this.userId.add(user);
			this.isBorrow = true;
			return true;
		}
		return false;
	}
	//还书
	public void returnBook(Date giveBack) {
		this.isBorrow = false;
		this.giveBack.set(0,giveBack);
		//数据库操作
	}
	//续借
	public void renew(int days) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, days);
		this.giveBack.set(0,ca.getTime());
	}
	
	public List<String> getUserId() {
		return userId;
	}
	public void setUserId(ArrayList<String> userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public List<Date> getLend() {
		return lend;
	}
	public void setLend(ArrayList<Date> lend) {
		this.lend = lend;
	}
	public List<Date> getGiveBack() {
		return giveBack;
	}
	public void setGiveBack(ArrayList<Date> giveBack) {
		this.giveBack = giveBack;
	}
	public boolean isBorrow() {
		return isBorrow;
	}
	public void setBorrow(boolean isBorrow) {
		this.isBorrow = isBorrow;
	}
	
	
}
