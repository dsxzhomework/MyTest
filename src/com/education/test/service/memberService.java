package com.education.test.service;

import java.util.ArrayList;
import java.util.List;

import com.education.test.model.CardAccount;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.RechargeRecord;
import com.education.test.model.memberInfo;
import com.education.test.vo.statisticsVo;

public interface memberService {
	public List<memberInfo> getList();
	//将注册信息插入数据库
	public void registerInfo(String phoneNum,String password,String name);
	//注册查重
	public String isRepeated(String phoneNum);
	public long lastCardNum();
	public memberInfo getMemberInfoJsp(long cardNum);
	//用户关联银行卡信息
	public List<CardAccount> getCardAccount(long cardNum);
	public int findCardBalance(long cardNum);
	public void updateCardBalance(long cardNum,int balance);
	public void updateCardState(long cardNum,String cardState);
	public void DestroyMemberInfo(long cardNum);
	//检查登录
	public memberInfo confirmLogin(String name,String passowrd);
	public List<ConsumeRecord> getMemberConsume(long cardNum);
	public void updateCardPoints(long cardNum,long points);
	
	public List<RechargeRecord> getRechargeRecord(long cardNum);
	public void insertRechargeRecord(long cardNum,int payment,String date,String bankAccount);
	public void updateMemberInfo(long cardNum,String address,String birthday,String gender);
	public void updateMemberPassword(long cardNum,String password);
	
	public void updateMemberStatus(long cardNum);
}
