package sdibu.SecondYear.JavaTest.LibraryAdmin.gui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class MyTable extends JTable{
	public MyTable(DefaultTableModel tableModel){//Vector rowData,Vector columnNames
        super(tableModel);//调用父类的构造方法
         
    }
    //重写JTable类的getTableHeader()方法
     
    public MyTable(String[][] obj, String[] columnNames) {
		// TODO Auto-generated constructor stub
    	super(obj,columnNames);
	}

    //重写Jtable类的isCellEditable(int row,int column)方法
    public boolean isCellEditable(int row,int column){//表格不可编辑
        return false;
    }
}
