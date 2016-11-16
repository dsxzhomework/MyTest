package com.education.test.dao;

import java.util.List;

import com.education.test.model.CardAccount;

public interface CardAccountDao extends BaseDao<CardAccount>{
	public List<CardAccount> getAll();
}
