package com.education.test.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.test.model.CardAccount;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.RechargeRecord;
import com.education.test.model.memberInfo;
import com.education.test.service.memberService;
import com.education.test.dao.CardAccountDao;
import com.education.test.dao.ConsumeRecordDao;
import com.education.test.dao.RechargeRecordDao;
import com.education.test.dao.memberInfoDao;
@Service
public class memberServiceImpl implements memberService{
	@Autowired
	private memberInfoDao memberInfoDao;
	@Autowired
	private CardAccountDao cardAccountDao;
	@Autowired
	private ConsumeRecordDao consumeDao;
	@Autowired
	private RechargeRecordDao rechargeDao;
	
	@Override
	//获取memberinfo表全部信息
	public List<memberInfo> getList() {
		// TODO Auto-generated method stub
		List<memberInfo> mylist = memberInfoDao.getAll();
		return mylist;
	}
	
	
	//我的信息界面信息
	public memberInfo getMemberInfoJsp(long cardNum){
		memberInfo getInfo=new memberInfo();
		getInfo=memberInfoDao.getById(memberInfo.class,cardNum);		
		return getInfo;
		
	}
	
	//获取关联银行卡信息
	public List<CardAccount> getCardAccount(long cardNum){
		List<CardAccount> getAccount= cardAccountDao.getLists(CardAccount.class, "cardNum", cardNum);
		return getAccount;
	}
	//检查登录
	public memberInfo confirmLogin(String name,String passowrd){
		memberInfo info=new memberInfo();
		info=memberInfoDao.getByColumn(memberInfo.class, "phoneNum", name);	
		return info;
	}
	//注销会员信息
	public void DestroyMemberInfo(long cardNum){
		memberInfo info=new memberInfo();
		info=memberInfoDao.getById(memberInfo.class, cardNum);
		memberInfoDao.delete(info);	
	}
	//获取当前会员卡号
	public long lastCardNum(){
		List<memberInfo> info=getList();
		long lastNum;
		int size=info.size();
		if(size>0){
			 lastNum=info.get(size-1).getCardNum();
		}
		else{
			lastNum=10000000;
		}
		return lastNum;
		
	}
	//查重
	public String isRepeated(String phoneNum){
		String result="";
		memberInfoDao.getByColumn(memberInfo.class, "phoneNum", phoneNum);
		if(memberInfoDao.getByColumn(memberInfo.class, "phoneNum", phoneNum)!=null){
			result="YES";
			
		}
		else{
			result="NO";
		}
		
		return result;		
	}
	
	//注册添加信息
	public void registerInfo(String phoneNum,String password,String name){
		//获取当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date=df.format(new Date());
		try{
		memberInfo registerInfo=new memberInfo();
		registerInfo.setPassword(password);
		registerInfo.setCreatedAt(date);
		registerInfo.setPhoneNum(phoneNum);
		registerInfo.setName(name);
		registerInfo.setCardGrade("普通会员");
		registerInfo.setCardState("未激活");
		memberInfoDao.add(registerInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//获取会员卡余额
	public int findCardBalance(long cardNum){

		memberInfo info=new memberInfo();
		info=memberInfoDao.getById(memberInfo.class, cardNum);
		return info.getBalance();
	}
	//修改会员卡余额
	public void updateCardBalance(long cardNum,int balance){
		memberInfo info=new memberInfo();
		info=memberInfoDao.getById(memberInfo.class, cardNum);
		info.setBalance(balance);
		memberInfoDao.update(info);
	}
	//修改会员卡状态
	public void updateCardState(long cardNum,String cardState){
		memberInfo info=new memberInfo();
		info=memberInfoDao.getById(memberInfo.class, cardNum);
		info.setCardState(cardState);
		memberInfoDao.update(info);
	}
	//修改会员卡积分
	public void updateCardPoints(long cardNum,long points){
		memberInfo info=new memberInfo();
		info=memberInfoDao.getById(memberInfo.class, cardNum);
		info.setPoints(points);
		memberInfoDao.update(info);
	}
	//获取会员消费记录
	public List<ConsumeRecord> getMemberConsume(long cardNum){
		List<ConsumeRecord> result;
		result=consumeDao.getLists(ConsumeRecord.class, "cardNum", cardNum);
		return result;
		
	}
	//获取充值记录
	public List<RechargeRecord> getRechargeRecord(long cardNum){
		List<RechargeRecord> result;
		result=rechargeDao.getLists(RechargeRecord.class, "cardNum", cardNum);
		return result;
	}
	//插入充值记录
	public void insertRechargeRecord(long cardNum,int payment,String date,String bankAccount){
		RechargeRecord result=new RechargeRecord();
		result.setBankAccount(bankAccount);
		result.setCardNum(cardNum);
		result.setDate(date);
		result.setPayment(payment);
		rechargeDao.add(result);
	}
	//更新个人资料
	public void updateMemberInfo(long cardNum,String address,String birthday,String gender){
		memberInfo info=new memberInfo();
		info=memberInfoDao.getById(memberInfo.class, cardNum);
		info.setAddress(address);
		info.setBirthday(birthday);
		info.setGender(gender);
		memberInfoDao.update(info);
	}
	
	//更新用户密码
	public void updateMemberPassword(long cardNum,String password){
		memberInfo info = new memberInfo();
		info =  memberInfoDao.getById(memberInfo.class, cardNum);
		info.setPassword(password);
		memberInfoDao.update(info);
	}
	
	//暂停会员资格
	//@Override
	@SuppressWarnings("deprecation")
	public void updateMemberStatus(long cardNum) {
		memberInfo member = memberInfoDao.getById(memberInfo.class,cardNum);
		Date today = new Date();
		 Date register=new Date(member.getCreatedAt()); 
		double days = (today.getTime() -register.getTime())/(1000 * 60 * 60 * 24);
		if(days>365)
			member.setCardState("暂停");
		if(days>(365*2))
			memberInfoDao.delete(member);
	}
}
