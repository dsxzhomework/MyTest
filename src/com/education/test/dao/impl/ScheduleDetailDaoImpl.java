package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.education.test.dao.ScheduleDetailDao;
import com.education.test.model.ScheduleDetail;

@Repository
public class ScheduleDetailDaoImpl  extends BaseDaoImpl<ScheduleDetail> implements ScheduleDetailDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleDetail> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ScheduleDetail.class);
		return criteria.list();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ScheduleDetail> getBySchedule(Class t, String column, Object value){
    	Session session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(t);
    	criteria.add(Restrictions.eq(column, value));
		List<ScheduleDetail> list = criteria.list();
		if ((list.size()) == 0){
			return null;
		}else{
			return list;
		}		
	}
}
