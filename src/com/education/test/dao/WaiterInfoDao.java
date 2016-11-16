package com.education.test.dao;

import java.util.List;

import com.education.test.model.waiterInfo;

public interface WaiterInfoDao extends BaseDao<waiterInfo>{
	public List<waiterInfo> getAll();
}
