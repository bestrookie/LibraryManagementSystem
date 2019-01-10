package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.UserDaoImpl;





public class LoginGUI extends JFrame {
	
	public LoginGUI(){
		
		super("��¼");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĳ���
		Container c =this.getContentPane();
		
		//JFrame jf = new JFrame();
		Image icon = Toolkit.getDefaultToolkit().getImage("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/Logo.png");  // ͼƬ�ľ���λ��
		this.setIconImage(icon);   //���ô��ڵ�logo
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//����Ƥ��
		
		c.setLayout(new BorderLayout());//�߽粼��
		
		//Image backGround = Toolkit.getDefaultToolkit().getImage("src/sdibu//SecondYear/JavaTest/LibraryAdmin/gui/BackGround.png");
		ImageIcon backGround = new ImageIcon("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/BackGround.jpg");
		JLabel label = new JLabel(null,backGround,JLabel.CENTER);
		c.add(label,BorderLayout.NORTH);
		//��ӱ���ͼ���Ϸ�
		ImageIcon userLogo = new ImageIcon("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/userLogo.png");
		JLabel label2 = new JLabel(null,userLogo,JLabel.CENTER);
		c.add(label2,BorderLayout.WEST);
		//���Сͷ��
		JTextField username=new JTextField("�û���",30);
		
		//�û�����
		JPasswordField password=new JPasswordField(30);
		password.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//�����
		JPanel top = new JPanel();
		Component box1 = Box.createVerticalStrut(100);
		//JLabel tip = new JLabel("<html> <br><br><br><br>����<html>");
		top.add(box1);
		top.add(username);
		//top.add(tip);
		top.add(password);
		c.add(top);
		//��Ϸŵ��߽粼���м�
		//ImageIcon loginLogo = new ImageIcon("src/sdibu//SecondYear/JavaTest/LibraryAdmin/gui/loginLogo.png");
		JPanel down = new JPanel();
		JButton login = new JButton("��¼"/*,loginLogo*/);
		Dimension preferredSize = new Dimension(100,30);
		login.setPreferredSize(preferredSize );//���ð�ť��С
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDaoImpl loginId = new UserDaoImpl();
				List<users> list = new ArrayList<users>();
				try {
					if(username.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�����������", "����", 
								JOptionPane.ERROR_MESSAGE);
					
				}else {
					list = loginId.searchById(username.getText());
					if(list.isEmpty()) {
						//�û�������
						//System.out.println("X");
						JOptionPane.showMessageDialog(null, "�˺Ų����ڣ������˺�", "����", 
								JOptionPane.ERROR_MESSAGE);
						
					}
					else {
							//�û�����
							String c1 = new String(list.get(0).getPassward());
							String c2 = new String(password.getPassword());
//							System.out.println(c1.length());
//							
//							System.out.println(c2.length());
//							System.out.println(list.get(0).getPassward().equals(password.getPassword()));
							//������ȷ
							if(c1.equals(c2)) {
								//�رյ�ǰ���壬�������洰�壨�ж��û���ݣ�
								boolean fr = list.get(0).isFrozen();
								//�ж��˺��Ƿ񱻶���
								if(fr) {
									JOptionPane.showMessageDialog(null, "�˺��ѱ����ᣬ����ϵ����Ա���н��", "����", 
											JOptionPane.ERROR_MESSAGE);
								}else {
									boolean sf = list.get(0).isPower();
									if(sf) {
									 	//�ж��û����Ϊ����
										AdminGui superAdmin = new AdminGui();
										superAdmin.Funcion();
										superAdmin.AdminGuiInit();
										dispose();//�رյ�ǰ����
										
									}
									else {
										MainGUI normalUser = new MainGUI(list.get(0).getId(), c2);
										dispose();//�رյ�ǰ����
									}
								}
								
							}//�������
							else {
								JOptionPane.showMessageDialog(null, "������������˺�����", "����", 
										JOptionPane.ERROR_MESSAGE);
							}
						
					}
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		down.add(login);
		c.add(down,BorderLayout.SOUTH);
		getRootPane().setDefaultButton(login);
		//��¼��ť�������·�
		JPanel east = new JPanel();
		final JLabel east1 = new JLabel("<html> <br><br><br><br>��������<html>");
		east1.addMouseListener(new MouseListener() {
			
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				east1.setForeground(Color.BLACK);
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				east1.setForeground(Color.blue);
				east1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI("file:///C:/Users/bestsort/Desktop/GUI�ز�/ForgotPassward.html");//�һ����뱾�س�����
					//ע������ͨ��webʵ�����ݿ���������Ż�
					
					Desktop desktop = Desktop.getDesktop();
					
					if(Desktop.isDesktopSupported()&&desktop.isSupported(Desktop.Action.BROWSE)) {
						try {
							desktop.browse(uri);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		east.add(east1);
		c.add(east,BorderLayout.EAST);
		//�һ�����ĳ�����
		this.pack();
		this.setVisible(true);//����ɼ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(600, 450);
		this.setBounds((width - 600) / 2,(height - 500) / 2, 600, 500);//�����С������
		this.setResizable(false);//��ֹ���촰�ڣ����
	}
	
	
	public static void main(String[] args) {
		new LoginGUI();

	}

}
