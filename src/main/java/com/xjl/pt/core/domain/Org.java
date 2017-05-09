package com.xjl.pt.core.domain;
/**
 * 机构id，可以用户多租户管理
 * @author li.lisheng
 *
 */
public class Org extends XJLDomain{
	private String orgName;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
