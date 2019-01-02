package com.consMang.transaction.home.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.consMang.common.dao.impl.CommonDao;
import com.consMang.master.model.UserModel;
import com.consMang.transaction.home.dao.LoginDao;
import com.consMang.transaction.home.service.LoginService;


@Service(value="loginService")
@Scope("request")
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
	
	@Autowired
	LoginDao loginDAO;
	
	@Autowired
	CommonDao<Object, Long> commonDao;
	
	
	
	
	
	
	public UserModel login(String loginId,String password){
		
		UserModel user=	loginDAO.verifyUser(loginId, password);
		
		return user;
	}


	@Override
	public UserModel getUserById(Long userId) {
		// TODO Auto-generated method stub
		return loginDAO.getUserById(userId);
	}
	
public List<UserModel> getUserListByRole(String role){
		
		DetachedCriteria dt=DetachedCriteria.forClass(UserModel.class);
		
		dt.add(Restrictions.eq("userType", role));
		
		return loginDAO.getUserList(dt);
		
	}


@Override
public UserModel updatePassword(String loginId, String oldpassword,String newpass) throws Exception {
	UserModel user=login(loginId, oldpassword);
	if(user!=null){
		user.setPassword(newpass);
		loginDAO.updateUser(user);
	}
	return user;
}


@Override
public boolean retrievePassword(String uType, String regNo, String panNo) throws Exception {
	// TODO Auto-generated method stub
	return false;
}

}
