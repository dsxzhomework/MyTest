package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.ConsumeRecordDao;
import com.education.test.model.ConsumeRecord;
@Repository
public class ConsumeRecordDaoImpl extends BaseDaoImpl<ConsumeRecord> implements ConsumeRecordDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<ConsumeRecord> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ConsumeRecord.class);
		return criteria.list();
	
}
}
