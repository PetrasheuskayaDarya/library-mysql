package by.htp.library.dao.impl;

import static by.htp.library.dao.util.MySqlPropertyManager.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.entity.Book;

public class BookDaoImpl implements BookDao {
	
	private static final String SELECT_BOOK_BYID = "SELECT * FROM book WHERE id_book = ?";
	//private static final String SELECT_ALL_BOOKS = "SELECT * FROM book";

	@Override
	public Book read(int id) {
		
		Book book = null;
		
		try(Connection conn = DriverManager.getConnection(getUrl(),getLogin(),getPass())){
			
			PreparedStatement ps = conn.prepareStatement(SELECT_BOOK_BYID);
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = buildBook(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	
	
	@Override
	public List<Book> list () {
		List<Book> list = new ArrayList<Book>();
		try(Connection conn = DriverManager.getConnection(getUrl(),getLogin(),getPass())){
			PreparedStatement ps = conn.prepareStatement(SELECT_BOOK_BYID);
			int id = 1;
			Boolean next = true;
			while (next){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				list.add( buildBook(rs));	
				id++;
			}
			else {
				next= false;
			}
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	

	@Override
	public int add(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}
	
	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setTitle(rs.getString("title"));
		//setAuthor
		return book;
	}

}
