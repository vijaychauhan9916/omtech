package com.consMang.transaction.home.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.consMang.common.util.Base64Decoder;
import com.consMang.common.util.CommonConstants;
import com.consMang.master.model.UserModel;
import com.consMang.transaction.home.service.LoginService;


@Controller("LoginController")
@Scope("request")
public class LoginController {
	@Autowired
	LoginService loginService;

	
	@RequestMapping(value="loginPage")
	public ModelAndView loginPage(){
		return new ModelAndView("loginPage");
	}
	
	@RequestMapping(value="authorityLoginPage")
	public ModelAndView authorityLoginPage(){
		return new ModelAndView("authorityLoginPage");
	} 
	
	
	@RequestMapping(value = "userLogin")
	public ModelAndView userLogin(HttpServletRequest request,
			@RequestParam(value = "loginId", required = true) String logId,
			@RequestParam(value = "password", required = true) String pass) {
		System.out.println("User::::---->" + logId + ",Password::::---->" + pass);
		logId = Base64Decoder.decode(logId);
		pass = Base64Decoder.decode(pass);
		System.out.println("User::::---->" + logId + ",Password::::---->" + pass);
		UserModel user = loginService.login(logId, pass);
		if (user != null && user.getUserType() != null 
				&& (user.getUserType().equals(CommonConstants.ADMIN_USER))
				) {
			try {
				return new ModelAndView("redirect:" + buildNewSession(request, user));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			ModelAndView mv = new ModelAndView("loginPage");
			mv.addObject("ERROR_MSG", "Something went wrong. Try again.");
			return mv;
		} else {

			ModelAndView mv = new ModelAndView("loginPage");
			mv.addObject("ERROR_MSG", "Something went wrong. Try again.");
			return mv;
		}

	}

	
	private String buildNewSession(HttpServletRequest request,UserModel user){
		HttpSession session=request.getSession(true);
		session.invalidate();
		session=request.getSession(true);
		String path="loginPage";
		String type=user.getUserType();
		session.setAttribute(CommonConstants.SES_USER_ATTR, user);
		session.setAttribute(CommonConstants.SES_USER_ROLE,type);
	
		
		if(type.equals(CommonConstants.ADMIN_USER)){
			path="admin/dashboard";
		}
		return path;
	}
	
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse res){
		HttpSession session=request.getSession(true);
		session.removeAttribute(CommonConstants.SES_USER_ATTR);
		session.removeAttribute(CommonConstants.SES_USER_ROLE);
		System.out.println(	"Before :: "+session.getId());
		session.invalidate();
	    
		 session=request.getSession(true);
	System.out.println(	"After    "+session.getId());
	
	return new ModelAndView("redirect:/home");
	}
	
	
	
	
	
	@RequestMapping(value="forgetPasswordBForm")
    public ModelAndView forgetPasswordUserForm(){
  	  
  	  return new ModelAndView("forgetPasswordUserForm");
	}
	
	@RequestMapping(value="retrievePassword")
     public ModelAndView retrievePasswordUser(@RequestParam("uType") String uType,@RequestParam("regNo") String regNo,@RequestParam("panNo") String panNo){
		ModelAndView mv= new ModelAndView("forgetPasswordUserForm");
		try{
		if(	loginService.retrievePassword(uType, regNo, panNo)){
			mv.addObject("ERROR_MSG", "Login credential have been sent on registered email address.");
		}else{
			mv.addObject("ERROR_MSG", "User not found.");
		}
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			mv.addObject("ERROR_MSG", "Something went wrong. Please try later.");
		}
		
	  return mv;
	}
	
	
	
	
	
	@RequestMapping(value="changePassword",method=RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request, @RequestParam(value = "password", required = true) String oldPassword,
			
			@RequestParam(value = "newpassword", required = true) String newpassword) throws Exception{
		
		newpassword=Base64Decoder.decode(newpassword);
		oldPassword=Base64Decoder.decode(oldPassword);
		ModelAndView mv=null;
		UserModel loggedUser=(UserModel)httpSession.getAttribute(CommonConstants.SES_USER_ATTR);
		
		UserModel user=	loginService.updatePassword(loggedUser.getLoginId(), oldPassword, newpassword);
		if(user!=null){
			
			try{
			return	new ModelAndView("redirect:"+buildNewSession(request, user));
				
				}catch(Exception ex){
					ex.printStackTrace();
				}
	}else{
		String type=loggedUser.getUserType();
		String path="";
		
		if(type.equals(CommonConstants.ADMIN_USER)){
			path="admin/dashboard";
		}
		return	new ModelAndView("redirect:"+path);
		
	}
		return mv;
	
		
	}
	
	
	
	

private static String getRandomId(){
	String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 26) { // length of the random string.
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;
}
	@Autowired
	private HttpSession httpSession;
	
	
	
}
	
