package com.education.test.dao;

import java.util.List;

import com.education.test.model.HarveyName;

public interface HarveyNameDao extends BaseDao<HarveyName>{
	public List<HarveyName> getAll();
	
}