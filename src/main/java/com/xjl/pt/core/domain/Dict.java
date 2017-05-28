package com.xjl.pt.core.domain;
/**
 * 字典
 * @author li.lisheng
 *
 */
public class Dict extends XJLDomain {
	private String dictId;
	private String dictName;
	//字典值的数量，这个不是数据库中的属性，需要单独赋值和获取
	private int dictItemCount;
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public int getDictItemCount() {
		return dictItemCount;
	}
	public void setDictItemCount(int dictItemCount) {
		this.dictItemCount = dictItemCount;
	}
	
	
	
}
