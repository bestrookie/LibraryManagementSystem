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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class addBookInformationGUI extends JFrame {
	public addBookInformationGUI() {
		super("�����ϼ�");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĳ���
	    try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}			//����Ƥ��
		Container c =this.getContentPane();
//		GroupLayout group = new GroupLayout(c);
//		c.setLayout(group);
		JPanel box = new JPanel();
		
		JPanel box1 = new JPanel();
		Component n1 = Box.createVerticalStrut(50);
		final JLabel tips1 = new JLabel("�鼮����");
		JTextField ip1 = new JTextField(30);
		box1.add(n1);
		box1.add(tips1);
		box1.add(ip1);
		box.add(box1);
		
		JPanel box2 = new JPanel();
		Component n2 = Box.createVerticalStrut(50);
		final JLabel tips2 = new JLabel("     ����");
		JTextField ip2 = new JTextField(30);
		box2.add(n2);
		box2.add(tips2);
		box2.add(ip2);
		box.add(box2);
		
		JPanel box3 = new JPanel();
		Component n3 = Box.createVerticalStrut(50);
		final JLabel tips3 = new JLabel("��������");
		JTextField ip3 = new JTextField(30);
		box3.add(n3);
		box3.add(tips3);
		box3.add(ip3);
		box.add(box3);
		
		JPanel box4 = new JPanel();
		Component n4 = Box.createVerticalStrut(50);
		final JLabel tips4 = new JLabel("     ���");
		JTextField ip4 = new JTextField(30);
		box4.add(n4);
		box4.add(tips4);
		box4.add(ip4);
		box.add(box4);
		
		JPanel box5 = new JPanel();
		Component n5 = Box.createVerticalStrut(50);
		final JLabel tips5 = new JLabel("�鼮��Ŀ");
		JTextField ip5 = new JTextField(30);
		box5.add(n5);
		box5.add(tips5);
		box5.add(ip5);
		box.add(box5);
		
		c.add(box);
		
		JPanel down = new JPanel();
		JButton sure = new JButton("ȷ��");
		Dimension preferredSize = new Dimension(100,30);
		sure.setPreferredSize(preferredSize );//���ð�ť��С
		down.add(sure);
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		c.add(down, BorderLayout.SOUTH);
		
		
		
		this.pack();
		this.setVisible(true);//����ɼ�
		//this.setSize(600, 450);
		this.setBounds((width - 500) / 2,(height - 400) / 2, 500, 400);//�����С������
		this.setResizable(false);//��ֹ���촰�ڣ����
	}

	public static void main(String[] args) {
		new addBookInformationGUI();

	}

}
