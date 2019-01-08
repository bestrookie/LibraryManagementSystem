package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.BooksInformationDaoImpl;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

public class AdminGui extends JFrame{
	Container con = this.getContentPane();
	JButton logOut = new JButton("注销");
	JButton changeBook = new JButton("书籍信息修改");
	JButton addBook = new JButton("新书上架");
	JButton frozenUser = new JButton("冻结用户");
	JButton unFrozen = new JButton("用户解冻");
	JButton seeLibrary = new JButton("查看馆藏");
	JPanel jsp = new JPanel();
	JPanel jsp2 = new JPanel();
	public void AdminGuiInit() throws Exception { 
		this.setLayout(new GridLayout(0,2));
		this.setLocationRelativeTo(null);
		this.setResizable(false);	//不可拉伸
		
		jsp.add(logOut);
		jsp.add(addBook);
		jsp.add(frozenUser);
		jsp2.add(seeLibrary);
		jsp2.add(unFrozen);
		jsp2.add(changeBook);
		
		jsp2.setLayout(new BoxLayout(jsp2,BoxLayout.Y_AXIS));
		jsp.setLayout(new BoxLayout(jsp,BoxLayout.Y_AXIS));
		this.add(jsp);
		this.add(jsp2);
		
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public boolean giveBackAction() {
		int m = JOptionPane.showConfirmDialog(null, "确定退出？", "温馨提示", JOptionPane.YES_NO_OPTION);
		return m==0;
	}
	public void Funcion() {
		JButton sure = new JButton("确定");
		JFrame jf = new JFrame();
		seeLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				    String[]TableName = {"书籍名称","作者","出版日期","类别","书籍状态"}; 
					List<BooksInformation> BookList = new BooksInformationDaoImpl().searchAll();
					String[][] obj = new String[BookList.size()][0];
				   	int cot = 0 ;
				   	for(int i = 0 ; i<BookList.size(); i++) {
				   			obj[cot++] = BookList.get(i).BooksInformationToString();
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
					jf.setBounds(500,500,500,500);
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
		});
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(giveBackAction())
					dispose();
			}
		});
		addBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBookInformationGUI addBook = new addBookInformationGUI();
				
			}
		});
	}
	public static void main(String[] args) throws Exception {
		AdminGui xx = new AdminGui();
		xx.Funcion();
		xx.AdminGuiInit();
		
     }
}
