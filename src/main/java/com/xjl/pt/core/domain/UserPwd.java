package com.xjl.pt.core.domain;

import com.xjl.pt.core.annotation.TableDB;

/**
 * @author guan.zheyuan
 */
@TableDB(name="xjl_pt_user_password")
public class UserPwd extends XJLDomain {

	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
