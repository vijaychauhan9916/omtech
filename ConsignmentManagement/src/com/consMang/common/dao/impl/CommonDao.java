package com.consMang.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;


public interface CommonDao<E,PK> {


	E loadObject(Class c,PK pk);
	E getObject(Class c,PK pk);
	E getObject(Class c,String id);
	void updateObject(E e);
	void saveObject(E e);
	Object saveCommonObject(E e);
	void removeObject(E e);
	List<Object> getList(DetachedCriteria dt);
	Query getQuery(String query)throws Exception;
	SQLQuery getSQLQuery(String query)throws Exception;
	void mergeObject(Object e);
	Session getCurrentSession();
}
