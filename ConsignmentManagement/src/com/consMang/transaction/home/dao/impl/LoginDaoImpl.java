package com.consMang.transaction.home.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.consMang.common.dao.impl.GenericDAOImpl;
import com.consMang.master.model.UserModel;
import com.consMang.transaction.home.dao.LoginDao;



@Repository(value = "LoginDAO")
public class LoginDaoImpl extends GenericDAOImpl<UserModel, Long> implements LoginDao {

	
	
	
	
	public UserModel verifyUser(String loginId,String password){
		UserModel user=null;
		DetachedCriteria dt= DetachedCriteria.forClass(UserModel.class);
		dt.add(Restrictions.eq("loginId", loginId));
		dt.add(Restrictions.eq("password", password));
		dt.add(Restrictions.eq("status", "ACTIVE"));
		
		List<UserModel> userList=getList(dt);
		if(userList!=null && userList.size()>0){
			user=userList.get(0);
		}
		return user;
	}
	
	public UserModel getUserById(Long userId){
		
		return super.getEntity(userId);
	}
	
	public List<UserModel> getUserList(DetachedCriteria dt){
		return super.getList(dt);
	}

	@Override
	public UserModel updateUser(UserModel user) throws Exception{
		
			super.updateEntity(user);
	
		 
		 return user;
		
	}
}
