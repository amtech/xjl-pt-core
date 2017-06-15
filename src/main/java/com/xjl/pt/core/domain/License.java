package com.xjl.pt.core.domain;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 证照信息实体类
 * @author guan.zheyuan
 */
@TableDB(name="xjl_zz_license")
public class License extends XJLDomain {

	/**
	 * 证照编号
	 */
	private String licenseId;
	/**
	 * 证照名称
	 */
	private String licenseName;
	/**
	 * 证照分类
	 */
	private String licenseCategory;
	/**
	 * 证照所在地
	 */
	private String licenseOrg;
	/**
	 * 证照开始时间
	 */
	private String issuingDate;
	/**
	 * 证照结束时间
	 */
	private String expirationDate;
	/**
	 * 证照状态
	 */
	private String licenseStatus;
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
	private String licenseSourceType;
	/**
	 * 可信度级别
	 */
	private String licenseTrustLevel;
	/**
	 * 证照存储路径
	 */
	private String licenseContentUrl;
	/**
	 * 字典值数量,不是数据库中的属性
	 */
	private int licenseItemCount;
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public String getLicenseCategory() {
		return licenseCategory;
	}
	public void setLicenseCategory(String licenseCategory) {
		this.licenseCategory = licenseCategory;
	}
	public String getLicenseOrg() {
		return licenseOrg;
	}
	public void setLicenseOrg(String licenseOrg) {
		this.licenseOrg = licenseOrg;
	}
	public String getIssuingDate() {
		return issuingDate;
	}
	public void setIssuingDate(String issuingDate) {
		this.issuingDate = issuingDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getLicenseStatus() {
		return licenseStatus;
	}
	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
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
	public String getLicenseSourceType() {
		return licenseSourceType;
	}
	public void setLicenseSourceType(String licenseSourceType) {
		this.licenseSourceType = licenseSourceType;
	}
	public String getLicenseTrustLevel() {
		return licenseTrustLevel;
	}
	public void setLicenseTrustLevel(String licenseTrustLevel) {
		this.licenseTrustLevel = licenseTrustLevel;
	}
	public String getLicenseContentUrl() {
		return licenseContentUrl;
	}
	public void setLicenseContentUrl(String licenseContentUrl) {
		this.licenseContentUrl = licenseContentUrl;
	}
	public int getLicenseItemCount() {
		return licenseItemCount;
	}
	public void setLicenseItemCount(int licenseItemCount) {
		this.licenseItemCount = licenseItemCount;
	}
}
