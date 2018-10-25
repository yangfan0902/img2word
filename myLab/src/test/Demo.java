package test;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import bean.Item;
import bean.User;
import dao.ItemDao;
import dao.UserDao;
import service.ItemService;
import service.ItemServiceImpl;

@Component 
public class Demo {
	
	@Autowired
	private ItemService itemService;
	
	private ApplicationContext context;
	@Test
	public void fun1(){
//		context=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
////		Item i=new Item();
////		i.setDate(new Date());
////		i.setDescription("做实验用");
////		i.setName("hu佳伟");
////		i.setNumber(5);
////		i.setPrice(25);
////		i.setProduct("无水乙醇");
////		i.setUser_id(1);
////		i.setId(1);
//		
////		
//		System.out.print(itemService);
//		List<Item> list1=itemService.queryItemList();
//		
		System.out.print(itemService);
	
	}
	
}
