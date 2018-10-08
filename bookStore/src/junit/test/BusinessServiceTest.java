package junit.test;

import org.junit.Test;

import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.PageBean;
import domain.QueryInfo;
import domain.User;
import service.impl.BusinessServiceImpl;
import utils.JdbcUtils;

public class BusinessServiceTest {
	private BusinessServiceImpl service=new BusinessServiceImpl();
	
	@Test
	public void testAddCategory(){
		Category c=new Category();
		c.setId("2");
		c.setName("python develope");
		c.setDescription("asdfeas");
		
		service.addCategory(c);
	}
	
	@Test
	public void testFindCategory(){
		service.findCategory("1");
	}
	@Test
	public void testGetAllCategory(){
		service.getAllCategory();
	}
	@Test
	public void testAddBook(){
		
		
		Book b=new Book();
		b.setAuthor("李顺隆");
		b.setCategory(service.findCategory("1"));
		b.setDescription("火电专家");
		b.setId("1");
		b.setImage("11111");
		b.setName("从燃气发电到系能源的思考");
		b.setPrice(5);
		
		service.addBook(b);
		JdbcUtils.StartTransaction();	
	}
	
	@Test
	public void testFindBook(){
		service.findBook("1");
	}
	
	@Test
	public void testBookPageQuery(){
		QueryInfo info = new QueryInfo();
		info.setCurrentPage(1);
		info.setPageSize(3);
//		info.setQueryName("category_id");
//		info.setQueryValue("1");
		
		PageBean bean=service.bookPageQuery(info);
		System.out.print(bean);
	}
	
	@Test
	public void testAddUser(){
		User u=new User();
		u.setAddress("南京");
		u.setCellphone("13888888888");
		u.setEmail("aa@sina.com");
		u.setId("1");
		u.setPassword("947889");
		u.setPhone("1309999999");
		u.setUsername("圣母");
	
		
		service.addUser(u);
		
	}
	
	@Test
	public void testSaveOrder(){
		User u=new User();
		u.setAddress("南京");
		u.setCellphone("13888888888");
		u.setEmail("aa@sina.com");
		u.setId("1");
		u.setPassword("947889");
		u.setPhone("1309999999");
		u.setUsername("圣母");
		
		Cart c=new Cart();
		CartItem cl=new CartItem();
		Book b=service.findBook("1");
//		cl.setBook(b);
//		cl.setQuantity(2);
		
		c.add(b);
		
		service.saveOrder(c, u);
		service.saveOrder(c, u);
		
	}
	
	@Test
	public void testFindOrder(){
		
		service.findOrder("66a41e6d-e054-4330-9094-65b97baf8568");
		
	}
	
	
}
