package com.xjl.pt.core.domain;

/**
 * �û�������Ϣ
 * @author guan.zheyuan
 *
 */
public class UserInfo extends XJLDomain {
	
	
	private String userId;
	private String userName;
	private String phoneNo;
	private String cardNo;
	/**
	 * �ֳ����֤��Ƭ
	 */
	private String headShot;
	/**
	 * ���֤������Ƭ
	 */
	private String handCardPhoto;
	/**
	 * ���֤������Ƭ
	 */
	private String handCardBackPhoto;
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
	public String getHeadShot() {
		return headShot;
	}
	public void setHeadShot(String headShot) {
		this.headShot = headShot;
	}
	public String getHandCardPhoto() {
		return handCardPhoto;
	}
	public void setHandCardPhoto(String handCardPhoto) {
		this.handCardPhoto = handCardPhoto;
	}
	public String getHandCardBackPhoto() {
		return handCardBackPhoto;
	}
	public void setHandCardBackPhoto(String handCardBackPhoto) {
		this.handCardBackPhoto = handCardBackPhoto;
	}
}
