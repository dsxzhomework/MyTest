package com.education.test.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.education.test.model.Schedule;
import com.education.test.model.ScheduleDetail;
import com.education.test.service.AdminService;
import com.education.test.service.ManagerService;
import com.education.test.service.StaffService;
import com.education.test.vo.statisticsVo;

@Repository
public class ManagerAction {
	private static final String SUCCESS = "success";
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private StaffService staffService; 
	
	private List<Schedule> scheduleList;
	private long scheduleId;
	private List<ScheduleDetail> detailList;
	//统计
	private int numberOfStaff;
	private int numberOfMember;
	private int numberOfStore;	
	private int femaleNum;
	private int maleNum;
	private ArrayList<statisticsVo> storeInfoList;
	private String[] storeName= new String[4];
	
	//显示主界面（统计界面）
	public String managerLogin(){
		setNumberOfStaff(managerService.numberOfStaff());
		setNumberOfMember(managerService.numberOfMember());
		setNumberOfStore(managerService.numberOfStore());
		//饼状图
		setFemaleNum(managerService.numberOfFemale());
		setMaleNum(managerService.numberOfMale());
		setStoreInfoList(managerService.getStatisticsList());
		test();
		return SUCCESS;
	}
	//处理统计数据
	public void test(){
		//managerService.getStatisticsList();
		storeName[0]="南京一店";
		storeName[1]="网上销售";
		storeName[2]="南京三店";
		storeName[3]="长春一店";
//		storeName.add("网上销售");
//		storeName.add("南京三店");
//		storeName.add("北京一店");
//		storeNmae.add("长春一店");
	}
	
	//查看待审批计划
	public String findSchedule(){
		 setScheduleList(managerService.getScheduleList());	
		return SUCCESS;
	}
	//查看计划详情
	public String managerScheduleDetail(){
		setDetailList(managerService.getDetail(scheduleId));
		return null;
		
	}	
	//显示计划详情界面
	public String managerShowDetail(){
		return SUCCESS;
	}
	
	//通过计划
	public String passSchedule(){
		int state=1;
		managerService.updateSchedule(scheduleId, state);
		return null;
	}
	//否决计划
	public String denySchedule(){
		int state=2;
		System.out.println(scheduleId);
		managerService.updateSchedule(scheduleId, state);
		return null;
	}
	
	
	

	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public List<ScheduleDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<ScheduleDetail> detailList) {
		this.detailList = detailList;
	}

	public int getNumberOfStaff() {
		return numberOfStaff;
	}

	public void setNumberOfStaff(int numberOfStaff) {
		this.numberOfStaff = numberOfStaff;
	}

	public int getNumberOfMember() {
		return numberOfMember;
	}

	public void setNumberOfMember(int numberOfMember) {
		this.numberOfMember = numberOfMember;
	}

	public int getNumberOfStore() {
		return numberOfStore;
	}

	public void setNumberOfStore(int numberOfStore) {
		this.numberOfStore = numberOfStore;
	}
	public int getFemaleNum() {
		return femaleNum;
	}
	public void setFemaleNum(int femaleNum) {
		this.femaleNum = femaleNum;
	}
	public int getMaleNum() {
		return maleNum;
	}
	public void setMaleNum(int maleNum) {
		this.maleNum = maleNum;
	}
	public ArrayList<statisticsVo> getStoreInfoList() {
		return storeInfoList;
	}
	public void setStoreInfoList(ArrayList<statisticsVo> storeInfoList) {
		this.storeInfoList = storeInfoList;
	}
	public String[] getStoreName() {
		return storeName;
	}
	public void setStoreName(String[] storeName) {
		this.storeName = storeName;
	}

}
