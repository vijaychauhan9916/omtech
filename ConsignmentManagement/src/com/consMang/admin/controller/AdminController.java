package com.consMang.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.consMang.admin.service.AdminService;
import com.consMang.common.dao.impl.CommonDao;
import com.consMang.master.dao.IDistrictDAO;
import com.consMang.master.model.DistrictModel;
import com.consMang.master.model.StateUtModel;
import com.consMang.master.model.UserModel;
import com.consMang.master.model.UserProfileModel;
import com.consMang.master.service.IStateUtService;


@Controller(value="AdminController")
@Scope("request")
public class AdminController {

	private static final Logger LOGGER = Logger.getLogger(AdminController.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	AdminService adminService;
	
	
	@Autowired
	CommonDao<Object, Long> commonDao;
	
	@Autowired
	IStateUtService<StateUtModel, Long> stateUtService;

	@Autowired
	IDistrictDAO<DistrictModel, Long> districtDAO;
	
	@RequestMapping(value="admin/dashboard")
	public ModelAndView dashboard(HttpServletRequest request){
		
		return new ModelAndView("admin.dashbord");
		
		
	}
	
	
	@RequestMapping(value="admin/manageUsers")
	public ModelAndView manageUsers(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("admin.manageUsersList");
		List<Object> users=adminService.getUserList(request.getParameter("ststus"));
		mv.addObject("userList", users);
		if(users!=null)
		mv.addObject("userCount", users.size());
		
		return mv;
		
		
	}
	
	@RequestMapping(value="admin/newUserForm")
	public ModelAndView newUserForms(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("admin.newUserForm");
		mv.addObject("userModel", new UserModel());
		return mv;
		
		
	}
	
	@RequestMapping(value="admin/createProfile")
	public ModelAndView createProfile(){
		ModelAndView mv= new ModelAndView("admin.createNewProfile");

	try{
		mv.addObject("stateUtList", stateUtService.getStateUtList());
		mv.addObject("userProfileModel", new UserProfileModel());
	} catch (Exception ex) {
		ex.printStackTrace();
		LOGGER.debug("Exception : bankACChangeApp");
		LOGGER.debug("Exception : " + ex.getMessage());
	}
		return mv;
	}
	
}
