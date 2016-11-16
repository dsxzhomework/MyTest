package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.CardAccountDao;
import com.education.test.model.CardAccount;
import com.education.test.model.memberInfo;

@Repository
public class CardAccountDaoImpl extends BaseDaoImpl<CardAccount> implements CardAccountDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<CardAccount> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(memberInfo.class);
		return criteria.list();
	}

}
