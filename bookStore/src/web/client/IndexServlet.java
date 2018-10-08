package web.client;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.PageBean;
import domain.QueryInfo;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class IndexServlet extends HttpServlet {
	private BusinessService service=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QueryInfo info=WebUtils.request2Bean(request, QueryInfo.class);
		String category_id=request.getParameter("category_id");
		if(category_id!=null&&category_id.trim()!=""){
			
			info.setQueryName("category_id");
			info.setQueryValue(category_id);
		}
		List categories= service.getAllCategory();
		PageBean pagebean=service.bookPageQuery(info);
		request.setAttribute("categories", categories);
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
