package sdibu.SecondYear.JavaTest.LibraryAdmin.util.dbBookHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbBookHistoryDriver {
	private String url="jdbc:mysql://localhost:3306/db_library?useUnicode=true&useSSL=false&characterEncoding=utf-8";//�鼮��ʷ��url(��ַ)
    private String user="root";//���ݿ��˺�
    private String password="123456";//���ݿ�����
    private String driver="com.mysql.jdbc.Driver";//���ݿ������
    
    public Connection getCon() throws Exception{
        Class.forName(driver);//�������ݿ�����
        //System.out.print("���سɹ�");
        Connection con=DriverManager.getConnection(url, user, password);
        return con;
    }
    public void close(Statement stmt, Connection con) throws Exception{
        if(con!=null){
            con.close();
        }    
    }
}
