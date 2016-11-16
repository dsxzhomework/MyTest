package com.education.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RechargeRecord")
public class RechargeRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rechargeId;
	private int payment;
	private String date;
	private long cardNum;
	private String bankAccount;
	
	
	public long getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(long rechargeId) {
		this.rechargeId = rechargeId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
}
