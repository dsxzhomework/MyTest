package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.ConsumeDetailDao;
import com.education.test.model.ConsumeDetail;
@Repository
public class ConsumeDetailDaoImpl extends BaseDaoImpl<ConsumeDetail> implements ConsumeDetailDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumeDetail> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ConsumeDetail.class);
		return criteria.list();	
}
}
