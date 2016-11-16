package com.education.test.dao;

import java.util.List;

import com.education.test.model.ScheduleDetail;

public interface ScheduleDetailDao extends BaseDao<ScheduleDetail>{
	public  List<ScheduleDetail> getAll();
	public List<ScheduleDetail> getBySchedule(Class t, String column, Object value);
}
