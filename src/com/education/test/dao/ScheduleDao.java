package com.education.test.dao;

import java.util.List;

import com.education.test.model.Schedule;

public interface ScheduleDao extends BaseDao<Schedule>{
	public  List<Schedule> getAll();

}
