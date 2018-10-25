package dao;

import java.util.List;

import domain.Order;

public interface OrderDao {

	void add(Order o);

	Order find(String id);

	//state true为已发货，false为未发货
	List<Order> getAll(boolean state);
	public void update(String id,boolean state);

}