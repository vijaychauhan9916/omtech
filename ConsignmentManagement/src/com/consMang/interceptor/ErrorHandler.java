package com.consMang.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class ErrorHandler implements Filter {
ServletContext context;
private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class);
	@Override
	public void destroy() {
//		ReraJobs.shutdown();
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		try{
			/*if(ProjectCertificateUtil.getContext()==null){
		        ProjectCertificateUtil.setContext(arg0.getServletContext());
		        ProjectCertificateUtil.setContext1(arg0.getServletContext());
		        ProjectAlterationCertificate.setContext(arg0.getServletContext());
		        ProjectRejectionCertificate.setContext(arg0.getServletContext());
		        ProjectRejectionCertificate.setContext1(arg0.getServletContext());
			}*/
			arg2.doFilter(arg0, arg1);
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("ErrorHandlerErrorHandlerErrorHandlerErrorHandler   :::   "+e);
			context.getRequestDispatcher("/errorPage.jsp").forward(arg0, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		context=arg0.getServletContext();
	}

}
