package com.xjl.pt.core.domain;
/**
 * 字典值
 * @author li.lisheng
 *
 */
public class DictValue extends XJLDomain{
	private String dictId;
	private String dictValueCode;
	private String dictValueName;
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getDictValueCode() {
		return dictValueCode;
	}
	public void setDictValueCode(String dictValueCode) {
		this.dictValueCode = dictValueCode;
	}
	public String getDictValueName() {
		return dictValueName;
	}
	public void setDictValueName(String dictValueName) {
		this.dictValueName = dictValueName;
	}
	
}
