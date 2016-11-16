package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.StoreInfoDao;
import com.education.test.model.StoreInfo;
@Repository
public class StoreInfoDaoImpl extends BaseDaoImpl<StoreInfo> implements StoreInfoDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreInfo> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StoreInfo.class);
		return criteria.list();
	}
}
