package com.education.test.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.education.test.model.ConsumeDetail;
import com.education.test.model.ConsumeRecord;
import com.education.test.model.RechargeRecord;
import com.education.test.model.memberInfo;
import com.education.test.model.product;
import com.education.test.service.ProductService;
import com.education.test.service.StaffService;
import com.education.test.service.memberService;
import com.education.test.vo.CartVo;
import com.education.test.vo.consumeDetailVo;
import com.education.test.vo.showProductNameVo;

@Repository
public class MemberAction {
	private static final String SUCCESS = "success";
	@Autowired
	private memberService memberService;
	@Autowired
	private ProductService productService;
	@Autowired
	private StaffService staffService;
	
	private String loginName;
	private String loginPassword;
	private String loginResult;
	//注册信息
	private String registerName;
	private String registerPhoneNum;
	private String registerPassword;
	private String registerResult;
	//主界面
	private List<product> productList;
	//产品模块
	private long productId;
	private product info;
	private String productName;
	private String productInfo;
	private int productPrice;
	private int quantity;
	private ArrayList<CartVo> cart=new ArrayList<CartVo>();
	private int totalMoney=0;
	private String address;
	private ConsumeRecord consumeRecord;
	private ArrayList<consumeDetailVo> consumeDetail=new ArrayList<consumeDetailVo>();
	private String sendDate;
	private String productImage;
	private List<product> hotProductList;
	private List<product> collectProductList;
	private List<showProductNameVo> consumeNameList;
	
	//会员信息模块
	private long cardNum;
	private String name;
	private int balance;
	private String phoneNum;
	private List<ConsumeRecord> consumeRecordList;
	private int consumeId;
	private List<ConsumeDetail> consumeDetailList;
	private String cardState;
	private long points;
	private String cardGrade;
	private int payment;
	private int changePoints;
	private String bankAccount;
	private List<RechargeRecord> rechargeList;
	private String birthday;
	private String memberAddress;
	private String gender;
	
	//显示主界面
	public String showMemberMain(){
		setProductList(productService.getAllProduct());
		setHotProductList(productService.getAllProduct().subList(0, 3));
		setCollectProductList(productService.getAllProduct().subList(2, 5));
		//System.out.println(productList.get(0).getImageSrc());
		return loginResult;
	}
	public String showMemberCollection(){
		return SUCCESS;
	}
	//验证登录
	public String memberLogin(){	
		//memberService.updateMemberStatus(cardNum);
		memberInfo info=new memberInfo();
		info=memberService.confirmLogin(loginName, loginPassword);
		if(info!=null){
			setLoginResult("success");
			setCardNum(info.getCardNum());
			setName(info.getName());
			setBalance(info.getBalance());
			setPhoneNum(info.getPhoneNum());
			setCardState(info.getCardState());
			setCardGrade(info.getCardGrade());
			setPoints(info.getPoints());
			setMemberAddress(info.getAddress());
			setBirthday(info.getBirthday());	
		}
		else{
			setLoginResult("fail");
		}
		return null;	
	}
	//注册
	public String memberRegister(){
		if(memberService.isRepeated(registerPhoneNum).equals("YES")){
			setRegisterResult("fail");
		}
		else{
			memberService.registerInfo(registerPhoneNum, registerPassword, registerName);
			setRegisterResult("success");
		}	
		System.out.println(registerResult+"注册结果");
		return null;
	}
	/* 产品模块 */
	//加入收藏
	public String addToCollection(){
		
		return null;	
	}
	
	//加入购物车
	public String addToCart(){

		String result="";
		System.out.println(cart.size());
		if(cart.size()!=0){
		for(int i=0;i<cart.size();i++){
			if(cart.get(i).getProductId()==productId){
				int temp=cart.get(i).getQuantity();
				temp=temp+quantity;
				cart.get(i).setQuantity(temp);
				result="repeat";
			}
		}
		}
		
		if(!result.equals("repeat")){
			CartVo vo=new CartVo();
			vo.setPrice(productPrice);
			vo.setProductId(productId);
			vo.setQuantity(quantity);	
			vo.setProductName(productName);
			cart.add(vo);
		}

		System.out.println(cart.size()+"购物车数量");
		return null;	
	}
	//显示产品详情
	public String showProductDetail(){
			return SUCCESS;	
	}
	//查找产品详情
	public String productDetail(){
		setInfo(productService.getProductInfo(productId));
		setProductName(info.getProductName());
		setProductInfo(info.getProductInfo());
		setProductPrice(info.getProductPrice());
		setProductImage(info.getImageSrc());
		
		System.out.println("success");
		return null;	
	}
	//进入购物车
	public String showCart(){
		setTotalMoney(0);
		for(int i=0;i<cart.size();i++){
			int temp=cart.get(i).getPrice()*cart.get(i).getQuantity();
			cart.get(i).setTotalPrice(temp);
			setTotalMoney(totalMoney+temp);
		}
		return SUCCESS;		
	}
	//从购物车中删除产品
	public String cartDelete(){
		for(int i=0;i<cart.size();i++){
			if(cart.get(i).getProductId()==productId){
				cart.remove(i);
				break;
			}
		}
		return null;
	}
	//提交订单
	public String orderSubmit(){
		consumeDetailVo detailVo=new consumeDetailVo();	
		for(int i=0;i<cart.size();i++){
			detailVo.setGoodsId(cart.get(i).getProductId());
			detailVo.setQuantity(cart.get(i).getQuantity());
			consumeDetail.add(detailVo);	
		}	
		//将订单（消费记录）存入数据库
		String today=getTodayTime();
		long temp=staffService.addConsumeRecord(cardNum, "会员卡", totalMoney, 0, today);
		//将订单详情存入数据库
		staffService.addConsumeDetail(temp, today, 0, consumeDetail);
		//更新balance
		setBalance(balance-totalMoney);
		memberService.updateCardBalance(cardNum, balance);
		//更新积分
		points=points+totalMoney/10;
		memberService.updateCardPoints(cardNum, points);
		return null;
	}
		
	/* 会员模块 */
	//查看消费记录
	public String memberConsumeRecord(){
		setConsumeRecordList(memberService.getMemberConsume(cardNum));
		return SUCCESS;	
	}
	//查看消费记录详情
	public String consumeRecordDetail(){
		setConsumeDetailList(staffService.getConsumeDetail(consumeId));
		return null;
	}
	//显示销售记录详情界面
	public String showConsumeRecordDetail(){
		setConsumeNameList(staffService.getShowConsumeDetailList(consumeDetailList));
		//System.out.println(consumeNameList.size()+"董宁宁是傻逼");
		return SUCCESS;
	}	
	//显示注册信息
	public String showConsumeRegisterInfo(){
		return SUCCESS;
	}
	//注销会员信息
	public String destroyMemberInfo(){
		memberService.DestroyMemberInfo(cardNum);
		return SUCCESS;
	}
	//显示会员卡信息
	public String showCardInfo(){
		return SUCCESS;
	}
	//会员卡充值
	public String memberPay(){
		setBalance(balance+payment);
		memberService.updateCardBalance(cardNum, balance);	
		//会员卡状态写入数据库
		memberService.updateCardState(cardNum, "已激活");
		setCardState("已激活");
		//充值记录写入数据库
		memberService.insertRechargeRecord(cardNum, payment, getTodayTime(), bankAccount);
		return null;
	}
	//显示充值界面
	public String showMemberPay(){	
		return SUCCESS;
	}
	public String showMemberCardActive(){
		return SUCCESS;
	}
	//显示积分兑换界面
	public String showMemberPoints(){
		return SUCCESS;
	}
	//积分兑换
	public String memberPoints(){
		int temp=changePoints/10;
		balance=balance+temp;
		memberService.updateCardBalance(cardNum, balance);	
		points=points-changePoints;
		memberService.updateCardPoints(cardNum, points);
		return null;
	}
	//查看充值记录
	public String showMemberRecharge(){
		setRechargeList(memberService.getRechargeRecord(cardNum));
		return SUCCESS;
	}
	//修改个人信息界面
	public String showMemberInfo(){
		return SUCCESS;
	}
	//修改个人密码界面
	public String showMemberPassword(){
		return SUCCESS;
	}
	//修改个人信息
	public String updateMemberInfo(){
		memberService.updateMemberInfo(cardNum, memberAddress, birthday, gender);
		return null;
	}
	//修改用户密码
	public String updateMemberPassword(){
		memberService.updateMemberPassword(cardNum, loginPassword);
		return null;		
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
	
	

	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getRegisterPhoneNum() {
		return registerPhoneNum;
	}
	public void setRegisterPhoneNum(String registerPhoneNum) {
		this.registerPhoneNum = registerPhoneNum;
	}
	public String getRegisterPassword() {
		return registerPassword;
	}
	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}
	public String getRegisterResult() {
		return registerResult;
	}
	public void setRegisterResult(String registerResult) {
		this.registerResult = registerResult;
	}
	public List<product> getProductList() {
		return productList;
	}
	public void setProductList(List<product> productList) {
		this.productList = productList;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public product getInfo() {
		return info;
	}
	public void setInfo(product info) {
		this.info = info;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ArrayList<CartVo> getCart() {
		return cart;
	}
	public void setCart(ArrayList<CartVo> cart) {
		this.cart = cart;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ConsumeRecord getConsumeRecord() {
		return consumeRecord;
	}
	public void setConsumeRecord(ConsumeRecord consumeRecord) {
		this.consumeRecord = consumeRecord;
	}
	public ArrayList<consumeDetailVo> getConsumeDetail() {
		return consumeDetail;
	}
	public void setConsumeDetail(ArrayList<consumeDetailVo> consumeDetail) {
		this.consumeDetail = consumeDetail;
	}
	public List<ConsumeRecord> getConsumeRecordList() {
		return consumeRecordList;
	}
	public void setConsumeRecordList(List<ConsumeRecord> consumeRecordList) {
		this.consumeRecordList = consumeRecordList;
	}
	public List<ConsumeDetail> getConsumeDetailList() {
		return consumeDetailList;
	}
	public void setConsumeDetailList(List<ConsumeDetail> consumeDetailList) {
		this.consumeDetailList = consumeDetailList;
	}
	public int getConsumeId() {
		return consumeId;
	}
	public void setConsumeId(int consumeId) {
		this.consumeId = consumeId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getCardState() {
		return cardState;
	}
	public void setCardState(String cardState) {
		this.cardState = cardState;
	}
	public String getCardGrade() {
		return cardGrade;
	}
	public void setCardGrade(String cardGrade) {
		this.cardGrade = cardGrade;
	}
	public long getPoints() {
		return points;
	}
	public void setPoints(long points) {
		this.points = points;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getChangePoints() {
		return changePoints;
	}
	public void setChangePoints(int changePoints) {
		this.changePoints = changePoints;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public List<RechargeRecord> getRechargeList() {
		return rechargeList;
	}
	public void setRechargeList(List<RechargeRecord> rechargeList) {
		this.rechargeList = rechargeList;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public List<product> getHotProductList() {
		return hotProductList;
	}
	public void setHotProductList(List<product> hotProductList) {
		this.hotProductList = hotProductList;
	}
	public List<product> getCollectProductList() {
		return collectProductList;
	}
	public void setCollectProductList(List<product> collectProductList) {
		this.collectProductList = collectProductList;
	}
	public List<showProductNameVo> getConsumeNameList() {
		return consumeNameList;
	}
	public void setConsumeNameList(List<showProductNameVo> list) {
		this.consumeNameList = list;
	}



}
