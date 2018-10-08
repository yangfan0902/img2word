package web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.Cart;
import domain.User;
import service.impl.BusinessServiceImpl;

public class OrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		try{
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			BusinessService service=new BusinessServiceImpl();
			service.saveOrder(cart, user);
			request.setAttribute("message", "订单提交成功，请等待发货");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "失败！！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
