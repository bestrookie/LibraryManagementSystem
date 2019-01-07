package sdibu.SecondYear.JavaTest.LibraryAdmin.util.dbBookHistory;
import sdibu.SecondYear.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;

public class dbBookHistoryFuncion {
	
		private dbBookHistoryDriver db=new dbBookHistoryDriver();
		private String setDate(java.util.Date list) {
	    	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
	    	return time.format(list);
	    }
	    public int addHistory(bookHistory book) throws Exception{
	    	/*System.out.println("insert into bookhistory values('"+book.getUserId()+"','"
	        		+book.getBookId()+"','"+setDate(book.getLend())+"','"+
	        		setDate(book.getGiveBack())+"','"+(book.isBorrow()?1:0)+"')");
	        */
	        Connection con=db.getCon();
	        String sql="insert into bookhistory values('"+book.getUserId()+"','"
	        		+book.getBookId()+"','"+setDate(book.getLend())+"','"+
	        		setDate(book.getGiveBack())+"','"+(book.isBorrow()?1:0)+"')";
	        Statement stmt=con.createStatement();//创建一个Statement连接
	        int result=stmt.executeUpdate(sql);//执行sql语句
	        db.close(stmt,con);
	        return result;
	    }
	    public int addHistory(String bookId) throws Exception{
	    	Connection con=db.getCon();
	        String sql="insert into bookhistory values('null','"+bookId+"','0000-00-00'"
	        		+ ",'0000-00-00','0')";
	        Statement stmt=con.createStatement();
	        int result = stmt.executeUpdate(sql);
	        db.close(stmt, con);
	        return result;
	    }
	    public int addBookHistory(String userId,String bookId,String lend,String giveBack,boolean isBorrow)
	        throws Exception{
		        Connection con=db.getCon();
		        String sql="insert into bookhistory values('"+userId+"','"+
		        bookId+"','"+lend+"','"+giveBack+"','"+(isBorrow?1:0)+"')";
		       /* System.out.println("insert into db_bookhistory values('"+userId+"',"+
		        bookId+",'"+lend+"',"+giveBack+"','"+(isBorrow?1:0)+"')");*/
		        Statement stmt=con.createStatement();//创建一个Statement连接
		        int result=stmt.executeUpdate(sql);//执行sql语句
		        db.close(stmt,con);
		        return result;
	    }
	    
	    public int updateBookHistory(bookHistory before,bookHistory to) throws Exception {
	    	Connection conn = db.getCon();
			String sql = "update bookhistory set borrow=?,isBorrow=? where bookId=? lend=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, setDate(to.getGiveBack()));
			pst.setBoolean(2, to.isBorrow());
			pst.setString(3, before.getBookId());
			pst.setString(4, setDate(before.getLend()));
			int rs = pst.executeUpdate();
			db.close(pst, conn);
			return rs;
	    }
	    public List<bookHistory> searchBookHistory(String id,String func) throws Exception {
			List<bookHistory> result = new ArrayList<bookHistory>();
			Connection conn = db.getCon();
			ResultSet rs;
			PreparedStatement pst = conn.prepareStatement("select * from "
					+ "bookhistory where "+func+"=?");
			pst.setString(1, id);
			rs = pst.executeQuery();		
			while(rs.next()) {
				String user = rs.getString(1);
				String book = rs.getString(2);
				Date lend = rs.getDate(3);
				Date borrow = rs.getDate(4);
				boolean isBorrow = rs.getBoolean(5);
				System.out.println(user+" "+book+" "+lend+" "+borrow+" "+isBorrow);
				result.add(new bookHistory(user, book, lend, borrow, isBorrow));
			}
			rs.close();
			pst.close();
			return result;
		}
	    
	}
