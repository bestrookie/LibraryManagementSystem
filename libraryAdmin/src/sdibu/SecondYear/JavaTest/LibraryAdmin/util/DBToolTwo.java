package sdibu.SecondYear.JavaTest.LibraryAdmin.util;

import java.sql.*;

public class DBToolTwo {
	public static Connection getConnection() {
    	Connection conn = null;
    	try {
            Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
            System.out.println("�������ݿ������ɹ�");
            String url="jdbc:mysql://localhost:3306/db_library?useUnicode=true&useSSL=false&characterEncoding=utf-8";//�������ݿ�test��url
                               //?useUnicode=true&characterEncoding=utf-8�����ǿ��Գɹ��İѺ��ֵ����ݴ��䵽�ı���
            String user="root";//���ݿ���û���
            String password="123456";//���ݿ������
            //�������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
            conn=DriverManager.getConnection(url, user, password);
            System.out.println("�������ݿ�ɹ�");
    	} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
        }//
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
    	return conn;
    }
}
