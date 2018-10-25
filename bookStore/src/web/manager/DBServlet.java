package web.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessService;
import domain.DBBack;
import service.impl.BusinessServiceImpl;

public class DBServlet extends HttpServlet {
	BusinessService service=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method=request.getParameter("method");
		if("backup".equals(method)){
			backup(request,response);
		}
		if("list".equals(method)){
			list(request,response);
		}
		if("restore".equals(method)){
			restore(request,response);
		}
		
	}

	
	private void restore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id=request.getParameter("id");
			DBBack back=service.findBack(id);
			String filename=back.getFilename();
			String command="cmd /c mysql -uroot -p111111 bookstore<"+filename;
			Runtime.getRuntime().exec(command);
			request.setAttribute("message", "恢复成功");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "恢复失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List backs=service.getAllBack();
		request.setAttribute("backs", backs);
		request.getRequestDispatcher("/manager/dbbacklist.jsp").forward(request, response);
		
	}

	//备份当前数据库
	private void backup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String backpath=this.getServletContext().getRealPath("/backup");
			String filename=System.currentTimeMillis()+".sql";
			//1.备份操作
			String command="cmd /c mysqldump -uroot -p111111 bookStore>"+backpath+"\\"+filename;
			Runtime.getRuntime().exec(command);
			
			//2.把备份信息封装到一个javabean中，并把Javabean保存到数据库
			DBBack back=new DBBack();
			back.setBacktime(new Date());
			back.setDescription(request.getParameter("description"));
			back.setFilename(backpath+"\\"+filename);
			back.setId(UUID.randomUUID().toString());
			service.addDBBack(back);
			request.setAttribute("message", "备份成功");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "备份失败");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
