package com.education.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.test.dao.StoreInfoDao;
import com.education.test.dao.WaiterInfoDao;
import com.education.test.model.StoreInfo;
import com.education.test.model.waiterInfo;
import com.education.test.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private WaiterInfoDao waiterInfoDao;
	@Autowired
	private StoreInfoDao storeInfoDao;
	
	@Override
	/*店员相关*/
	//获取waiterinfo表里全部信息
	public List<waiterInfo> getList() {
		// TODO Auto-generated method stub
		List<waiterInfo> mylist = waiterInfoDao.getAll();
		return mylist;
	}
	//添加waiterinfo信息
	public void addWaiterInfo(String name,String password,String phoneNum,int grade,long storeID,String storeName){
		waiterInfo info=new waiterInfo();
		info.setGrade(grade);
		info.setName(name);
		info.setPassword(password);
		info.setPhoneNum(phoneNum);
		info.setStoreID(storeID);
		info.setStoreName(storeName);
		waiterInfoDao.add(info);
	}
	//删除waiterinfo信息
	public void delWaiterInfo(long waiterID){
		waiterInfo info=new waiterInfo();
		info=waiterInfoDao.getById(waiterInfo.class, waiterID);
		waiterInfoDao.delete(info);
		
	}
	//修改店员信息
	public void updateWaiterInfo(long waiterID,String password,String phoneNum){
		waiterInfo info=new waiterInfo();
		info=waiterInfoDao.getById(waiterInfo.class, waiterID);
		info.setPassword(password);
		info.setPhoneNum(phoneNum);
		waiterInfoDao.update(info);
	}
	
	/* 店面相关 */	
	//获取storeinfo表里全部信息
	public List<StoreInfo> getStoreList(){
		// TODO Auto-generated method stub
		List<StoreInfo> mylist = storeInfoDao.getAll();
		return mylist;
	}
	//删除storeinfo信息
	public void delStoreInfo(long storeId){
		StoreInfo info=new StoreInfo();
		info=storeInfoDao.getById(StoreInfo.class, storeId);
		storeInfoDao.delete(info);
		
	}
	//添加storeinfo信息
	public void addStoreInfo(String name,String phoneNum,String address){
		StoreInfo info=new StoreInfo();	
		info.setName(name);
		info.setPhoneNum(phoneNum);
		info.setAddress(address);
		storeInfoDao.add(info);
	}
	//更新storeinfo信息
	public void updateStoreInfo(long storeId,String name,String phoneNum,String address){
		StoreInfo info=new StoreInfo();
		info.setStoreId(storeId);
		info.setName(name);
		info.setPhoneNum(phoneNum);
		info.setAddress(address);
		storeInfoDao.update(info);	
	}
	//获取storeinfo信息
	public StoreInfo getStoreInfo(long storeId){
		StoreInfo info=new StoreInfo();
		info=storeInfoDao.getById(StoreInfo.class, storeId);
		return info;
	}
	
}
