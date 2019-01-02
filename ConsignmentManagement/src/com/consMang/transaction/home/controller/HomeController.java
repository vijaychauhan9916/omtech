package com.consMang.transaction.home.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.consMang.common.dao.impl.CommonDao;




@Controller("HomeController")
@Scope("request")
public class HomeController {
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	@Autowired
	CommonDao<Object, Long> commonDao;
	
	
	@RequestMapping(value="home")
	public ModelAndView home(){
		
		ModelAndView mv=new ModelAndView("home");
		
		return mv;
	}
	
		
	
}
