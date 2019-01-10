package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainGUI extends JFrame {
	public MainGUI() {
		
	}
	public MainGUI(String id,String name) {
		Image icon = Toolkit.getDefaultToolkit().getImage("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/Logo.png");  // 图片的具体位置
		this.setIconImage(icon);   //设置窗口的logo
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		setTitle(name+"同学，欢迎使用图书馆系统");
		bookInformation p = new bookInformation(id);
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.add("图书管理系统", p);
		tabbed.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				JTabbedPane tb = (JTabbedPane)e.getSource();
				((RefreshPal)tb.getSelectedComponent()).fresh();				
			}			
		});
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的长宽
		this.getContentPane().add(tabbed);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((width - 800) / 2,(height - 600) / 2, 800, 600);
		this.setVisible(true);
		this.setResizable(false);//禁止拉伸窗口，最大化
	}

	public static void main(String[] args) {
		new MainGUI("123","abc");

	}
}
