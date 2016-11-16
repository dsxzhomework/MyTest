package com.education.test.service;

import java.util.List;

import com.education.test.model.StoreInfo;
import com.education.test.model.waiterInfo;

public interface AdminService {
	public List<waiterInfo> getList() ;
	public List<StoreInfo> getStoreList();
	public void delStoreInfo(long storeId);
	public void addStoreInfo(String name,String phoneNum,String address);
	public void updateStoreInfo(long storeId,String name,String phoneNum,String address);
	public void addWaiterInfo(String name,String password,String phoneNum,int grade,long storeID,String storeName);
	public void delWaiterInfo(long waiterID);
	public void updateWaiterInfo(long waiterID,String password,String phoneNum);
	public StoreInfo getStoreInfo(long storeId);
}