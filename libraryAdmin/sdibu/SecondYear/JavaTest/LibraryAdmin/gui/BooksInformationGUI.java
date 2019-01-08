package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.BooksInformationDaoImpl;
import sdibu.SecondYear.JavaTest.LibraryAdmin.util.DBToolTwo;




public class BooksInformationGUI extends JFrame{
	private DefaultListModel<BooksInformation> ml;
	
       public BooksInformationGUI(String userName) throws Exception {
		super("图书馆");
		
		Container c = this.getContentPane();
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//窗口皮肤

		JPanel box1 = new JPanel();
		box1.setLayout(new BoxLayout(box1,BoxLayout.Y_AXIS));
		Component box4 = Box.createVerticalStrut(30);
		Component box5 = Box.createVerticalStrut(100);
		Component box6 = Box.createVerticalStrut(100);
	    JButton btn1 = new JButton("借书");
	    JButton btn2 = new JButton("还书");
	    JButton btn3 = new JButton("我的借阅");
	    box1.add(box4);
	    box1.add(btn1); 
	    box1.add(box5);
	    box1.add(btn2);
	    box1.add(box6);
	    box1.add(btn3);
	    add(box1,BorderLayout.EAST);
		
		JPanel up = new JPanel();
		JTextField ss = new JTextField("请输入要查找的书籍名称",50);
		Component box = Box.createVerticalStrut(100);
		up.add(box);
		up.add(ss);
		c.add(up, BorderLayout.NORTH);
		
		//JList<BooksInformation> books = new JList<BooksInformation>();
          
          
          
       String[]TableName = {"书籍名称","作者","出版日期","类别","书籍状态"}; 
   	   BooksInformationDaoImpl p = new BooksInformationDaoImpl();
   	   List<BooksInformation> BookList  = new ArrayList<BooksInformation>();
   	   BookList = p.searchAll();
   	   String[][] obj = new String[BookList.size()][0];
	   	int cot = 0 ;
	   	for(int i = 0 ; i<BookList.size(); i++) {
	   			obj[cot++] = BookList.get(i).BooksInformationToString();
	   		}
	 
	   	MyTable jTable = new MyTable(obj,TableName);
	   	
	 // 设置点击表头自动实现排序
	    jTable.setAutoCreateRowSorter(true);
	    // 设置表头文字居中显示
	    DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer();
	    renderer.setHorizontalAlignment(renderer.CENTER);
	
	    // 设置表格中的数据居中显示
	    DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	    r.setHorizontalAlignment(JLabel.CENTER);
	    jTable.setDefaultRenderer(Object.class,r);
	
	    jTable.setFocusable(true);
	    jTable.setFont(new Font("新宋体", Font.PLAIN, 18));
	   	
	   	JScrollPane jsp = new JScrollPane(jTable);
	   	setTitle("亲爱的同学:"+userName+"你好，欢迎进入xx在线图书馆借还书系统");
	   	setBounds(500,500,500,500);
	   	setVisible(true);
	   	jTable.setRowHeight(50);
	   	add(jsp,BorderLayout.CENTER);
	   	
	   	//事件
	   	btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					bookHistoryGui myHistory = new bookHistoryGui();
					myHistory.bookHistoryGuiInit(userName);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
    
 
		
		
		Component box3 = Box.createHorizontalStrut(50);
		c.add(box3,BorderLayout.WEST);
	    
	    
	   
	    this.pack();
		this.setVisible(true);//窗体可见
		//this.setSize(600, 450);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的长宽
		this.setBounds((width - 800) / 2,(height - 600) / 2, 800, 600);//窗体大小，居中
		this.setResizable(false);//禁止拉伸窗口，最大化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
       public void CreatList() throws Exception {
    	   String[]TableName = {"id","书籍名称","作者","出版日期","类别"}; 
    	   BooksInformationDaoImpl p = new BooksInformationDaoImpl();
    	   List<BooksInformation> BookList  = new ArrayList<BooksInformation>();
    	   BookList = p.searchAll();
    	   String[][] obj = new String[5][];
    	int cot = 0 ;
    
    	for(int i = 0 ; i<BookList.size(); i++) {
    		List<BooksInformation> j = (List<BooksInformation>) BookList.get(i);
    		for(BooksInformation buf:j) {
       			obj[cot++] = buf.BooksInformationToString();
    		}
    		i++;
    	}
    	MyTable jTable = new MyTable(obj,TableName);
    	JScrollPane jsp = new JScrollPane(jTable);
    	setTitle("书籍信息");
    	setBounds(500,500,500,500);
    	setVisible(true);
    	jTable.setRowHeight(50);
    	add(jsp,BorderLayout.CENTER);
       }
       
       private void freshlistModel(List<BooksInformation> booksInformations) {
    	   ml.removeAllElements();
    	   for(BooksInformation p: booksInformations) {
    		   ml.addElement(p);
    	   }
       }

       public static void main(String[] args) throws Exception {
	    	new BooksInformationGUI("sb");

	    	}

}
