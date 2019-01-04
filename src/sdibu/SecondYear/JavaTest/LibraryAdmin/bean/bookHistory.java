package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.util.*;
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
