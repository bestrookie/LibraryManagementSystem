package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.FrozenUser;
import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.UnFrozenUser;

public class AdminGui extends JFrame{
	Container con = this.getContentPane();
	JButton logOut = new JButton("ע���û�");
	JButton changeBook = new JButton("�鼮�¼�");
	JButton addBook = new JButton("�����ϼ�");
	JButton frozenUser = new JButton("�����û�");
	JButton unFrozen = new JButton("�û��ⶳ");
	JButton seeLibrary = new JButton("�鿴�ݲ�");
	JButton adduser = new JButton("����û�");
	
	
	
	//JButton deluser = new JButton("ɾ���û�");
	JPanel jsp = new JPanel();
	public void AdminGuiInit() throws Exception { 
		this.setTitle("����Ա");
		//this.setLayout(new GridLayout(0,2,30,30));
		this.setLocationRelativeTo(null);
		this.setResizable(false);	//��������
		
		ImageIcon backGround = new ImageIcon("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/AdminMainUI.jpg");
		JLabel label = new JLabel(null,backGround,JLabel.CENTER);
		con.add(label,BorderLayout.NORTH);
		
		Component box1 = Box.createVerticalStrut(150);
		jsp.add(box1);
		jsp.add(frozenUser);
		jsp.add(unFrozen);
		jsp.add(adduser);
		jsp.add(addBook);
		jsp.add(changeBook);
		jsp.add(seeLibrary);
		jsp.add(logOut);
		//jsp2.add(deluser);
		//jsp.setLayout(new BoxLayout(jsp,BoxLayout.Y_AXIS));
		this.add(jsp);
		
		
		Image icon = Toolkit.getDefaultToolkit().getImage("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/Logo.png");  // ͼƬ�ľ���λ��
		this.setIconImage(icon);   //���ô��ڵ�logo
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//����Ƥ��
		
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĳ���
		this.setBounds((width - 650) / 2,(height - 500) / 2, 650, 500);//�����С������
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
	/**************�鿴�ݲ�**********************/
		seeLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				    String[]TableName = {"�鼮����","����","��������","���","�鼮״̬"}; 
					List<BooksInformation> BookList = new BooksInformationDaoImpl().searchAll();
					String[][] obj = new String[BookList.size()][0];
				   	int cot = 0 ;
				   	for(int i = 0 ; i<BookList.size(); i++) {
				   			/*for(String x:BookList.get(i).BooksInformationToString())
				   				System.out.print(x+" ");
				   			System.out.println("BookList.size is "+BookList.size());*/
				   			obj[cot++] = BookList.get(i).BooksInformationToString();
				   		}
				   	
				   	MyTable jTable = new MyTable(obj,TableName);
				   	//���õ����ͷ�Զ�ʵ������
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
				    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĳ���
					jf.setBounds((width - 1000) / 2,(height - 1000) / 2, 1000, 1000);//�����С������
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
/******************�����鼮**********************/
		addBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBookInformationGUI addBook = new addBookInformationGUI();
				
			}
		});
/******************�¼��鼮**********************/
		changeBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputValue = JOptionPane.showInputDialog("������Ҫ�¼ܵ��鼮ID:");
				try {
					BooksInformation bookList = new BooksInformationDaoImpl().searchById(inputValue);
					if(inputValue == "") {
					
					}
					else if(bookList.getBookName()==null) {
						JOptionPane.showMessageDialog(null, "���޴���", "����", JOptionPane.ERROR_MESSAGE);
					}
					else {
												
						dbBookHistoryFuncion dbHistory = new dbBookHistoryFuncion();
						BooksInformationDaoImpl bookInf = new BooksInformationDaoImpl();
						dbHistory.deleteBookHistory(inputValue);
						bookInf.deleteInformation(inputValue);
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		/******************�����˺�**********************/
		frozenUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = JOptionPane.showInputDialog(null,"�������˺ţ�\n","�����û�",
						JOptionPane.PLAIN_MESSAGE);
				try {
					FrozenUser frozenUser = new FrozenUser(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		/******************�ⶳ�˺�**********************/
		unFrozen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null,"�������˺ţ�\n","�û��ⶳ",
						JOptionPane.PLAIN_MESSAGE);
				try {
					UnFrozenUser unfro = new UnFrozenUser(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		/******************����û�*************/
		adduser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addUserGUI add = new addUserGUI();
			}
			
		});
	}
	public static void main(String[] args) throws Exception {
		AdminGui xx = new AdminGui();
		xx.Funcion();
		xx.AdminGuiInit();
		
     }
}
