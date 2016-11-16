package com.education.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waiterInfo")
public class waiterInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long waiterID;
	private int grade;	
	private String name;
	private String password;	
	private String phoneNum;
	private long storeID;
	private String storeName;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public long getWaiterID() {
		return waiterID;
	}
	public void setWaiterID(long waiterID) {
		this.waiterID = waiterID;
	}
	public long getStoreID() {
		return storeID;
	}
	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	
}
