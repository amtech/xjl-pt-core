package com.xjl.pt.core.domain;

import com.xjl.pt.core.annotation.TableDB;

@TableDB(name="xjl_pt_user")
public class User extends XJLDomain{
	private String userId;
	private String userName;
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
	
}
