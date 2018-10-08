package junit.test;
import org.junit.Test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import domain.Order;

public class OrderTest {
	@Test
	public void fintTest(){
		OrderDao dao=new OrderDaoImpl();
		Order o=dao.find("1");
		System.out.print(o);
	}
}
