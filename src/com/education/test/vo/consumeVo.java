package com.education.test.vo;

import java.util.List;

public class consumeVo {
	private int totalPrice; 
	private List<consumeDetailVo> consumeDetail;
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<consumeDetailVo> getConsumeDetail() {
		return consumeDetail;
	}
	public void setConsumeDetail(List<consumeDetailVo> consumeDetail) {
		this.consumeDetail = consumeDetail;
	}

}
