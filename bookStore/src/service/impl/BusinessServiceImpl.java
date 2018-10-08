package service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import dao.BookDao;
import dao.BusinessService;
import dao.CategoryDao;
import dao.OrderDao;
import dao.UserDao;
import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.PageBean;
import domain.QueryInfo;
import domain.QueryResult;
import domain.User;
import factory.DaoFactory;

public class BusinessServiceImpl implements BusinessService {
	CategoryDao cdao=DaoFactory.getInstance().creatDao(CategoryDao.class);
	BookDao bdao=DaoFactory.getInstance().creatDao(BookDao.class);
	OrderDao odao=DaoFactory.getInstance().creatDao(OrderDao.class);
	UserDao udao=DaoFactory.getInstance().creatDao(UserDao.class);
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#addCategory(domain.Category)
	 */
	@Override
	public void addCategory(Category c){
		cdao.add(c);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findCategory(java.lang.String)
	 */
	@Override
	public Category findCategory(String id){
		return cdao.find(id);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAll()
	 */
	@Override
	public List getAllCategory(){
		return cdao.getAll();
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#addBook(domain.Book)
	 */
	@Override
	public void addBook(Book b){
		bdao.add(b);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findBook(java.lang.String)
	 */
	@Override
	public Book findBook(String id){
		return bdao.find(id);
	}

	/* (non-Javadoc)
	 * @see service.impl.BusinessService#bookPageQuery(domain.QueryInfo)
	 */
	@Override
	public PageBean bookPageQuery(QueryInfo info){
		QueryResult result=bdao.pageQuery(info.getStartIndex(), info.getPageSize(), info.getWhere(), info.getQueryValue());
		PageBean bean=new PageBean();
		bean.setCurrentPage(info.getCurrentPage());
		bean.setList(result.getList());
		bean.setPageSize(info.getPageSize());
		bean.setTotalRecord(result.getTotalRecord());
		return bean;
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#addUser(domain.User)
	 */
	@Override
	public void addUser(User u){
		udao.add(u);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUser(String username,String password){
		return udao.find(username,password);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String id){
		return udao.find(id);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#saveOrder(domain.Cart, domain.User)
	 */
	//用用户的购物车产生订单对象，并保存到数据库
	@Override
	public void saveOrder(Cart cart,User user){
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		
		//定义一个集合，用于保存所有订单项
		Set oitems=new HashSet();
		//用购物车中的购物项生成订单项
		Set<Map.Entry<String, CartItem>> cartItems=cart.getMap().entrySet();
		for(Map.Entry<String, CartItem> entry:cartItems){
			CartItem citem=entry.getValue();//得到每一个购物项
			OrderItem oitem=new OrderItem();
			oitem.setBook(citem.getBook());
			oitem.setId(UUID.randomUUID().toString());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			
			oitems.add(oitem);
		}
		
		order.setOrderitem(oitems);
		odao.add(order);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findOrder(java.lang.String)
	 */
	@Override
	public Order findOrder(String id){
		return odao.find(id);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getOrderByState(boolean)
	 */
	@Override
	public List getOrderByState(boolean state){
		return odao.getAll(state);
	}
	@Override
	public List getAllBook() {
		return bdao.getAlBook();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
