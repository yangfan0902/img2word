package junit.test;

import service.impl.BusinessServiceImpl;

public class Test {
	public static void main(String[] args){
		BusinessServiceImpl service=new BusinessServiceImpl();
		System.out.print(service.findCategory("1").getDescription());
	}
	
}
