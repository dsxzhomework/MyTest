package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.education.test.dao.ScheduleDao;
import com.education.test.model.Schedule;

@Repository
public class ScheduleDaoImpl  extends BaseDaoImpl<Schedule> implements ScheduleDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Schedule.class);
		return criteria.list();
	}
}
