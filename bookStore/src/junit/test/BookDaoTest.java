package junit.test;

import java.util.List;

import org.junit.Test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import domain.Category;
import domain.QueryResult;
import utils.JdbcUtils;

public class BookDaoTest {
	
	public void testQuery(){
		BookDao dao=new BookDaoImpl();
		dao.pageQuery(0, 4, null, 1);
	}
	
	public void add(){
		
		Book b=new Book();
		b.setAuthor("Сţ");
		b.setCategory(new Category());
		b.setDescription("css");
		b.setId("6");
		b.setImage("123518");
		b.setName("python");
		b.setPrice(89);
		BookDao dao=new BookDaoImpl();
		dao.add(b);
		
		
		
		
	}
}
