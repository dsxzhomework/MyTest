package com.education.test.dao;

import java.util.List;

import com.education.test.model.StoreInfo;

public interface StoreInfoDao extends BaseDao<StoreInfo>{
		public  List<StoreInfo> getAll();
}
