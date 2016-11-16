package com.education.test.dao;

import java.util.List;

import com.education.test.model.ConsumeRecord;

public interface ConsumeRecordDao extends BaseDao<ConsumeRecord>{
	public List<ConsumeRecord> getAll();
}
