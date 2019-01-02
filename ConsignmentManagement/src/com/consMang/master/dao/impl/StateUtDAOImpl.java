package com.consMang.master.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.consMang.common.dao.impl.GenericDAOImpl;
import com.consMang.master.dao.IStateUtDAO;
import com.consMang.master.model.StateUtModel;

@Repository(value="stateUtDAO")

public class StateUtDAOImpl<E, PK> extends GenericDAOImpl<StateUtModel, Long> implements IStateUtDAO<StateUtModel, Long>{

	@Override
	public List<StateUtModel> getStateUtList(DetachedCriteria dt)
			throws Exception {
		return super.getList(dt);
	}

	@Override
	public StateUtModel getStateById(Long pk) throws Exception {
		// TODO Auto-generated method stub
		return super.findOne(pk);
	}

}
