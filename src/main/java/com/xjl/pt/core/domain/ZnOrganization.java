package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.TableDB;
/**
* 办事指南实施机构
* @author DomainCoderTools Arthur
*
*/
@TableDB(name="xjl_zn_organization")
public class ZnOrganization extends XJLDomain {
	//办事指南编号
	private String organizationId;
	//实施机构
	private String implOrg;
	//非数据库字段,用于翻译实施机构
	private String implOrg$name;
	//非数据库字段,用于统计
	private Integer znOrganizationItemCount;
	 
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public void setImplOrg(String implOrg){
		this.implOrg = implOrg;
	}
	public String getImplOrg(){
		return this.implOrg;
	}
	public String getImplOrg$name() {
		return implOrg$name;
	}
	public void setImplOrg$name(String implOrg$name) {
		this.implOrg$name = implOrg$name;
	}
	public Integer getZnOrganizationItemCount() {
		return znOrganizationItemCount;
	}
	public void setZnOrganizationItemCount(Integer znOrganizationItemCount) {
		this.znOrganizationItemCount = znOrganizationItemCount;
	}
}
