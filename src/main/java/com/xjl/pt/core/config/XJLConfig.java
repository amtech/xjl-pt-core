package com.xjl.pt.core.config;
/**
 * 系统配置工具，类似于全局变量
 * @author lilisheng
 *
 */
public class XJLConfig {
	/**
	 * 一个应用一个org，也即是支持saas多租户，每一个租户单独不用一套应用（公用一套数据库）
	 */
	private String orgId;
	private String orgName;
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
}
