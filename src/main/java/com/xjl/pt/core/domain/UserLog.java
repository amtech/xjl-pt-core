package com.xjl.pt.core.domain;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 用户日志信息
 * @author guan.zheyuan
 */
@TableDB(name="xjl_pt_user_log")
public class UserLog  extends XJLDomain {

	/**
	 * ip
	 */
	private String ip;
	/**
	 * 所属城市
	 */
	private String city;
	/**
	 *用户编号
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 访问地址
	 */
	private String url;
	/**
	 * 日志状态
	 */
	private String state;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
