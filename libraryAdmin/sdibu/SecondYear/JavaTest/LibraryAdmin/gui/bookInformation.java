package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;

import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.bookInformationServImpl;
import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.bookInformationService;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.BooksInformationDaoImpl;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.days;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

public class bookInformation extends RefreshPal implements ActionListener {
	private InformationPal bookInformation;
	private List<String> lblItemNames;	
	private List<JComponent> cptItems;	
	private List<JButton> btnCommond;
	private bookInformationService p;	
	private String users;
	public bookInformation(String user) {
		lblItemNames = new ArrayList<String>();
		lblItemNames.add("书籍名称");
		lblItemNames.add("作者");
		lblItemNames.add("出版日期");
		lblItemNames.add("类别");
		users = user;
		cptItems = new ArrayList<JComponent>();
	    for(int i = 0 ; i< 4 ;i++) {
	    	JTextField t = new JTextField(15);
	    	t.setMaximumSize(t.getPreferredSize());
	    	cptItems.add(t);
	    }
	 //   ((JTextField)cptItems.get(0)).setEditable(false);
	    DefaultListModel<String> model = new DefaultListModel<String>();
	btnCommond = new ArrayList<JButton>();	
	btnCommond.add(new JButton("借书"));
	btnCommond.add(new JButton("还书"));
	btnCommond.add(new JButton("查询"));
	btnCommond.add(new JButton("我的借阅"));			
	for(int i = 0; i <btnCommond.size();i++) {			
		btnCommond.get(i).addActionListener(this);
	}
	try {
		bookInformation = new  InformationPal(lblItemNames,cptItems,btnCommond,3);
	} catch (Exception e) {			
		e.printStackTrace();
	}
	
	this.add(bookInformation);
	p =  new bookInformationServImpl(new BooksInformationDaoImpl());
	fresh();
}

@Override
public void fresh() {
	try {
		bookInformation.freshTable(p.searchAll());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("借书")) {
			String inputValue = JOptionPane.showInputDialog("请输入要借的书籍名:")+"";
			dbBookHistoryFuncion db = new dbBookHistoryFuncion();
			try {
				List<bookHistory> list = db.searchBookHistory(inputValue, "bookName");
				/*System.out.println("list Size is："+list.size());*/
				if(inputValue.equals("null")) {
					;
				}
				else if(list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "查无此书", "警告", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int flag = 0;
					for(bookHistory i:list)
						if(i.isBorrow() == false) {
							flag = 1;
							break;
						}
					for(bookHistory i:list)
						if(i.getUserId().equals(users) && i.isBorrow()==true) {
							flag = -1;
							break;
						}
					if(0==flag) {
						JOptionPane.showMessageDialog(null, "该书籍已全被借出", "警告", JOptionPane.ERROR_MESSAGE);
					}
					else if(-1 == flag)
						JOptionPane.showMessageDialog(null, "你已经借了一本了，书籍虽好，可不要贪心哦", "温馨提示", JOptionPane.ERROR_MESSAGE);
					else {
						int cnt = 0;
						for(int i=0;i<list.size();i++)
							if(list.get(i).isBorrow() == false) {
								cnt = i;
								break;
							}
						bookHistory before = list.get(cnt);
						bookHistory to = before.getbookHistory();
						to.setBorrow(true);
						
						/*从当前时间借书，还书时间为之后60天*/
						Calendar ca = Calendar.getInstance();
						ca.add(Calendar.DATE, 60);// num为增加的天数，可以改变的
						to.setLend(new days(new java.util.Date().getTime()));
						to.setGiveBack(new days(ca.getTime()));
						to.setUserId(users);
						to.setBorrow(true);
						/*System.out.println("Flag is："+list.size());*/
						db.lendBook(before, to);
						JOptionPane.showMessageDialog(null, "书籍已借，请在60天内归还", "提示", JOptionPane.YES_OPTION);
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	
		else if(e.getActionCommand().equals("还书")) {
			String inputValue = JOptionPane.showInputDialog("请输入要归还的书籍名:");
			try {

				//System.out.println("users is:"+users);
				dbBookHistoryFuncion db= new dbBookHistoryFuncion();
				List <bookHistory> bookList = db.searchBookHistory(inputValue, "bookName");
				for(int i=0;i<bookList.size();i++) {

					//System.out.println("bookList Id Is"+bookList.get(i).getUserId());
					//System.out.println("equals="+(users.equals(bookList.get(i).getUserId())) );
					if(!bookList.get(i).getUserId().equals(users))
						bookList.remove(i);
				}
				if(bookList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "你未借此书", "警告", JOptionPane.ERROR_MESSAGE);
				}
				else {
					bookHistory before = bookList.get(0);
					bookHistory to = before.getbookHistory();
					
					to.setBorrow(false);
					to.setUserId("null");
					Calendar ca = Calendar.getInstance();
					to.setLend(new days(new java.util.Date().getTime()));
					to.setGiveBack(new days(ca.getTime()));
					to.setBorrow(false);
					db.lendBook(before, to);
					JOptionPane.showMessageDialog(null, "还书成功", "提示", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			else if(e.getActionCommand().equals("查询"))
		{
				String  name = ((JTextField)cptItems.get(0)).getText().toString();
				//System.out.println(name);
				if(name == null||name.equals("")) {
					JOptionPane.showMessageDialog(null,"请输入姓名");
				}
				bookInformation.freshTable(p.searchByName(name));
				//System.out.println(name);
		}
		else if(e.getActionCommand().equals("我的借阅")) {
			// TODO Auto-generated method stub
			try {
				JButton sure = new JButton("确定");
				JFrame jf = new JFrame();
			    String[]TableName = {"书籍名称","借书日期","还书日期"}; 
				dbBookHistoryFuncion db = new dbBookHistoryFuncion();
				List<bookHistory> BookList = db.searchBookHistory(users, "userId");
			    String[][] obj = new String[BookList.size()][0];
			   	int cot = 0 ;
			   	for(int i = 0 ; i<BookList.size(); i++) {
			   		/*for(String s:BookList.get(i).userToString()) {
			   			System.out.println(s+" ");
			   		}
			   		System.out.println();*/
			   			obj[cot++] = BookList.get(i).userToString();
			   		}
			   	try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					} catch (UnsupportedLookAndFeelException e1) {	
					e1.printStackTrace();
					}	//窗口皮肤
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
			    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
			    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的长宽
				jf.setBounds((width - 1000) / 2,(height - 1000) / 2, 1000, 1000);//窗体大小，居中
				jf.setVisible(true);
				jTable.setRowHeight(50);
				jf.add(jsp,BorderLayout.CENTER);
				jf.add(sure,BorderLayout.AFTER_LAST_LINE);
				sure.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						jf.dispose();
					}
				});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}

