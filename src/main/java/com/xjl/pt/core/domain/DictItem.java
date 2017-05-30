package com.xjl.pt.core.domain;

import com.xjl.pt.core.annotation.TableDB;

/**
 * 字典值
 * @author li.lisheng
 *
 */
@TableDB(name="xjl_pt_dict_item")
public class DictItem extends XJLDomain{
	private String dictId;
	private String dictItemId;
	private String dictItemCode;
	private String dictItemName;
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getDictItemId() {
		return dictItemId;
	}
	public void setDictItemId(String dictItemId) {
		this.dictItemId = dictItemId;
	}
	public String getDictItemCode() {
		return dictItemCode;
	}
	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}
	public String getDictItemName() {
		return dictItemName;
	}
	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}
	
	
}
