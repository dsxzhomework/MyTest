package com.education.test.vo;

import java.util.List;

public class ScheduleDataVo {
	private String date;
	private List<goodsDetailVo> goodsDetail;
	
	public List<goodsDetailVo> getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(List<goodsDetailVo> goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
