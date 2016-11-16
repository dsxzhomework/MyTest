package com.education.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.test.dao.ConsumeRecordDao;
import com.education.test.dao.ScheduleDao;
import com.education.test.dao.ScheduleDetailDao;
import com.education.test.dao.StoreInfoDao;
import com.education.test.dao.WaiterInfoDao;
import com.education.test.dao.memberInfoDao;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.Schedule;
import com.education.test.model.ScheduleDetail;
import com.education.test.model.StoreInfo;
import com.education.test.model.memberInfo;
import com.education.test.model.waiterInfo;
import com.education.test.service.AdminService;
import com.education.test.service.ManagerService;
import com.education.test.vo.statisticsVo;

@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private ScheduleDetailDao detailDao;
	@Autowired
	private memberInfoDao memberInfoDao;
	@Autowired
	private WaiterInfoDao waiterInfoDao;
	@Autowired
	private StoreInfoDao storeInfoDao;
	@Autowired
	private ConsumeRecordDao consumeDao;
	@Autowired
	private AdminService adminService;
	
	//查找待审批计划
	public List<Schedule> getScheduleList(){
		List<Schedule> result;
		result=scheduleDao.getLists(Schedule.class,"state", 0);
		return result;
	}
	//查找计划详情
	public List<ScheduleDetail> getDetail(long scheduleId){
		List<ScheduleDetail> result;
		result=detailDao.getLists(ScheduleDetail.class,"scheduleId", scheduleId);
		return result;
	}
	//更新计划状态
	public void updateSchedule(long scheduleId,int state){
		Schedule temp;
		temp=scheduleDao.getById(Schedule.class, scheduleId);
		temp.setState(state);
		scheduleDao.update(temp);
	}
	//返回现有店员数量
	public int numberOfStaff(){
		int result=waiterInfoDao.getCounts(waiterInfo.class);
		return result;
	}
	//返回现有会员数量
	public int numberOfMember(){
		int result=memberInfoDao.getCounts(memberInfo.class);
		return result;
	}
	//返回现有店面数量
	public int numberOfStore(){
		int result=storeInfoDao.getCounts(StoreInfo.class);
		return result;
	}
	//统计男女
	public int numberOfFemale(){
		//女士优先
		int result=0;
		List<memberInfo> info=memberInfoDao.getAll();
		for(int i=0;i<info.size();i++){
			if(info.get(i).getGender().equals("女")){
				result=result+1;
			}
		}
		return result;
	}
	public int numberOfMale(){
		//男
		int result=0;
		List<memberInfo> info=memberInfoDao.getAll();
		for(int i=0;i<info.size();i++){
			if(info.get(i).getGender().equals("男")){
				result=result+1;
			}
		}
		return result;
	}
	//统计
	@SuppressWarnings("unused")
	public ArrayList<statisticsVo> getStatisticsList(){
		List<ConsumeRecord> consumeList;
		ArrayList<statisticsVo> result=new ArrayList<statisticsVo>();
		consumeList=consumeDao.getAll();
		
		for(int i=0;i<consumeList.size();i++){
			//对所有消费记录循环
			long storeId=consumeList.get(i).getStoreId();
			//System.out.println(result.size()+"size");
			if(result.size()!=0){
                if(!ifExist(result, storeId)){
                    //若不存在
                    statisticsVo vo= new statisticsVo();
                    vo.setStoreId(storeId);
                    vo.setTurnover(consumeList.get(i).getTotalPrice());
                    if(storeId!=0){
                    vo.setStoreName(adminService.getStoreInfo(storeId).getName());
                    }
                    else{
                    vo.setStoreName("网上销售");
                    }
                    result.add(vo);
                }else{
                    //已存在
                	for(int k=0;k<result.size();k++){
                		if(result.get(k).getStoreId()==storeId){
                			int turnover=result.get(k).getTurnover();
                			turnover=turnover+consumeList.get(i).getTotalPrice();
                			result.get(k).setTurnover(turnover);
                		}
                	}
                }
			}else{
				statisticsVo vo= new statisticsVo();
				vo.setStoreId(storeId);
				vo.setTurnover(consumeList.get(i).getTotalPrice());
				vo.setStoreName(adminService.getStoreInfo(storeId).getName());
				result.add(vo);
			}
									
				
		}
		
		for(int j=0;j<result.size();j++){
			//System.out.println("test");
			System.out.println(result.get(j).getTurnover());
		}
		return null;
	}
    
    private boolean ifExist(List<statisticsVo> list, long store_id){
        boolean result = false;
        for(statisticsVo vo:list){
            if(vo.getStoreId()==store_id){
                result = true;
            }
        }
        return result;
    }
	
	
	
}
