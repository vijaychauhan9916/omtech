package com.consMang.master.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.consMang.master.dao.IStateUtDAO;
import com.consMang.master.model.StateUtModel;
import com.consMang.master.service.IStateUtService;

@Service(value="stateUtService")
@Scope(value="request" ,proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation=Propagation.REQUIRED)

public class StateUtServiceImpl<E,PK> implements IStateUtService<StateUtModel, Long> {

	
	@Autowired
	IStateUtDAO<StateUtModel, Long> stateUtDAO;
	
	@Override
	public List<StateUtModel> getStateUtList() throws Exception {
		DetachedCriteria dt = DetachedCriteria.forClass(StateUtModel.class);
		return stateUtDAO.getStateUtList(dt);
	}

	@Override
	public StateUtModel getStateByID(Long pk) throws Exception {
		// TODO Auto-generated method stub
		return stateUtDAO.getStateById(pk);
	}


}
