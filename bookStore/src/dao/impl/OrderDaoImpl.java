package dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.OrderDao;
import domain.Book;
import domain.Order;
import domain.OrderItem;
import domain.User;
import utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {
	/* (non-Javadoc)
	 * @see dao.impl.OrderDao#add(domain.Order)
	 */
	@Override
	public void add(Order o){
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			String sql="insert into orders (id,ordertime,state,price,user_id) values(?,?,?,?,?)";
			Object params[]={o.getId(),o.getOrdertime(),o.isState(),o.getPrice(),o.getUser().getId()};		
			runner.update(conn, sql, params);
			
			Set<OrderItem> set=o.getOrderitem();
			for(OrderItem item:set){
				String itemSql="insert into orderitem(id,quantity,price,book_id,order_id) values(?,?,?,?,?)";
				Object itemParams[]={item.getId(),item.getQuantity(),item.getPrice(),item.getBook().getId(),o.getId()};
				runner.update(conn, itemSql, itemParams);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/* (non-Javadoc)
	 * @see dao.impl.OrderDao#find(java.lang.String)
	 */
	@Override
	public Order find(String id){
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			//找出订单
			String sql="select * from orders where id=?";
			Order order=(Order) runner.query(conn, sql, id, new BeanHandler(Order.class));
			//找出订单对应的订单项
			sql="select * from orderitem where order_id=?";
			List<OrderItem> list=(List<OrderItem>) runner.query(conn, sql, id, new BeanListHandler(OrderItem.class));
			//找出订单项对应的书
			for(OrderItem item:list){
				sql="select b.* from book b,orderitem oi where oi.id=? and oi.book_id=b.id";
				Book book=(Book) runner.query(conn, sql, item.getId(), new BeanHandler(Book.class));
				item.setBook(book);		
			}
			
			order.getOrderitem().addAll(list);
			//找出下单人
			sql="select u.* from orders o,user u where o.id=? and o.user_id=u.id";
			User user=(User) runner.query(conn, sql, id, new BeanHandler(User.class));
			
			order.setUser(user);
			
			return order;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	//state true为已发货，false为未发货
	/* (non-Javadoc)
	 * @see dao.impl.OrderDao#getAll(boolean)
	 */
	@Override
	public List<Order> getAll(boolean state){	
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			String sql="select * from orders where state=?";
			List<Order> list=(List<Order>) runner.query(conn, sql, state,new BeanHandler(Order.class));
			
			for(Order o:list){
				sql="select u.* from orders o,user u where o.id=? and o.user_id=u.id";
				User user=(User) runner.query(conn, sql, o.getId(), new BeanHandler(User.class));
				o.setUser(user);
			}
			return list;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
}
