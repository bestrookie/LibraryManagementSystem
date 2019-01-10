package sdibu.SecondYear.JavaTest.LibraryAdmin.Service;

import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.BooksInformationDao;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.dbBookHistoryFuncion;

public class bookInformationServImpl implements bookInformationService {
	private   BooksInformationDao booksInformationDao;
	public bookInformationServImpl(BooksInformationDao booksInformationDao) {
		this.booksInformationDao = booksInformationDao;
	}

	@Override
	public List<BooksInformation> searchAll() {
		try {
			return booksInformationDao.searchAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		@Override
		public List<BooksInformation> searchByName(String name) {
			try {
				return booksInformationDao.searByName(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	public List<bookHistory> searchHistory(String func,String title){
		try {
			return new dbBookHistoryFuncion().searchBookHistory(func, title);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

}
