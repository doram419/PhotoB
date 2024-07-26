package himedia.photobook.interceptors;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import himedia.photobook.services.users.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception{
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
		UsersService userService = context.getBean(UsersService.class);
		
		if(userService.isAuthenticated(req)) {
			return true;
		}else {
			resp.sendRedirect(req.getContextPath()+"/users/login");
			return false;
		}
	}
}
