package com.education.test.dao;

import java.util.List;

import com.education.test.model.memberInfo;

public interface memberInfoDao extends BaseDao<memberInfo> {
	public List<memberInfo> getAll();
}
