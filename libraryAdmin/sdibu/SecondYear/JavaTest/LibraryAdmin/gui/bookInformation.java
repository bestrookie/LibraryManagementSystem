package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.bookInformationServImpl;
import sdibu.SecondYear.JavaTest.LibraryAdmin.Service.bookInformationService;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.BooksInformationDaoImpl;

public class bookInformation extends RefreshPal implements ActionListener {
	private InformationPal bookInformation;
	private List<String> lblItemNames;	
	private List<JComponent> cptItems;	
	private List<JButton> btnCommond;
	private bookInformationService p;
	public bookInformation() {
		lblItemNames = new ArrayList<String>();
		lblItemNames.add("书籍名称");
		lblItemNames.add("作者");
		lblItemNames.add("出版日期");
		lblItemNames.add("类别");
		cptItems = new ArrayList<JComponent>();
	    for(int i = 0 ; i< 4 ;i++) {
	    	JTextField t = new JTextField(15);
	    	t.setMaximumSize(t.getPreferredSize());
	    	cptItems.add(t);
	    }
	 //   ((JTextField)cptItems.get(0)).setEditable(false);
	    DefaultListModel<String> model = new DefaultListModel<String>();
	btnCommond = new ArrayList<JButton>();	
	btnCommond.add(new JButton("借书"));
	btnCommond.add(new JButton("还书"));
	btnCommond.add(new JButton("查询"));
	btnCommond.add(new JButton("我的借阅"));			
	for(int i = 0; i <btnCommond.size();i++) {			
		btnCommond.get(i).addActionListener(this);
	}
	try {
		bookInformation = new  InformationPal(lblItemNames,cptItems,btnCommond,3);
	} catch (Exception e) {			
		e.printStackTrace();
	}
	
	this.add(bookInformation);
	p =  new bookInformationServImpl(new BooksInformationDaoImpl());
	fresh();
}

@Override
public void fresh() {
	try {
		bookInformation.freshTable(p.searchAll());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("借书")) {
		
	}

	else if(e.getActionCommand().equals("还书"))
		System.out.println("还书");
	else if(e.getActionCommand().equals("查询"))
	{
		
	}
	else if(e.getActionCommand().equals("我的借阅"))
		System.out.println("我的借阅");	
	
}
}

