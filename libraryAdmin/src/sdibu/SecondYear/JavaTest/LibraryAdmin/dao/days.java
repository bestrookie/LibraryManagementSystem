package sdibu.SecondYear.JavaTest.LibraryAdmin.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class days extends Date{
	Date buf = new Date();
	public days(long time) {
		super(time);
	}
	public days(Date x) {
		this.buf = x;
	}
	public String toString() {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
    	return time.format(buf);
    }
	
}
