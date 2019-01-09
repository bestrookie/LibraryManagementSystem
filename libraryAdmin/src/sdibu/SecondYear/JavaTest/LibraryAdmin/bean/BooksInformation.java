package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.sql.*;
import java.text.SimpleDateFormat;

import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.days;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

public class BooksInformation {
  private int id;
  private String BookName;
  private String TheAuthor;
  private days publishedDate;
  private String Category;
  public BooksInformation() {
	  
  }
  
  public BooksInformation(int id, String bookName, String theAuthor, days publishedDate, String category) {
		this.setId(id);
		this.setBookName(bookName);
		this.setTheAuthor(theAuthor);
		this.setPublishedDate(publishedDate);
		this.setCategory(category);
}
  public BooksInformation(String bookName, String theAuthor, days publishedDate, String category) {
	this.setBookName(bookName);
	this.setTheAuthor(theAuthor);
	this.setPublishedDate(publishedDate);
	this.setCategory(category);
	id = -1;
  }

  public String setTime(java.util.Date list) {
	  SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		return time.format(list);
	
}
  public String[] BooksInformationToString() throws Exception {
	  String s = null;
	  dbBookHistoryFuncion db = new dbBookHistoryFuncion();
	  s = db.searchBookHistory(id+"", "bookId").get(0).isBorrow()?"ря╫Х":"©и╫Х";
	  String[] str = {BookName,TheAuthor,setTime(publishedDate),Category,s};
	  return  str;
  }
  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookName() {
	return BookName;
}
public void setBookName(String bookName) {
	BookName = bookName;
}
public String getTheAuthor() {
	return TheAuthor;
}
public void setTheAuthor(String theAuthor) {
	TheAuthor = theAuthor;
}
public days getPublishedDate() {
	return publishedDate;
}
public void setPublishedDate(days publishedDate) {
	this.publishedDate = publishedDate;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}

public String toString() {
	return String.format("%s,%s,%s,%s",this.getBookName(),this.getTheAuthor(),
			this.getPublishedDate(),this.getCategory());
}
  
}
