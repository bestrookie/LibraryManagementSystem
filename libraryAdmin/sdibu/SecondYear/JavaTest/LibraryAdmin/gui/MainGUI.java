package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainGUI extends JFrame {
	public MainGUI(String userId) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		bookInformation p = new bookInformation();
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.add("图书管理系统", p);
		tabbed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JTabbedPane tb = (JTabbedPane)e.getSource();
				((RefreshPal)tb.getSelectedComponent()).fresh();				
			}			
		});
		this.getContentPane().add(tabbed);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 200, 800, 600);
		this.setVisible(true);
	}

}
