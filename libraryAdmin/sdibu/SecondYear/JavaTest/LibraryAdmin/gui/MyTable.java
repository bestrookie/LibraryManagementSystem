package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class MyTable extends JTable{
	public MyTable(DefaultTableModel tableModel){//Vector rowData,Vector columnNames
        super(tableModel);//���ø���Ĺ��췽��
         
    }
    //��дJTable���getTableHeader()����
     
    public MyTable(String[][] obj, String[] columnNames) {
		// TODO Auto-generated constructor stub
    	super(obj,columnNames);
	}

    //��дJtable���isCellEditable(int row,int column)����
    public boolean isCellEditable(int row,int column){//��񲻿ɱ༭
        return false;
    }
}
