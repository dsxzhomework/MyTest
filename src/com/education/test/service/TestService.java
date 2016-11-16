package com.education.test.service;

import java.util.List;

import com.education.test.model.HarveyName;

public interface TestService {
	/**
	 * 获取HarveyName的list，如果为空，则先存储，再读取
	 * @return
	 */
	public List<HarveyName> getList();
}
