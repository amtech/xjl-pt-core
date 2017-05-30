package com.xjl.pt.core.domain;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 业务表定义
 * @author lilisheng
 *
 */
@TableDB(name="xjl_pt_table")
public class Table extends XJLDomain{
	private String tableId;
	private String tableName;
	private String tableDesc;
	//这个字段不是数据库字段
	private int tableFieldCount;
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableDesc() {
		return tableDesc;
	}
	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}
	public int getTableFieldCount() {
		return tableFieldCount;
	}
	public void setTableFieldCount(int tableFieldCount) {
		this.tableFieldCount = tableFieldCount;
	}
	
}
