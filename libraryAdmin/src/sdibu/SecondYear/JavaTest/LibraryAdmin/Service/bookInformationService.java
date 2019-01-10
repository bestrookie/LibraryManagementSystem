package sdibu.SecondYear.JavaTest.LibraryAdmin.Service;

import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.BooksInformation;
import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;



public interface bookInformationService {
	List<BooksInformation> searchAll();

	List<BooksInformation> searchByName(String name);
	List<bookHistory> searchHistory(String func,String title);
}
