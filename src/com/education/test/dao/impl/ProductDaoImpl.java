package com.education.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.education.test.dao.ProductDao;
import com.education.test.model.ScheduleDetail;
import com.education.test.model.product;
@Repository
public class ProductDaoImpl extends BaseDaoImpl<product> implements ProductDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<product> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(product.class);
		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<product> getById(Class t, String productId, Object value){
    	Session session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(t);
    	criteria.add(Restrictions.eq(productId, value));
		List<product> list = criteria.list();	
		return list;
	}

}
