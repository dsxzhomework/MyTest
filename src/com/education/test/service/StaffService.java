package com.education.test.service;

import java.util.List;

import com.education.test.model.ConsumeDetail;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.Schedule;
import com.education.test.model.ScheduleDetail;
import com.education.test.model.waiterInfo;
import com.education.test.vo.consumeDetailVo;
import com.education.test.vo.goodsDetailVo;
import com.education.test.vo.showProductNameVo;

public interface StaffService {
	public String staffLogin(long name,String password);
	public waiterInfo getWaiterInfo(long waiterID);
	public long addSchedule(String startTime,long storeId,int state);
	public void addScheduleDetail(List<goodsDetailVo> goodsList,long scheduleId);
	public List<ScheduleDetail> getScheduleDeatil(long storeId,String startTime,String todayTime);
	public long addConsumeRecord(long cardNum,String kind,int totalPrice,long storeId,String date);
	public void addConsumeDetail(long consumeId,String date,long storeId,List<consumeDetailVo> list);
	public List<ConsumeRecord> getConsumeRecord(long StoreId);
	public List<ConsumeDetail> getConsumeDetail(long consumeId);
	public List<Schedule> getScheduleList();
	public ScheduleDetail getScheduleDetailMain(long scheduleId);
	public List<showProductNameVo> getShowConsumeDetailList(List<ConsumeDetail> consumeDetailList);
}
