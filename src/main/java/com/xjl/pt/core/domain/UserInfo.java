package com.xjl.pt.core.domain;

/**
 * 用户基本信息
 * @author guan.zheyuan
 *
 */
public class UserInfo extends XJLDomain {
	
	
	private String userId;
	private String userName;
	private String phoneNo;
	private String cardNo;
	/**
	 * 手持身份证照片
	 */
	private String handShot;
	/**
	 * 身份证正面照片
	 */
	private String cardPhoto;
	/**
	 * 身份证背面照片
	 */
	private String cardBackPhoto;
	
	public String getHandShot() {
		return handShot;
	}
	public void setHandShot(String handShot) {
		this.handShot = handShot;
	}
	public String getCardPhoto() {
		return cardPhoto;
	}
	public void setCardPhoto(String cardPhoto) {
		this.cardPhoto = cardPhoto;
	}
	public String getCardBackPhoto() {
		return cardBackPhoto;
	}
	public void setCardBackPhoto(String cardBackPhoto) {
		this.cardBackPhoto = cardBackPhoto;
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
