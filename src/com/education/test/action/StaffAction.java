package com.education.test.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.education.test.model.ConsumeDetail;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.Schedule;
import com.education.test.model.ScheduleDetail;
import com.education.test.model.StoreInfo;
import com.education.test.model.product;
import com.education.test.model.waiterInfo;
import com.education.test.service.AdminService;
import com.education.test.service.ProductService;
import com.education.test.service.StaffService;
import com.education.test.service.memberService;
import com.education.test.vo.ScheduleDataVo;
import com.education.test.vo.ScheduleStateVo;
import com.education.test.vo.consumeDetailVo;
import com.education.test.vo.consumeVo;
import com.education.test.vo.goodsDetailVo;

@Repository
public class StaffAction {
	private static final String SUCCESS = "success";
	@Autowired
	StaffService staffService;
	@Autowired
	AdminService adminService;
	@Autowired
	memberService memberInfoService;
	@Autowired
	ProductService productService;
	
	private long waiterID;
	private String name;
	private String password;
	private String staffChoice;
	private String loginResult;
	private String kind;
	private int totalPrice;
	private long cardNum;
	private long storeID;
	private waiterInfo waiterInfo;
	private String storeName;
	//获取下周时间
	private List<String> nextWeek;
	private List<StoreInfo> storeInfoList;
	//一周的产品计划list	
	private List<Schedule> scheduleList;
	private List<ScheduleDetail> scheduleDetail;
	private ArrayList<ScheduleStateVo> stateVo=new ArrayList<ScheduleStateVo>();
	private ScheduleDataVo data;	
	private StoreInfo storeInfo;
	private String startTime;
	//页面显示table
	private ArrayList<ScheduleDataVo> pageDataList=new ArrayList<ScheduleDataVo>();
	private int sumbitedDays;
	//显示未来一周时间的时间戳list
	private List<String> timeList;
	private ArrayList<String> submitList=new ArrayList<String>();
	//查看日计划
	private String date;
	private List<goodsDetailVo> goodsDetail;
	private ArrayList<goodsDetailVo> detailList=new ArrayList<goodsDetailVo>(); 
	//分店销售
	private List<ScheduleDetail> detail;
	private consumeVo newConsume;	
	private List<consumeDetailVo> consumeinfo;
	private int balance;
	private List<ConsumeRecord> record;
	private long consumeId;
	private List<ConsumeDetail> consumeDetail;
	//
	private List<product> goodsList;
	
	
	
	public String staffLogin(){
		setLoginResult(staffService.staffLogin(waiterID, password));
		System.out.println(loginResult);
		if(!loginResult.equals("fail")){
			setStaffChoice(loginResult);
			waiterInfo=staffService.getWaiterInfo(waiterID);
			setStoreID(waiterInfo.getStoreID());
			setName(waiterInfo.getName());
			setStoreName(waiterInfo.getStoreName());
			System.out.println("登录结果?"+staffChoice);
		}
		setStoreInfoList(adminService.getStoreList());
		//setStoreID(staffService.);
		return null;
	}
	//进入总店||分店
	public String staffChoose(){
		setTimeList(getNextWeek1());
		setStartTime(timeList.get(0));
		//分店销售页面渲染
		if(staffChoice.equals("分店")){
			System.out.println(storeID);
			System.out.println(name);
			//String tempTime=timeList.get(0);
			String todayTime=getTodayTime();
			setDate(todayTime);
			System.out.println(todayTime+"今日日期");
			//假数据
			setDetail(staffService.getScheduleDeatil(storeID, "2016/03/20",getTodayTime()));			
		}
		//
		setGoodsList(productService.getAllProduct());
		
		return staffChoice;
	}
	public String ShowStaffSchedule(){
		for(int i=0;i<pageDataList.size();i++){
			System.out.println(pageDataList.get(i).getDate());
		}
		repeatedSubmit();
		sumbitedDays=pageDataList.size();
		return SUCCESS;
	}
	//选择制定计划分店分店
	public String StaffSchedule(){	
		setStoreInfo(adminService.getStoreInfo(storeID));
		//System.out.println(name);
		setName(storeInfo.getName());
		return null;
	}
	//销售单创建
	public String newConsume(){
		//System.out.println(newConsume.getConsumeDetail().size()+"测试后台是否拿到数据");
		setConsumeinfo(newConsume.getConsumeDetail());
		setTotalPrice(newConsume.getTotalPrice());
		//加入consumeRecord表
		long temp=staffService.addConsumeRecord(0,"现金", totalPrice, storeID,date);
		//加入consumerecorddetail表
		staffService.addConsumeDetail(temp, date, storeID,consumeinfo);	
		//System.out.println("数据库插入成功");
		return null;		
	}

	//添加一天的产品计划
	public String newDaySchedule(){
		submitList.add(data.getDate());
		pageDataList.add(data);
		data=new ScheduleDataVo();
		return null;		
	}
	//查看日计划详情
	public String searchDetail(){
		for(int i=0;i<pageDataList.size();i++){
			if(pageDataList.get(i).getDate().equals(date)){
				setGoodsDetail(pageDataList.get(i).getGoodsDetail());
			}
		}
		return null;		
	}
	public String showDetail(){
		return SUCCESS;
		
	}
	//删除日计划
	public String deleteDetail(){
		for(int i=0;i<pageDataList.size();i++){
			if(pageDataList.get(i).getDate().equals(date)){
				
				pageDataList.remove(i);
			}
		}	
		for(int k=0;k<submitList.size();k++){
			if(submitList.get(k).equals(date)){
				submitList.remove(k);
				System.out.println("移除submitlist");
			}
		}
		timeList.add(date);
		return null;		
	}
	
	//将整周计划提交数据库
	public String weekSubmited(){
		//提交schedule 数据：startTime storeID state；获取计划id
		long scheduleId=staffService.addSchedule(startTime, storeID, 0);	
		//提交scheduledetail数据		
		for(int i=0;i<pageDataList.size();i++){
			int temp=pageDataList.get(i).getGoodsDetail().size();
			for(int k=0;k<temp;k++){
				detailList.add(pageDataList.get(i).getGoodsDetail().get(k));			
			}
		}
		staffService.addScheduleDetail(detailList, scheduleId);
		return SUCCESS;		
	}
	//验证重复提交当日计划
	public String repeatedSubmit(){
		for(int i=0;i<timeList.size();i++){
			for(int k=0;k<submitList.size();k++){
				if(timeList.get(i).equals(submitList.get(k))){
					timeList.remove(i);
				}
			}
		}
	
		return null;		
	}
	//进入会员卡消费界面
	public String showStaffCard(){
		return SUCCESS;
	}
	//显示商店销售记录
	public String showStoreRecord(){
		System.out.println(storeID);
		setRecord(staffService.getConsumeRecord(storeID));
		return SUCCESS;
	}
	//查找销售记录详情
	public String recordDetail(){
		setConsumeDetail(staffService.getConsumeDetail(consumeId));
		return null;
	}
	//显示销售记录详情界面
	public String showRecordDetail(){
		return SUCCESS;
	}
	//查找会员卡信息
	public String cardDetail(){	
		//查找会员卡余额
		
		setBalance(memberInfoService.findCardBalance(cardNum));
		return null;	
	}
	//显示会员卡消费界面
	public String showCardDetail(){
		return SUCCESS;
	}
	//将会员卡消费记录存入数据库
	public String newCardConsume(){
		//System.out.println(newConsume.getConsumeDetail().size()+"测试后台是否拿到数据");
		setConsumeinfo(newConsume.getConsumeDetail());
		setTotalPrice(newConsume.getTotalPrice());
		//加入consumeRecord表
		long temp=staffService.addConsumeRecord(cardNum,"会员卡", totalPrice, storeID,date);
		//加入consumerecorddetail表
		staffService.addConsumeDetail(temp, date, storeID,consumeinfo);		
		//更改会员卡余额
		balance=balance-totalPrice;
		memberInfoService.updateCardBalance(cardNum, balance);	
		return null;
	}
	//总店服务员查看计划状态
	public String showScheduleState(){
		stateVo=new ArrayList<ScheduleStateVo>();
		setScheduleList(staffService.getScheduleList());
		String result="";
		
		for(int i=0;i<scheduleList.size();i++){
			int temp=scheduleList.get(i).getState();
			ScheduleStateVo vo=new ScheduleStateVo();
			vo.setDate(scheduleList.get(i).getStartTime());
			vo.setScheduleId(scheduleList.get(i).getScheduleId());
			vo.setStoreId(scheduleList.get(i).getStoreId());
			//System.out.println(adminService.getStoreInfo(scheduleList.get(i).getStoreId()).getName());
			vo.setStoreName(adminService.getStoreInfo(scheduleList.get(i).getStoreId()).getName());
			if(temp==0){
				result="未审批";
			}
			else if(temp==1){
				result="已通过";
			}
			else{
				result="否决";
			}
			vo.setState(result);
			stateVo.add(vo);
		}
		
		return SUCCESS;
	}
	
	//选定日期
	public List<String> getNextWeek1() {
		List<String> result = new ArrayList<String>();
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");   
		Calendar today = Calendar.getInstance();
//		System.out.println(new Timestamp(today.getTimeInMillis()).toString());
//		System.out.println(today.get(Calendar.DAY_OF_WEEK));
		int weekday = today.get(Calendar.DAY_OF_WEEK);
		int date = today.get(Calendar.DATE);
//		System.out.println(date);
		today.set(Calendar.DATE, date+7-weekday);
		for (int i = 0; i < 7; i++) {
			date = today.get(Calendar.DATE);
			today.set(Calendar.DATE, date+1);
			result.add(sdf.format(new Timestamp(today.getTimeInMillis())));
		}
		return result;
	}
	
	//获得今日日期字符串
	public String getTodayTime(){
	    String temp_str="";   
	    Date dt = new Date();   
	    //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	    temp_str=sdf.format(dt);   
	    return temp_str;   	
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffChoice() {
		return staffChoice;
	}

	public void setStaffChoice(String staffChoice) {
		this.staffChoice = staffChoice;
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
	public long getStoreID() {
		return storeID;
	}
	public void setStoreID(long storeID) {
		this.storeID = storeID;
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
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public long getWaiterID() {
		return waiterID;
	}
	public void setWaiterID(long waiterID) {
		this.waiterID = waiterID;
	}
	public waiterInfo getWaiterInfo() {
		return waiterInfo;
	}
	public void setWaiterInfo(waiterInfo waiterInfo) {
		this.waiterInfo = waiterInfo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public List<String> getNextWeek() {
		return nextWeek;
	}
	public void setNextWeek(List<String> nextWeek) {
		this.nextWeek = nextWeek;
	}
	public List<StoreInfo> getStoreInfoList() {
		return storeInfoList;
	}
	public void setStoreInfoList(List<StoreInfo> storeInfoList) {
		this.storeInfoList = storeInfoList;
	}

	public List<ScheduleDetail> getScheduleDetail() {
		return scheduleDetail;
	}
	public void setScheduleDetail(List<ScheduleDetail> scheduleDetail) {
		this.scheduleDetail = scheduleDetail;
	}
	public ScheduleDataVo getData() {
		return data;
	}
	public void setData(ScheduleDataVo data) {
		this.data = data;
	}
	public List<Schedule> getScheduleList() {
		return scheduleList;
	}
	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	public StoreInfo getStoreInfo() {
		return storeInfo;
	}
	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	public ArrayList<ScheduleDataVo> getPageDataList() {
		return pageDataList;
	}
	public void setPageDataList(ArrayList<ScheduleDataVo> pageDataList) {
		this.pageDataList = pageDataList;
	}
	public List<String> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}
	public ArrayList<String> getSubmitList() {
		return submitList;
	}
	public void setSubmitList(ArrayList<String> submitList) {
		this.submitList = submitList;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<goodsDetailVo> getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(List<goodsDetailVo> goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	public int getSumbitedDays() {
		return sumbitedDays;
	}
	public void setSumbitedDays(int sumbitedDays) {
		this.sumbitedDays = sumbitedDays;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public ArrayList<goodsDetailVo> getDetailList() {
		return detailList;
	}
	public void setDetailList(ArrayList<goodsDetailVo> detailList) {
		this.detailList = detailList;
	}
	public List<ScheduleDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<ScheduleDetail> detail) {
		this.detail = detail;
	}
	public consumeVo getNewConsume() {
		return newConsume;
	}
	public void setNewConsume(consumeVo newConsume) {
		this.newConsume = newConsume;
	}
	public List<consumeDetailVo> getConsumeinfo() {
		return consumeinfo;
	}
	public void setConsumeinfo(List<consumeDetailVo> consumeinfo) {
		this.consumeinfo = consumeinfo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public List<ConsumeRecord> getRecord() {
		return record;
	}
	public void setRecord(List<ConsumeRecord> record) {
		this.record = record;
	}
	public long getConsumeId() {
		return consumeId;
	}
	public void setConsumeId(long consumeId) {
		this.consumeId = consumeId;
	}
	public List<ConsumeDetail> getConsumeDetail() {
		return consumeDetail;
	}
	public void setConsumeDetail(List<ConsumeDetail> consumeDetail) {
		this.consumeDetail = consumeDetail;
	}
	public ArrayList<ScheduleStateVo> getStateVo() {
		return stateVo;
	}
	public void setStateVo(ArrayList<ScheduleStateVo> stateVo) {
		this.stateVo = stateVo;
	}
	public List<product> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<product> goodsList) {
		this.goodsList = goodsList;
	}




}
