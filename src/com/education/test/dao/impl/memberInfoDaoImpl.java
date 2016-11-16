package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.memberInfoDao;
import com.education.test.model.memberInfo;
@Repository
public class memberInfoDaoImpl extends BaseDaoImpl<memberInfo> implements memberInfoDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<memberInfo> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(memberInfo.class);
		return criteria.list();
	}
}
