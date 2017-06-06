package com.xjl.pt.core.domain;

import java.util.Date;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 用户信息实体类
 * @author guan.zheyuan
 *
 */
@TableDB(name="xjl_pt_user_info")
public class UserInfo extends XJLDomain {
	
	
	/**
	 * 用户编号
	 */
	private String userId;
	
	private String _userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 手机号码
	 */
	private String phoneNo;
	/**
	 * 身份证好嘛
	 */
	private String cardNo;
	/**
	 * 身份证姓名
	 */
	private String cardName;
	/**
	 * 认证状态1:未认证，2已认证
	 */
	private String authState;
	/**
	 * 认证时间
	 */
	private Date authDate;
	/**
	 * 认证用户编号
	 */
	private String authUserId;
	/**
	 * 认证渠道:1窗口，2自助终端，3网上，4手机app，5关联
	 */
	private  String authChannelType;
	/**
	 * 认证渠道名称
	 */
	private String authChannelName;
	/**
	 * 头像照片地址
	 */
	private String handShotPhotoUrl;
	/**
	 * 手持身份证正面照片
	 */
	private String handCardPhotoUrl;
	/**
	 * 身份证背面照片地址
	 */
	private String cardBackPhotoUrl;
	/**
	 * 身份证正面照片地址
	 */
	private String cardFrontPhotoUrl;
	 
	 
	public String get_userId() {
		return _userId;
	}
	public void set_userId(String _userId) {
		this._userId = _userId;
	}
	public String getAuthState() {
		return authState;
	}
	public void setAuthState(String authState) {
		this.authState = authState;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Date getAuthDate() {
		return authDate;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}
	public String getAuthUserId() {
		return authUserId;
	}
	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}
	public String getAuthChannelType() {
		return authChannelType;
	}
	public void setAuthChannelType(String authChannelType) {
		this.authChannelType = authChannelType;
	}
	public String getAuthChannelName() {
		return authChannelName;
	}
	public void setAuthChannelName(String authChannelName) {
		this.authChannelName = authChannelName;
	}
	public String getHandShotPhotoUrl() {
		return handShotPhotoUrl;
	}
	public void setHandShotPhotoUrl(String handShotPhotoUrl) {
		this.handShotPhotoUrl = handShotPhotoUrl;
	}
	public String getHandCardPhotoUrl() {
		return handCardPhotoUrl;
	}
	public void setHandCardPhotoUrl(String handCardPhotoUrl) {
		this.handCardPhotoUrl = handCardPhotoUrl;
	}
	public String getCardBackPhotoUrl() {
		return cardBackPhotoUrl;
	}
	public void setCardBackPhotoUrl(String cardBackPhotoUrl) {
		this.cardBackPhotoUrl = cardBackPhotoUrl;
	}
	public String getCardFrontPhotoUrl() {
		return cardFrontPhotoUrl;
	}
	public void setCardFrontPhotoUrl(String cardFrontPhotoUrl) {
		this.cardFrontPhotoUrl = cardFrontPhotoUrl;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
