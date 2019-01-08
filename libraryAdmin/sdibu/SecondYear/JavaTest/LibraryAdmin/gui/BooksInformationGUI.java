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
		super("ͼ���");
		
		Container c = this.getContentPane();
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//����Ƥ��

		JPanel box1 = new JPanel();
		box1.setLayout(new BoxLayout(box1,BoxLayout.Y_AXIS));
		Component box4 = Box.createVerticalStrut(30);
		Component box5 = Box.createVerticalStrut(100);
		Component box6 = Box.createVerticalStrut(100);
	    JButton btn1 = new JButton("����");
	    JButton btn2 = new JButton("����");
	    JButton btn3 = new JButton("�ҵĽ���");
	    box1.add(box4);
	    box1.add(btn1); 
	    box1.add(box5);
	    box1.add(btn2);
	    box1.add(box6);
	    box1.add(btn3);
	    add(box1,BorderLayout.EAST);
		
		JPanel up = new JPanel();
		JTextField ss = new JTextField("������Ҫ���ҵ��鼮����",50);
		Component box = Box.createVerticalStrut(100);
		up.add(box);
		up.add(ss);
		c.add(up, BorderLayout.NORTH);
		
		//JList<BooksInformation> books = new JList<BooksInformation>();
          
          
          
       String[]TableName = {"�鼮����","����","��������","���","�鼮״̬"}; 
   	   BooksInformationDaoImpl p = new BooksInformationDaoImpl();
   	   List<BooksInformation> BookList  = new ArrayList<BooksInformation>();
   	   BookList = p.searchAll();
   	   String[][] obj = new String[BookList.size()][0];
	   	int cot = 0 ;
	   	for(int i = 0 ; i<BookList.size(); i++) {
	   			obj[cot++] = BookList.get(i).BooksInformationToString();
	   		}
	 
	   	MyTable jTable = new MyTable(obj,TableName);
	   	
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
	   	
	   	JScrollPane jsp = new JScrollPane(jTable);
	   	setTitle("�װ���ͬѧ:"+userName+"��ã���ӭ����xx����ͼ��ݽ軹��ϵͳ");
	   	setBounds(500,500,500,500);
	   	setVisible(true);
	   	jTable.setRowHeight(50);
	   	add(jsp,BorderLayout.CENTER);
	   	
	   	//�¼�
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
		this.setVisible(true);//����ɼ�
		//this.setSize(600, 450);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĳ���
		this.setBounds((width - 800) / 2,(height - 600) / 2, 800, 600);//�����С������
		this.setResizable(false);//��ֹ���촰�ڣ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
       public void CreatList() throws Exception {
    	   String[]TableName = {"id","�鼮����","����","��������","���"}; 
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
    	setTitle("�鼮��Ϣ");
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
