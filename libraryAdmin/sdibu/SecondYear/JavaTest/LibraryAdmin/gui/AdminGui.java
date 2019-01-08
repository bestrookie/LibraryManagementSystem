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
	JButton logOut = new JButton("ע��");
	JButton changeBook = new JButton("�鼮��Ϣ�޸�");
	JButton addBook = new JButton("�����ϼ�");
	JButton frozenUser = new JButton("�����û�");
	JButton unFrozen = new JButton("�û��ⶳ");
	JButton seeLibrary = new JButton("�鿴�ݲ�");
	JPanel jsp = new JPanel();
	JPanel jsp2 = new JPanel();
	public void AdminGuiInit() throws Exception { 
		this.setLayout(new GridLayout(0,2));
		this.setLocationRelativeTo(null);
		this.setResizable(false);	//��������
		
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
		int m = JOptionPane.showConfirmDialog(null, "ȷ���˳���", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION);
		return m==0;
	}
	public void Funcion() {
		JButton sure = new JButton("ȷ��");
		JFrame jf = new JFrame();
		seeLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				    String[]TableName = {"�鼮����","����","��������","���","�鼮״̬"}; 
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
						}	//����Ƥ��
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
