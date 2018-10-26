package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		
		Object name=session.getAttribute("name");
		if(name!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath() + "/user/toLogin.action");
		}
		return false;
	}
	
	
}
