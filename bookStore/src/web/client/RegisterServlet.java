package web.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.User;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			User user=WebUtils.request2Bean(request, User.class);
			user.setId(UUID.randomUUID().toString());
			
			BusinessService service=new BusinessServiceImpl();
			service.addUser(user);
			request.setAttribute("message", "ע��ɹ�");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "ע��ʧ��");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
