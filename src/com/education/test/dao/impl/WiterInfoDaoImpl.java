package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.WaiterInfoDao;
import com.education.test.model.waiterInfo;
@Repository
public class WiterInfoDaoImpl extends BaseDaoImpl<waiterInfo> implements WaiterInfoDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<waiterInfo> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(waiterInfo.class);
		return criteria.list();
	
}
}
