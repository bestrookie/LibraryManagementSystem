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
		Image icon = Toolkit.getDefaultToolkit().getImage("sdibu//SecondYear/JavaTest/LibraryAdmin/gui/Logo.png");  // ͼƬ�ľ���λ��
		this.setIconImage(icon);   //���ô��ڵ�logo
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		setTitle(name+"ͬѧ����ӭʹ��ͼ���ϵͳ");
		bookInformation p = new bookInformation(id);
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.add("ͼ�����ϵͳ", p);
		tabbed.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				JTabbedPane tb = (JTabbedPane)e.getSource();
				((RefreshPal)tb.getSelectedComponent()).fresh();				
			}			
		});
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĳ���
		this.getContentPane().add(tabbed);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((width - 800) / 2,(height - 600) / 2, 800, 600);
		this.setVisible(true);
		this.setResizable(false);//��ֹ���촰�ڣ����
	}

	public static void main(String[] args) {
		new MainGUI("123","abc");

	}
}
