package com.consMang.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;


@Repository
public class CommonDaoImpl<E,PK> extends GenericDAOImpl<Object, Long> implements CommonDao<Object,Long>{

	

	@Override
	public Object loadObject(Class c, Long pk) {
		// TODO Auto-generated method stub

		return getCurrentSession().load(c, pk);
	}

	@Override
	public Object getObject(Class c, Long pk) {

		// TODO Auto-generated method stub
		 return getCurrentSession().get(c, pk);
	}
	@Override
	public Object getObject(Class c, String id) {

		// TODO Auto-generated method stub
		 return getCurrentSession().get(c, id);
	}
	@Override
	public void updateObject(Object e) {
		super.updateOrUpdateEntity(e);
		
	}

	@Override
	public void mergeObject(Object e) {
		super.mergeEntity(e);
		
	}

	@Override
	public void saveObject(Object e) {
		super.createEntity(e);
		
	}
	
	@Override
	public void removeObject(Object e) {
		super.delete(e);
		
	}

	
	@Override
	public List<Object> getList(DetachedCriteria dt) {
		
		return super.getList(dt);
	}
	

	@Override
	public Query getQuery(String query)throws Exception {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery(query);
	}

	@Override
	public Object saveCommonObject(Object e) {
		// TODO Auto-generated method stub
		return super.createEntity(e);
	}

	@Override
	public SQLQuery getSQLQuery(String query)throws Exception {
		// TODO Auto-generated method stub
		return getCurrentSession().createSQLQuery(query);
	}
}
