package web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.User;
import service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		BusinessService service=new BusinessServiceImpl();
		
		User user=service.findUser(username, password);
		if(user==null){
			request.setAttribute("message", "�û������������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
