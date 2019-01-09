package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

import java.util.Calendar;

import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.days;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryDriver;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

public class libraryFunction {
	//»¹Êé
		public void returnBook(days giveBack,String bookId) throws Exception {
			dbBookHistoryFuncion db = new dbBookHistoryFuncion();
			bookHistory before= db.searchBookHistory(bookId, "bookId").get(0);
			bookHistory now = before;
			now.setBorrow(false);
			now.setGiveBack(giveBack);
			try {
				db.updateBookHistory(before, now);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void lendBook(days now,int lendDays,String userId) {	
		}
		/*
		//Ðø½è
		public void renew(int days) {
			Calendar ca = Calendar.getInstance();
			ca.add(Calendar.DATE, days);
			bookHistory now = this;
			now.giveBack = (days) ca.getTime();
			dbBookHistoryFuncion db = new dbBookHistoryFuncion();
			try {
				db.updateBookHistory(this, now);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} */ 
}
