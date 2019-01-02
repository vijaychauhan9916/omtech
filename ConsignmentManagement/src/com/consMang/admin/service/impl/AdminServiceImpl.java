package com.consMang.admin.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consMang.admin.service.AdminService;
import com.consMang.common.dao.impl.CommonDao;
import com.consMang.common.util.CommonConstants;
import com.consMang.master.model.EnquiryModel;
import com.consMang.master.model.UserModel;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService {
	private static final Logger LOGGER = Logger.getLogger(AdminServiceImpl.class);
	@Autowired
	CommonDao<Object, Long> dao;
	
	
	@Override
	public List<Object> getUserList(String status) {
		List<Object> userList = null;
		DetachedCriteria dt = DetachedCriteria.forClass(UserModel.class);
		LOGGER.debug("----------------------->>>>STARTED>>>>>>> STATUS :::-->>  "+ status);
		dt.add(Restrictions.eq("status", status));
		dt.addOrder(Order.asc("userType"));
		userList = dao.getList(dt);

		return userList;
	}

	@Override
	public void saveUser(UserModel user) {
	user.setCreatedOn(Calendar.getInstance());
	user.setStatus(CommonConstants.ACTIVE);
	user.setPassword(generatePassword());
	dao.saveObject(user);
	
	EnquiryModel em=new EnquiryModel();
	em.setEmailId(user.getEmailId());
	em.setSubject("RERA User Credential");
	StringBuffer sb=new StringBuffer();
	sb.append("Dear ").append(user.getUserName()).append(",\n");
	sb.append("Your user account has been successfuly created in rera portal.");
	sb.append("Role : ").append(user.getUserType()).append("\n");
	sb.append("Login ID : ").append(user.getLoginId()).append("\n");
	sb.append("Password : ").append(user.getPassword()).append("\n \n\n\n");
	sb.append("Regards : \n ").append("Portal Admin");
	em.setEnquiryText(sb.toString());
//	mailService.sendMail(em);
	}

	@Override
	public void editUser(UserModel user) {
		dao.updateObject(user);
		
	}

	@Override
	public UserModel getUserById(Long id) {
		
		return (UserModel)dao.getObject(UserModel.class, id);
	}
	
	@Override
	public UserModel getUserByLoginId(String id) {
		UserModel user=null;
		DetachedCriteria dt=DetachedCriteria.forClass(UserModel.class);
		dt.add(Restrictions.eq("loginId",id));
		
		List<Object> lst=dao.getList(dt);
		if(lst!=null && lst.size()>0 && lst.get(0)!=null){
			user=(UserModel)lst.get(0);
		}
		return null;
	}

	private static String generatePassword(){
		int digit=0;
		Random rn=new Random();
		StringBuffer sb=new StringBuffer();
		while(digit<8){
			sb.append(chars.charAt(rn.nextInt(36))); 
			digit++;
		}
		return sb.toString();
	}

	private static String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public static void main(String[] args) {
		System.out.println(generatePassword());
	}

	
	@Override
	public UserModel getUserByDesig(String id) {
		LOGGER.debug("started::getUserByDesig()::");
		UserModel user=null;
		DetachedCriteria dt=DetachedCriteria.forClass(UserModel.class);
		dt.add(Restrictions.eq("designation",id));
		LOGGER.debug("started::getUserByDesig():id-----:"+id);
		
		List<Object> lst=dao.getList(dt);
		if(lst!=null && lst.size()>0 && lst.get(0)!=null){
			user=(UserModel)lst.get(0);
			LOGGER.debug("started::getUserByDesig():user-----:"+user);
		}
		LOGGER.debug("ended::getUserByDesig()::");
		return user;
	}
}

