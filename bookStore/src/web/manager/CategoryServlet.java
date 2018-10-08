package web.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.Category;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class CategoryServlet extends HttpServlet {
	
	private BusinessService service=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}
		if("getAll".equals(method)){
			getAll(request,response);
		}
	}

	
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List list=service.getAllCategory();
		request.setAttribute("categories", list);
		request.getRequestDispatcher("/manager/listcategory.jsp").forward(request, response);
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Category c=WebUtils.request2Bean(request, Category.class);
			c.setId(UUID.randomUUID().toString());
			service.addCategory(c);
			request.setAttribute("message", "��ӳɹ�");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "���ʧ��");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
