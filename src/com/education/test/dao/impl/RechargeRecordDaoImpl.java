package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.RechargeRecordDao;
import com.education.test.model.RechargeRecord;

@Repository
public class RechargeRecordDaoImpl extends BaseDaoImpl<RechargeRecord> implements RechargeRecordDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<RechargeRecord> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RechargeRecord.class);
		return criteria.list();
	}
}
