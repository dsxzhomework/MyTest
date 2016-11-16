package com.education.test.service;

import java.util.ArrayList;
import java.util.List;

import com.education.test.model.Schedule;
import com.education.test.model.ScheduleDetail;
import com.education.test.vo.statisticsVo;

public interface ManagerService {
	public List<Schedule> getScheduleList();
	public List<ScheduleDetail> getDetail(long scheduleId);
	public void updateSchedule(long scheduleId,int state);
	public int numberOfStaff();
	public int numberOfMember();
	public int numberOfStore();
	public ArrayList<statisticsVo> getStatisticsList();
	public int numberOfMale();
	public int numberOfFemale();
}
