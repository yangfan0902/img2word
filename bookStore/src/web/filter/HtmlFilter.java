package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class HtmlFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(new MyRequest(request),response);
	}
	
	class MyRequest extends HttpServletRequestWrapper{
		
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			String value=request.getParameter(name);
			return filter(value);
		}
		 public String filter(String message) {

		        if (message == null)
		            return null;

		        char content[] = new char[message.length()];
		        message.getChars(0, message.length(), content, 0);
		        StringBuilder result = new StringBuilder(content.length + 50);
		        for (int i = 0; i < content.length; i++) {
		            switch (content[i]) {
		            case '<':
		                result.append("&lt;");
		                break;
		            case '>':
		                result.append("&gt;");
		                break;
		            case '&':
		                result.append("&amp;");
		                break;
		            case '"':
		                result.append("&quot;");
		                break;
		            default:
		                result.append(content[i]);
		            }
		        }
		        return result.toString();
		    }
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
