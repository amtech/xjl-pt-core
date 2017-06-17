package com.xjl.pt.core.domain;

import java.util.Date;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 证照信息实体类
 * @author guan.zheyuan
 */
@TableDB(name="xjl_zz_licence")
public class Licence extends XJLDomain {

	/**
	 * 证照编号
	 */
	private String licenceId;
	/**
	 * 证照名称
	 */
	private String licenceName;
	/**
	 * 证照分类
	 */
	private String licenceCategory;
	/**
	 * 证照所在地
	 */
	private String licenceOrg;
	/**
	 * 证照开始时间
	 */
	private Date issuingDate;
	/**
	 * 证照结束时间
	 */
	private Date expirationDate;
	/**
	 * 证照状态
	 */
	private String licenceStatus;
	/**
	 * 证照状态 对应名称 非数据库字段
	 */
	private String licenceStatus$name;
	/**
	 * 拥有人编号
	 */
	private String  ownerOn;
	/**
	 * 拥有人类型
	 */
	private String ownerType;
	/**
	 * 证照来源
	 */
	private String licenceSourceType;
	/**
	 * 证照来源 对应名称 非数据库字段
	 */
	private String licenceSourceType$name;
	/**
	 * 可信度级别
	 */
	private String licenceTrustLevel;
	
	/**
	 * 证照存储路径
	 */
	private String licenceFileUrl;
	/**
	 * 证照文件类型
	 */
	private String licenceFileType;
	/**
	 * 字典值数量,不是数据库中的属性
	 */
	private int licenceItemCount;
	public String getLicenceId() {
		return licenceId;
	}
	public void setLicenceId(String licenceId) {
		this.licenceId = licenceId;
	}
	public String getLicenceName() {
		return licenceName;
	}
	public void setLicenceName(String licenceName) {
		this.licenceName = licenceName;
	}
	public String getLicenceCategory() {
		return licenceCategory;
	}
	public void setLicenceCategory(String licenceCategory) {
		this.licenceCategory = licenceCategory;
	}
	public String getLicenceOrg() {
		return licenceOrg;
	}
	public void setLicenceOrg(String licenceOrg) {
		this.licenceOrg = licenceOrg;
	}
	public Date getIssuingDate() {
		return issuingDate;
	}
	public void setIssuingDate(Date issuingDate) {
		this.issuingDate = issuingDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getLicenceStatus() {
		return licenceStatus;
	}
	public void setLicenceStatus(String licenceStatus) {
		this.licenceStatus = licenceStatus;
	}
	public String getOwnerOn() {
		return ownerOn;
	}
	public void setOwnerOn(String ownerOn) {
		this.ownerOn = ownerOn;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getLicenceSourceType() {
		return licenceSourceType;
	}
	public void setLicenceSourceType(String licenceSourceType) {
		this.licenceSourceType = licenceSourceType;
	}
	public String getLicenceTrustLevel() {
		return licenceTrustLevel;
	}
	public void setLicenceTrustLevel(String licenceTrustLevel) {
		this.licenceTrustLevel = licenceTrustLevel;
	}
	public int getLicenceItemCount() {
		return licenceItemCount;
	}
	public void setLicenceItemCount(int licenceItemCount) {
		this.licenceItemCount = licenceItemCount;
	}
	public String getLicenceFileUrl() {
		return licenceFileUrl;
	}
	public void setLicenceFileUrl(String licenceFileUrl) {
		this.licenceFileUrl = licenceFileUrl;
	}
	public String getLicenceFileType() {
		return licenceFileType;
	}
	public void setLicenceFileType(String licenceFileType) {
		this.licenceFileType = licenceFileType;
	}
	public String getLicenceStatus$name() {
		return licenceStatus$name;
	}
	public void setLicenceStatus$name(String licenceStatus$name) {
		this.licenceStatus$name = licenceStatus$name;
	}
	public String getLicenceSourceType$name() {
		return licenceSourceType$name;
	}
	public void setLicenceSourceType$name(String licenceSourceType$name) {
		this.licenceSourceType$name = licenceSourceType$name;
	}
}
