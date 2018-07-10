package by.htp.library.run;

import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoImpl;
import by.htp.library.entity.Book;

public class MainLibraryController {

	public static void main(String[] args) {
		
		BookDao dao = new BookDaoImpl();
        Book book = dao.read(1);
        
       List<Book> list = dao.list();
      
        System.out.println(dao.list().toString());
		
		System.out.println(book);

	}

}
