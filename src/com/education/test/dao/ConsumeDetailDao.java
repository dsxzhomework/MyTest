package com.education.test.dao;

import java.util.List;

import com.education.test.model.ConsumeDetail;

public interface ConsumeDetailDao extends BaseDao<ConsumeDetail>{
	public List<ConsumeDetail> getAll();
}
