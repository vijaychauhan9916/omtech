package com.consMang.admin.service;

import java.util.List;

import com.consMang.master.model.UserModel;


public interface AdminService {

	List<Object> getUserList(String status);
	void saveUser(UserModel user);
	void editUser(UserModel user);
	UserModel getUserById(Long id);
	UserModel getUserByLoginId(String id);
	UserModel getUserByDesig(String id);
	
	
}
