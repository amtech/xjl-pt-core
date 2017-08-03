package com.xjl.cdc.cloud.domain;

import java.util.Date;

import com.xjl.pt.core.annotation.TableDB;
import com.xjl.pt.core.domain.XJLDomain;

/**
* 云检测中心终端日志
* @author you.guess
*
*/
@TableDB(name="xjl_cdc_terminal_log")
public class CdcTerminalLog extends XJLDomain {
	// 日志流水id
	private String logId;
	// 终端id
	private String terminalId;
	// 终端唯一标识
	private String terminalGuid;
	// 操作类型（1/2/3）
	private String operateType;
	// 操作描述（出厂检测/主页设置/正常运行）
	private String operateDesc;
	// 操作时间
	private Date operateDate;
	// 终端访问IP
	private String ip;
	// 终端访问位置
	private String location;
	// 终端访问位置经度
	private String lng;
	// 终端访问位置纬度
	private String lat;
	// 省
	private String province;
	// 市
	private String city;
	// 县
	private String country;
	// 乡
	private String town;
	// 村
	private String village;
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getTerminalGuid() {
		return terminalGuid;
	}
	public void setTerminalGuid(String terminalGuid) {
		this.terminalGuid = terminalGuid;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getOperateDesc() {
		return operateDesc;
	}
	public void setOperateDesc(String operateDesc) {
		this.operateDesc = operateDesc;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	
}
