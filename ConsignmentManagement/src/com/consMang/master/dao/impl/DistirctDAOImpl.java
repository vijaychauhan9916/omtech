package com.consMang.master.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.consMang.common.dao.impl.GenericDAOImpl;
import com.consMang.master.dao.IDistrictDAO;
import com.consMang.master.model.DistrictModel;


@Repository(value="DistirctDAOImpl")
@Scope("request")
public class DistirctDAOImpl<E,PK> extends GenericDAOImpl<DistrictModel, Long> implements IDistrictDAO<DistrictModel,Long>{

	@Override
	public DistrictModel getDistirctById(Long pk) {
		return super.findOne(pk);
	}

}
