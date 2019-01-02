package com.consMang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import vel.wf.engine.util.ParseWFRequest;

import com.consMang.common.dao.impl.CommonDao;
import com.consMang.common.security.ReraSecurity;
import com.consMang.common.util.CommonConstants;
import com.consMang.common.util.HibernateSession;

public class SessionInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	private CommonDao<Object, Long> dao;
	
	/*@Autowired
	ReraJobs jobs;*/

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String referer=request.getHeader("Referer");
		if(referer!=null && referer.toLowerCase().contains("google")){
			
			response.sendRedirect(request.getContextPath()+ "/home");
			return false;
		}
		
		try {
			if (!ReraSecurity.checkScript(request)) {
				response.sendRedirect(request.getContextPath()+ "/errorPage.jsp");
				return false;
			}
			if (!ReraSecurity.isValidRequest(request)) {
				response.sendRedirect(request.getContextPath()+ "/errorPage.jsp");
				return false;
			}

			ParseWFRequest parser=new ParseWFRequest(request);
			parser.parse(this.dao.getCurrentSession());
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private boolean lockUser(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = true;
		try {
			
			
			
			HttpSession ses = request.getSession(true);
			if (ses.getAttribute(CommonConstants.SES_USER_ATTR) != null
					|| (ses.getAttribute("USER_LOCK") != null 
					&& ses.getAttribute("USER_LOCK").equals("YES"))) {
				return false;
			} else if (request.getParameter("loginIdfld") != null
					&& request.getParameter("passwordfld") != null
					&& request.getParameter("loginIdfld").equals("reraauthuser")
					&& request.getParameter("passwordfld").equals(
							"Welcome@558#")) {
				ses.setAttribute("USER_LOCK", "YES");
				response.sendRedirect("home");
				return true;
			} else {
				String str = request.getRequestURI();
				if (str.contains("home")) {
					return false;
				} else {
					response.sendRedirect("home");
					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		}

		return flag;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		HibernateSession.closeSession();
		}

}
