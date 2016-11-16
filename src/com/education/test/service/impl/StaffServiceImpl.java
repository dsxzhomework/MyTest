package com.education.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.test.dao.ConsumeDetailDao;
import com.education.test.dao.ConsumeRecordDao;
import com.education.test.dao.ProductDao;
import com.education.test.dao.ScheduleDao;
import com.education.test.dao.ScheduleDetailDao;
import com.education.test.dao.WaiterInfoDao;
import com.education.test.model.ConsumeDetail;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.Schedule;
import com.education.test.model.ScheduleDetail;
import com.education.test.model.product;
import com.education.test.model.waiterInfo;
import com.education.test.service.StaffService;
import com.education.test.vo.consumeDetailVo;
import com.education.test.vo.goodsDetailVo;
import com.education.test.vo.showProductNameVo;

@Service
public class StaffServiceImpl implements StaffService{
	@Autowired
	private WaiterInfoDao waiterInfoDao;
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private ScheduleDetailDao detailDao;
	@Autowired
	private ConsumeRecordDao consumeDao;
	@Autowired
	private ConsumeDetailDao consumeDetailDao;
	@Autowired
	private ProductDao productDao;
	
	//验证服务员登录
	public String staffLogin(long waiterID,String password){
		waiterInfo info=new waiterInfo();
		info=waiterInfoDao.getByColumn(waiterInfo.class,"waiterID",waiterID);
		if(info.getPassword().equals(password)){		
			if(info.getGrade()==0){
				return "总店";
			}
			else{
				return "分店";
			}		
		}
		else{
			return "fail";
		}
	}
	
	//获取服务员表全部信息
	public waiterInfo getWaiterInfo(long waiterID){
		waiterInfo info=new waiterInfo();
		info=waiterInfoDao.getById(waiterInfo.class, waiterID);
		return info;
		
	}
	//将整周计划存入schedule表
	public long addSchedule(String startTime,long storeId,int state){
		Schedule schedule=new Schedule();
		schedule.setStartTime(startTime);
		schedule.setState(state);
		schedule.setStoreId(storeId);	
		scheduleDao.add(schedule);
				
		return schedule.getScheduleId();		
	}
	//将日计划存入scheduledetail表
	public void addScheduleDetail(List<goodsDetailVo> goodsList,long scheduleId){
		ScheduleDetail detail=new ScheduleDetail();
		for(int i=0;i<goodsList.size();i++){
			detail.setScheduleId(scheduleId);
			detail.setGoodsId(goodsList.get(i).getGoodsId());
			detail.setPrice(goodsList.get(i).getPrice());
			detail.setQuantity(goodsList.get(i).getQuantity());
			detail.setDate(goodsList.get(i).getDate());
			detailDao.add(detail);
			detail=new ScheduleDetail();
		}
		
	}
	//获取分店可取库存
	@SuppressWarnings("null")
	public List<ScheduleDetail> getScheduleDeatil(long storeId,String startTime,String todayTime){
		List<Schedule> scheduleList;
		long scheduleId=0;
		List<ScheduleDetail> detail;
		ArrayList<ScheduleDetail> result=new ArrayList<ScheduleDetail>();
		//获取计划id
		System.out.println(storeId+"test");
		scheduleList=scheduleDao.getAll();
		for(int i=0;i<scheduleList.size();i++){
			if(scheduleList.get(i).getStoreId()==storeId&&scheduleList.get(i).getStartTime().equals(startTime)){
				scheduleId=scheduleList.get(i).getScheduleId();
			}
		}
	    //获取计划详情
		detail=detailDao.getBySchedule(ScheduleDetail.class,"scheduleId",scheduleId);	
		;
		int size=detail.size();

		for(int k=0;k<size;k++){
			if(detail.get(k).getDate().equals("2016/03/23")){				
				result.add(detail.get(k));
			}
		}
		return result;		
	}
	//将新消费记录存入数据库
	public long addConsumeRecord(long cardNum,String kind,int totalPrice,long storeId,String date){
		ConsumeRecord temp=new ConsumeRecord();
		temp.setCardNum(cardNum);
		temp.setKind(kind);
		temp.setStoreId(storeId);
		temp.setTotalPrice(totalPrice);		
		temp.setDate(date);
		consumeDao.add(temp);
		return temp.getConsumeId();
	}
	//将消费明细存入数据库
	public void addConsumeDetail(long consumeId,String date,long storeId,List<consumeDetailVo> list){
		for(int i=0;i<list.size();i++){
			ConsumeDetail temp=new ConsumeDetail();
			temp.setDate(date);
			temp.setStoreId(storeId);
			temp.setConsumeId(consumeId);
			temp.setGoodsId(list.get(i).getGoodsId());
			temp.setQuantity(list.get(i).getQuantity());
			consumeDetailDao.add(temp);
		}
	}
	//获取商店销售记录
	public List<ConsumeRecord> getConsumeRecord(long StoreId){
		List<ConsumeRecord> temp;
		temp=consumeDao.getLists(ConsumeRecord.class, "storeId", StoreId);
		return temp;
	}
	//获取商店销售详情
	public List<ConsumeDetail> getConsumeDetail(long consumeId){
		List<ConsumeDetail> result;
		result=consumeDetailDao.getLists(ConsumeDetail.class,"consumeId", consumeId);
		return result;		
	}
	//获取展示销售详情（包括产品命名）
	public ArrayList<showProductNameVo> getShowConsumeDetailList(List<ConsumeDetail> consumeDetailList){
		ArrayList<showProductNameVo> result= new ArrayList<showProductNameVo>();
		for(int i=0;i<consumeDetailList.size();i++){
			showProductNameVo temp = new showProductNameVo();
			temp.setDate(consumeDetailList.get(i).getDate());
			temp.setDetailId(consumeDetailList.get(i).getDetailId());
			temp.setQuantity(consumeDetailList.get(i).getQuantity());
			temp.setName(productDao.getById(product.class,consumeDetailList.get(i).getGoodsId()).getProductName());
			result.add(temp);
		}
		return result;
	}
	//获取产品计划列表
	public List<Schedule> getScheduleList(){
		List<Schedule> result;
		result=scheduleDao.getAll();
		return result;
	}
	//获取产品计划详情
	public ScheduleDetail getScheduleDetailMain(long scheduleId){
		ScheduleDetail result=new ScheduleDetail();
		result=detailDao.getById(ScheduleDetail.class, scheduleId);
		return result;
	}
	
}
