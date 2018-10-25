package dao;

import java.util.List;

import domain.Book;
import domain.Cart;
import domain.Category;
import domain.DBBack;
import domain.Order;
import domain.PageBean;
import domain.QueryInfo;
import domain.User;

public interface BusinessService {

	/**
	 * 分类相关的服务
	 */
	void addCategory(Category c);

	Category findCategory(String id);

	List getAllCategory();

	/**
	 * 图书相关的服务
	 */
	void addBook(Book b);

	Book findBook(String id);
	List getAllBook();
	PageBean bookPageQuery(QueryInfo info);

	/**
	 * 用户相关的服务
	 */
	void addUser(User u);

	User findUser(String username, String password);

	User findUser(String id);

	/**
	 * 订单关的服务
	 */
	//用用户的购物车产生订单对象，并保存到数据库
	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getOrderByState(boolean state);
	
	void update(String id,boolean state);
	
	
	/**
	 * 数据库相关的服务
	 */
	public void addDBBack(DBBack back);
	public DBBack findBack(String id);
	public List getAllBack();
	

}