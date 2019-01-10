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
		
		super("登录");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的长宽
		Container c =this.getContentPane();
		
		//JFrame jf = new JFrame();
		Image icon = Toolkit.getDefaultToolkit().getImage("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/Logo.png");  // 图片的具体位置
		this.setIconImage(icon);   //设置窗口的logo
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//窗口皮肤
		
		c.setLayout(new BorderLayout());//边界布局
		
		//Image backGround = Toolkit.getDefaultToolkit().getImage("src/sdibu//SecondYear/JavaTest/LibraryAdmin/gui/BackGround.png");
		ImageIcon backGround = new ImageIcon("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/BackGround.jpg");
		JLabel label = new JLabel(null,backGround,JLabel.CENTER);
		c.add(label,BorderLayout.NORTH);
		//添加背景图在上方
		ImageIcon userLogo = new ImageIcon("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/userLogo.png");
		JLabel label2 = new JLabel(null,userLogo,JLabel.CENTER);
		c.add(label2,BorderLayout.WEST);
		//左侧小头像
		JTextField username=new JTextField("用户名",30);
		
		//用户名框
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
		//密码框
		JPanel top = new JPanel();
		Component box1 = Box.createVerticalStrut(100);
		//JLabel tip = new JLabel("<html> <br><br><br><br>密码<html>");
		top.add(box1);
		top.add(username);
		//top.add(tip);
		top.add(password);
		c.add(top);
		//组合放到边界布局中间
		//ImageIcon loginLogo = new ImageIcon("src/sdibu//SecondYear/JavaTest/LibraryAdmin/gui/loginLogo.png");
		JPanel down = new JPanel();
		JButton login = new JButton("登录"/*,loginLogo*/);
		Dimension preferredSize = new Dimension(100,30);
		login.setPreferredSize(preferredSize );//设置按钮大小
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDaoImpl loginId = new UserDaoImpl();
				List<users> list = new ArrayList<users>();
				try {
					if(username.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "账号不能为空，请重新输入", "错误", 
								JOptionPane.ERROR_MESSAGE);
					
				}else {
					list = loginId.searchById(username.getText());
					if(list.isEmpty()) {
						//用户不存在
						//System.out.println("X");
						JOptionPane.showMessageDialog(null, "账号不存在，请检查账号", "错误", 
								JOptionPane.ERROR_MESSAGE);
						
					}
					else {
							//用户存在
							String c1 = new String(list.get(0).getPassward());
							String c2 = new String(password.getPassword());
//							System.out.println(c1.length());
//							
//							System.out.println(c2.length());
//							System.out.println(list.get(0).getPassward().equals(password.getPassword()));
							//密码正确
							if(c1.equals(c2)) {
								//关闭当前窗体，打开主界面窗体（判断用户身份）
								boolean fr = list.get(0).isFrozen();
								//判断账号是否被冻结
								if(fr) {
									JOptionPane.showMessageDialog(null, "账号已被冻结，请联系管理员进行解封", "错误", 
											JOptionPane.ERROR_MESSAGE);
								}else {
									boolean sf = list.get(0).isPower();
									if(sf) {
									 	//判断用户身份为管理
										AdminGui superAdmin = new AdminGui();
										superAdmin.Funcion();
										superAdmin.AdminGuiInit();
										dispose();//关闭当前窗体
										
									}
									else {
										MainGUI normalUser = new MainGUI(list.get(0).getId(), c2);
										dispose();//关闭当前窗体
									}
								}
								
							}//密码错误
							else {
								JOptionPane.showMessageDialog(null, "密码错误，请检查账号密码", "错误", 
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
		//登录按钮，放在下方
		JPanel east = new JPanel();
		final JLabel east1 = new JLabel("<html> <br><br><br><br>忘记密码<html>");
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
					URI uri = new URI("file:///C:/Users/bestsort/Desktop/GUI素材/ForgotPassward.html");//找回密码本地超链接
					//注：可以通过web实现数据库管理，后续优化
					
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
		//找回密码的超链接
		this.pack();
		this.setVisible(true);//窗体可见
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(600, 450);
		this.setBounds((width - 600) / 2,(height - 500) / 2, 600, 500);//窗体大小，居中
		this.setResizable(false);//禁止拉伸窗口，最大化
	}
	
	
	public static void main(String[] args) {
		new LoginGUI();

	}

}
