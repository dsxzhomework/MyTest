package com.education.test.vo;
/*
* @author:soleil
* @version 2016年6月20日 下午8:51:58
* 解释：
*/
public class showProductNameVo {
	private long detailId;
	private String date;
	private String name;
	private long quantity;
	
	public long getDetailId() {
		return detailId;
	}
	public void setDetailId(long detailId) {
		this.detailId = detailId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
