package com.consMang.interceptor;


import com.consMang.common.util.CommonConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor  extends HandlerInterceptorAdapter{
	

	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession=request.getSession();
		String role=(String)httpSession.getAttribute(CommonConstants.SES_USER_ROLE);
		try{
		if(role!=null && role.equals(CommonConstants.ADMIN_USER)){
			return true;
		}
		else{
			response.sendRedirect(request.getContextPath()+"/home");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
		}
}
