package web.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.Order;
import service.impl.BusinessServiceImpl;

public class OrderServlet1 extends HttpServlet {
	BusinessService service=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		if("getAll".equals(method)){
			getAll(request,response);
		}
		if("find".equals(method)){
			find(request,response);
		}
		if("confirm".equals(method)){
			confirm(request,response);
		}
		
	}

	
	private void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			service.update(request.getParameter("id"),true);
			request.setAttribute("message", "订单已置为发货");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "设置订单发货失败！！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}


	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order=service.findOrder(request.getParameter("id"));
		request.setAttribute("order", order);
		request.getRequestDispatcher("/manager/orderdetail.jsp").forward(request,response);
	
	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean state=Boolean.parseBoolean(request.getParameter("state"));
		List orders=service.getOrderByState(state);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/manager/listorder.jsp").forward(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
