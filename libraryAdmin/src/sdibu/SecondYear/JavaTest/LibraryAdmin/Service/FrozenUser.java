package sdibu.SecondYear.JavaTest.LibraryAdmin.Service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.UserDaoImpl;

public class FrozenUser {
	UserDaoImpl fro = new UserDaoImpl();
	public FrozenUser(String id) throws Exception {
		List<users> list = new ArrayList<users>();
		list = fro.searchById(id);
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "��������ȷ���˺�", "��ʾ", 
					JOptionPane.ERROR_MESSAGE);
		}else {
			
			users user = list.get(0);
			if(user.isFrozen()) {
				JOptionPane.showMessageDialog(null, "���˺��ѱ����ᣬ�����ظ�����", "��ʾ", 
						JOptionPane.ERROR_MESSAGE);
			}else {
				user.setFrozen(true);
				fro.updateUser(user);
				JOptionPane.showMessageDialog(null, "�ɹ����˺Ŷ���ɹ�", "�ɹ�", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}

	public static void main(String[] args) {
//		try {
//			FrozenUser frozenUser = new FrozenUser("10007");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
