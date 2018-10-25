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
	 * ������صķ���
	 */
	void addCategory(Category c);

	Category findCategory(String id);

	List getAllCategory();

	/**
	 * ͼ����صķ���
	 */
	void addBook(Book b);

	Book findBook(String id);
	List getAllBook();
	PageBean bookPageQuery(QueryInfo info);

	/**
	 * �û���صķ���
	 */
	void addUser(User u);

	User findUser(String username, String password);

	User findUser(String id);

	/**
	 * �����صķ���
	 */
	//���û��Ĺ��ﳵ�����������󣬲����浽���ݿ�
	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getOrderByState(boolean state);
	
	void update(String id,boolean state);
	
	
	/**
	 * ���ݿ���صķ���
	 */
	public void addDBBack(DBBack back);
	public DBBack findBack(String id);
	public List getAllBack();
	

}