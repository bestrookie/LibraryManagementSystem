package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.sql.*;
import java.text.SimpleDateFormat;

public class BooksInformation {
  private int id;
  private String BookName;
  private String TheAuthor;
  private Date publishedDate;
  private String Category;
  
  
  public BooksInformation(int id, String bookName, String theAuthor, Date publishedDate, String category) {
		this.setId(id);
		this.setBookName(bookName);
		this.setTheAuthor(theAuthor);
		this.setPublishedDate(publishedDate);
		this.setCategory(category);
}
  public BooksInformation(String bookName, String theAuthor, Date publishedDate, String category) {
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
	  String[] str = {BookName,TheAuthor,setTime(publishedDate),Category,(new bookHistory().jugeId(id)?"ря╫ХЁЖ":"©и╫Х")};
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
public Date getPublishedDate() {
	return publishedDate;
}
public void setPublishedDate(Date publishedDate) {
	this.publishedDate = publishedDate;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}


  
}
