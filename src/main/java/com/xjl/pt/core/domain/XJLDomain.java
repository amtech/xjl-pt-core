package com.xjl.pt.core.domain;

import java.util.Date;
/**
 * 平台用到的7个字段
 * @author li.lisheng
 *
 */
public class XJLDomain {
	private String org;
	private String master;
	private Date createDate;
	private String createUserId;
	private Date cancelDate;
	private String cancelUserId;
	private String state;
	public static enum StateType {A,X};
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelUserId() {
		return cancelUserId;
	}
	public void setCancelUserId(String cancelUserId) {
		this.cancelUserId = cancelUserId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	};
	public static  final String insertFieldName(){
		return "";
	}
	
}
