package sdibu.SecondYear.JavaTest.LibraryAdmin.util.dbBookHistory;

import java.util.List;

import sdibu.SecondYear.JavaTest.LibraryAdmin.bean.bookHistory;

public class functionTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        /*int result=add("java",888,"С��",1);
        if(result==1){
            System.out.println("��ӳɹ�");
        }else{
            System.out.println("���ʧ��");
        }*/
        dbBookHistoryFuncion dbFunc = new dbBookHistoryFuncion();
        List<bookHistory> book=dbFunc.searchBookHistory("java3", "bookId");
        for(bookHistory k:book) {
        	System.out.println(k.getUserId()+k.getBookId());
        }
        
    }
}

