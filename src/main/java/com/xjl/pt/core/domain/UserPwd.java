package com.xjl.pt.core.domain;
/**
 * �û�������Ϣ
 * @author guan.zheyuan
 */
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
