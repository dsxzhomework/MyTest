package com.education.test.vo;

public class statisticsVo {
	private long StoreId;
	private String storeName;
	private int turnover;
	
	public long getStoreId() {
		return StoreId;
	}
	public void setStoreId(long storeId) {
		StoreId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
}
