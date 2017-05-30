package com.xjl.pt.core.domain;

import java.util.Date;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 数据日志表
 * @author lilisheng
 *
 */
@TableDB(name="xjl_pt_data_log")
public class DataLog extends XJLDomain {
	private String tableName;
	private String masterValue;
	private String dataJson;
	private String operateUserId;
	private Date operateDate;
	private String operateType;
	public static final String OPERATE_TYPE_ADD = "A";
	public static final String OPERATE_TYPE_MODIFY = "M";
	public static final String OPERATE_TYPE_DELETE = "D";
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getMasterValue() {
		return masterValue;
	}
	public void setMasterValue(String masterValue) {
		this.masterValue = masterValue;
	}
	public String getDataJson() {
		return dataJson;
	}
	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}
	public String getOperateUserId() {
		return operateUserId;
	}
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
}
