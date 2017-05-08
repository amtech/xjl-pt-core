package com.xjl.pt.core.domain;
/**
 * 机构id，可以用户多租户管理
 * @author leasonlive
 *
 */
public class Org {
	private String org;
	private String orgName;
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
}
