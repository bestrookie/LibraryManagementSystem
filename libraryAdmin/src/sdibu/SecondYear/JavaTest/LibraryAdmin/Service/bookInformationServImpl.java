package sdibu.SecondYear.JavaTest.LibraryAdmin.Service;

import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.dao.BooksInformationDao;

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
		}
		return null;
	}

}
