package sdibu.SecondYear.JavaTest.LibraryAdmin.Service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.users;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.UserDaoImpl;

public class UnFrozenUser {
	UserDaoImpl fro = new UserDaoImpl();
	public UnFrozenUser(String id) throws Exception {
		List<users> list = new ArrayList<users>();
		list = fro.searchById(id);
		users user = list.get(0);
		if(!user.isFrozen()) {
			JOptionPane.showMessageDialog(null, "���˺�δ�����ᣬ����ⶳ", "��ʾ", 
					JOptionPane.ERROR_MESSAGE);
		}else {
			user.setFrozen(false);
			fro.updateUser(user);
			JOptionPane.showMessageDialog(null, "�ɹ����˺Žⶳ�ɹ�", "�ɹ�", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		try {
			UnFrozenUser unfrozenUser = new UnFrozenUser("10005");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
