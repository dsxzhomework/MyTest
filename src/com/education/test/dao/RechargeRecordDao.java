package com.education.test.dao;

import java.util.List;

import com.education.test.model.RechargeRecord;

public interface RechargeRecordDao extends BaseDao<RechargeRecord>{
	public List<RechargeRecord> getAll();
}
