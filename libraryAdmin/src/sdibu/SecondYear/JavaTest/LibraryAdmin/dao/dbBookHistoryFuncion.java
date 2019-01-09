package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;
import sdibu.SecondYear.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;
import sdibu.SecondYear.JavaTest.LibraryAdmin.gui.addBookInformationGUI;

public class dbBookHistoryFuncion {
	
		private dbBookHistoryDriver db=new dbBookHistoryDriver();
		
	    public int addBookHistory(bookHistory book) throws Exception{
	    	/*System.out.println("insert into bookhistory values('"+book.getUserId()+"','"
	        		+book.getBookId()+"','"+setDate(book.getLend())+"','"+
	        		setDate(book.getGiveBack())+"','"+(book.isBorrow()?1:0)+"')");
	        */
	        Connection con=db.getCon();
	        String sql="insert into bookhistory values(?,?,?,?,?,?)";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, book.getBookName());
	        pst.setString(2,book.getUserId());
	        pst.setInt(3, book.getBookId());
	        pst.setString(4, book.getLend().toString());
	        pst.setString(5, book.getGiveBack().toString());
	        pst.setBoolean(6, book.isBorrow());
	        int result = pst.executeUpdate();
	        db.close(pst,con);
	        return result;
	    }
	    public int addBookHistory(String bookName,int bookId) throws Exception{
	    	Connection con=db.getCon();
	        String sql="insert into bookhistory values('"+bookName+"','null','"+bookId+"','1998-01-01'"
	        		+ ",'1998-01-01','0')";
	        Statement stmt=con.createStatement();
	        int result = stmt.executeUpdate(sql);
	        db.close(stmt, con);
	        return result;
	    }
	    public int addBookHistory(String bookName,String userId,int bookId,String lend,String giveBack,boolean isBorrow)
	        throws Exception{
		        Connection con=db.getCon();
		        String sql="insert into bookhistory values('"+bookName+"','"+userId+"','"+
		        bookId+"','"+lend+"','"+giveBack+"','"+(isBorrow?1:0)+"')";
		       System.out.println("insert into db_bookhistory values('"+userId+"',"+
		        bookId+",'"+lend+"',"+giveBack+"','"+(isBorrow?1:0)+"')");
		        Statement stmt=con.createStatement();//创建一个Statement连接
		        int result=stmt.executeUpdate(sql);//执行sql语句
		        db.close(stmt,con);
		        return result;
	    }
	    
	    public int updateBookHistory(bookHistory before,bookHistory to) throws Exception {
	    	Connection conn = db.getCon();
			String sql = "update bookhistory set borrow=?,isBorrow=? where bookId=? lend=? bookName=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, to.getGiveBack().toString());
			pst.setBoolean(2, to.isBorrow());
			pst.setInt(3, before.getBookId());
			pst.setString(4, before.getLend().toString());
			pst.setString(5, before.getBookName());
			int rs = pst.executeUpdate();
			db.close(pst, conn);
			return rs;
	    }
	    public List<bookHistory> searchBookHistory(String search,String func) throws Exception {
			List<bookHistory> result = new ArrayList<bookHistory>();
			Connection conn = db.getCon();
			ResultSet rs;
			PreparedStatement pst = conn.prepareStatement("select * from "
					+ "bookhistory where "+func+"=?");
			pst.setString(1, search);
			rs = pst.executeQuery();		
			while(rs.next()) {
				String bookName = rs.getString(1);
				String user = rs.getString(2);
				int book = rs.getInt(3);
				days lend = new days(rs.getDate(4));
				days borrow = new days(rs.getDate(5));
				boolean isBorrow = rs.getBoolean(6);
				
				//System.out.println(user+" "+book+" "+lend+" "+borrow+" "+isBorrow);
				result.add(new bookHistory(user, bookName,book,lend, borrow, isBorrow));
			}
			rs.close();
			pst.close();
			return result;
		}
	    public boolean deleteBookHistory(String name,int count) throws Exception {
	    	Connection con = db.getCon();
	    	ResultSet rs;
	    	PreparedStatement pst = con.prepareStatement("select * from bookhistory where BookName=?");
			pst.setString(1, name);
			rs = pst.executeQuery();
			
	    	return true;
	    }
	    /*public static void main(String args[]) throws Exception {
	    	dbBookHistoryFuncion xx = new dbBookHistoryFuncion();
	    	xx.addBookHistory("高数", "123", 110, "2018-1-1","2019-1-2", false);
	    }*/
		
	}
