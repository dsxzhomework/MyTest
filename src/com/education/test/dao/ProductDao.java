package com.education.test.dao;

import java.util.List;

import com.education.test.model.product;

public interface ProductDao extends BaseDao<product>{
	public List<product> getAll();
	public List<product> getById(Class t, String productId, Object value);
}
