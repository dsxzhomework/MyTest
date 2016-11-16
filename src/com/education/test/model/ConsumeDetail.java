package com.education.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ConsumeDetail")
public class ConsumeDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  	
	private long detailId;
	private long storeId;
	private String date;
	private long goodsId;
	private int quantity;
	private long consumeId;
	
	public long getDetailId() {
		return detailId;
	}
	public void setDetailId(long detailId) {
		this.detailId = detailId;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getConsumeId() {
		return consumeId;
	}
	public void setConsumeId(long consumeId) {
		this.consumeId = consumeId;
	}
	
}
