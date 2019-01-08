package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import sdibu.SecondYear.JavaTest.*;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryDriver;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import java.util.*;
public class bookHistoryGui extends JFrame{
	 Container con = this.getContentPane();
	 ListModel jListModel = new DefaultComboBoxModel<bookHistory>();
	 JButton sure = new JButton("ȷ��");
	 JLabel label;
	 MyTable jTable;
	 JScrollPane jsp;
	 
	 private String setDate(java.util.Date list) {
	    	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
	    	return time.format(list);
	 }
	 
	 
	public void bookHistoryGuiInit(String user) throws Exception { 
		//System.out.println("in bookHistoryGuiInit the user is"+user);
		String []columnNames= {
				"����","��������","Ӧ������"
		};
		boolean []Sorter = {true,true,true};
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			} catch (UnsupportedLookAndFeelException e1) {	
			e1.printStackTrace();
			}	//����Ƥ��
		List<bookHistory>book = new dbBookHistoryFuncion().searchBookHistory(user, "userId");
		String obj[][] = new String[book.size()][0];
		int cnt = 0;
		for(bookHistory bufS:book) {
			
			/*Debug 
			 * 
			 * System.out.println();
			for(String x:bufS.userToString())
				System.out.print(x+" " );
			System.out.println();*/
			obj[cnt++] = bufS.userToString();
		}
		sure.setVisible(true);	
		
		jTable = new MyTable(obj,columnNames);
		
		// ���õ����ͷ�Զ�ʵ������
        jTable.setAutoCreateRowSorter(true);
        // ���ñ�ͷ���־�����ʾ
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(renderer.CENTER);

        // ���ñ���е����ݾ�����ʾ
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class,r);

        jTable.setFocusable(true);
        jTable.setFont(new Font("������", Font.PLAIN, 18));

		jsp = new JScrollPane(jTable);
		setBounds(500,500,500,500);
		setVisible(true);
		jTable.setRowHeight(50);
		add(jsp,BorderLayout.CENTER);
		add(sure,BorderLayout.SOUTH);
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
	
	public static void main(String[] args) throws Exception {
		bookHistoryGui xx = new bookHistoryGui();
		xx.bookHistoryGuiInit("10007");        //��������
     }
}
