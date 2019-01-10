package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.addUser;


public class addUserGUI extends JFrame {
	public addUserGUI() {
		super("添加用户");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的长宽
	    try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//窗口皮肤
		Container c =this.getContentPane();
//		GroupLayout group = new GroupLayout(c);
//		c.setLayout(group);
		JPanel box = new JPanel();
		
		JPanel box1 = new JPanel();
		Component n1 = Box.createVerticalStrut(50);
		final JLabel tips1 = new JLabel("账号");
		JTextField ip1 = new JTextField(30);
		box1.add(n1);
		box1.add(tips1);
		box1.add(ip1);
		box.add(box1);
		
		JPanel box2 = new JPanel();
		Component n2 = Box.createVerticalStrut(50);
		final JLabel tips2 = new JLabel("姓名");
		JTextField ip2 = new JTextField(30);
		box2.add(n2);
		box2.add(tips2);
		box2.add(ip2);
		box.add(box2);
		
		JPanel box3 = new JPanel();
		Component n3 = Box.createVerticalStrut(50);
		final JLabel tips3 = new JLabel("密码");
		JTextField ip3 = new JTextField("123456",30);
		box3.add(n3);
		box3.add(tips3);
		box3.add(ip3);
		box.add(box3);
		
		
		JPanel down = new JPanel();
		JButton sure = new JButton("确定");
		JButton off = new JButton("取消");
		Dimension preferredSize = new Dimension(100,30);
		sure.setPreferredSize(preferredSize );
		off.setPreferredSize(preferredSize);//设置按钮大小
		off.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				users user = new users(ip1.getText(), ip2.getText(), ip3.getText(), false, false);
				try {
					if(new addUser().addUser(user)) {
						JOptionPane.showMessageDialog(null, "添加成功", "成功", 
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "添加失败", "错误", 
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		down.add(sure);
		down.add(off);
		
		
		c.add(box);
		c.add(down, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);//窗体可见
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(600, 450);
		this.setBounds((width - 500) / 2,(height - 400) / 2, 500, 400);//窗体大小，居中
		this.setResizable(false);//禁止拉伸窗口，最大化
	}

	public static void main(String[] args) {
		new addUserGUI();

	}

}
