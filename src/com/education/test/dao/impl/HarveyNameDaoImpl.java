package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.education.test.dao.HarveyNameDao;
import com.education.test.model.HarveyName;
@Repository
@Transactional
public class HarveyNameDaoImpl extends BaseDaoImpl<HarveyName> implements HarveyNameDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<HarveyName> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(HarveyName.class);
		return criteria.list();
	}

}
