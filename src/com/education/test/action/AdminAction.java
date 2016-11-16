package com.education.test.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.education.test.model.StoreInfo;
import com.education.test.model.waiterInfo;
import com.education.test.service.AdminService;

@Repository
public class AdminAction {
	private static final String SUCCESS = "success";
	//以下是依赖注入
	@Autowired
	private AdminService adminService;
	
	private List<StoreInfo> storeInfoList;
	private List<waiterInfo> waiterInfoList;
	private long storeId;
	private String name;
	private String phoneNum;
	private String address;
	private String waiterName;
	private String waiterPhoneNum;
	private String waiterPassword;
	private int waiterGrade;
	private String storeID;
	private long waiterID;
	private String storeName;
	
	//管理员登录
	public String adminLogin(){
		return SUCCESS;
	}	

/*店铺模块 */
	//显示店铺信息
	public String showStoreInfo(){
		setStoreInfoList(adminService.getStoreList());
		return SUCCESS;		
	}
	//删除店铺信息
	public String delStoreInfo(){
		adminService.delStoreInfo(storeId);
		//考虑对店员信息的处理
		return null;		
	}
	//增加店铺信息
	public String addStoreInfo(){
		adminService.addStoreInfo(name, phoneNum, address);		
		return null;		
	}
	public String StoreAdd(){
		return SUCCESS;
	}
	//选择修改店铺
	public String chooseUpdateInfo(){
		System.out.println(name);
		System.out.println(address);
		System.out.println(phoneNum);
		return null;
	}
	public String StoreUpdate(){
		
		return SUCCESS; 
	}
	//修改店铺信息
	public String updateStoreInfo(){
		adminService.updateStoreInfo(storeId, name, phoneNum, address);
		return null;
	}
	
	
/*店员模块 */	
	//显示店员信息（全部）
	public String showWaiterInfo(){
		setWaiterInfoList(adminService.getList());
		return SUCCESS;
	}	
	//显示添加店员界面
	public String showAddWaiter(){
		setStoreInfoList(adminService.getStoreList());
		return SUCCESS;		           
	}
	//添加店员操作
	public String addWaiterInfo(){	
		System.out.println(storeId);
		adminService.addWaiterInfo(waiterName, waiterPassword, waiterPhoneNum, waiterGrade,storeId,storeName);
		return null;                       
	}
	//删除店员操作
	public String delWaiterInfo(){
		adminService.delWaiterInfo(waiterID);
		return null;
	}
	//显示修改店员信息界面
	public String showWaiterUpd(){
		return null;		
	}
	public String WaiterUpdate(){
		return SUCCESS;
	}
	//修改店员信息
	public String updateWaiterInfo(){
		//System.out.println(waiterID+waiterPassword+waiterPhoneNum);		
		adminService.updateWaiterInfo(waiterID, waiterPassword, waiterPhoneNum);
		return null;
	}
	
	
	
	
	public List<StoreInfo> getStoreInfoList() {
		return storeInfoList;
	}

	public void setStoreInfoList(List<StoreInfo> storeInfoList) {
		this.storeInfoList = storeInfoList;
	}
	public List<waiterInfo> getWaiterInfoList() {
		return waiterInfoList;
	}
	public void setWaiterInfoList(List<waiterInfo> waiterInfoList) {
		this.waiterInfoList = waiterInfoList;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWaiterName() {
		return waiterName;
	}

	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	public String getWaiterPhoneNum() {
		return waiterPhoneNum;
	}

	public void setWaiterPhoneNum(String waiterPhoneNum) {
		this.waiterPhoneNum = waiterPhoneNum;
	}

	public String getWaiterPassword() {
		return waiterPassword;
	}

	public void setWaiterPassword(String waiterPassword) {
		this.waiterPassword = waiterPassword;
	}

	public int getWaiterGrade() {
		return waiterGrade;
	}

	public void setWaiterGrade(int waiterGrade) {
		this.waiterGrade = waiterGrade;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public long getWaiterID() {
		return waiterID;
	}

	public void setWaiterID(long waiterID) {
		this.waiterID = waiterID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
