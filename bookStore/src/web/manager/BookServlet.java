package web.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.Book;
import service.impl.BusinessServiceImpl;
import utils.WebUtils;

public class BookServlet extends HttpServlet {
		
	private BusinessService service=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		if("forAddUI".equals(method)){
			
			forAddUI(request,response);
		}
		if("add".equals(method)){
			add(request,response);
		}
		if("list".equals(method)){
			list(request,response);
		}
	}

	
	private void list(HttpServletRequest request, HttpServletResponse response) {
		try{
			List books=service.getAllBook();
			request.setAttribute("books", books);
			request.getRequestDispatcher("/manager/listbook.jsp").forward(request, response);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Book b=WebUtils.upload(request, this.getServletContext().getRealPath("/images"));
			service.addBook(b);
			request.setAttribute("message", "��ӳɹ�");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "���ʧ��");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}


	private void forAddUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List categories=service.getAllCategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/manager/addbook.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
