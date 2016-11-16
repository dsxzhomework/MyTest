package com.education.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ConsumeRecord")
public class ConsumeRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private long consumeId;
	private long cardNum;
	private String kind;//cash&card
	private int totalPrice;
	private long storeId;
	private String date;
	
	public long getConsumeId() {
		return consumeId;
	}
	public void setConsumeId(long consumeId) {
		this.consumeId = consumeId;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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
	
}
