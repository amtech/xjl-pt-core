package com.xjl.cdc.cloud.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 云检测中心终端
* @author DomainCoderTools lilisheng
*
*/
@TableDB(name="xjl_cdc_terminal")
public class CdcTerminal extends XJLDomain {
	//终端id
	private String terminalId;
	//终端唯一标示
	private String terminalGuid;
	//终端类型
	private String terminalType;
	//终端类型 对应的名称，非数据库字段
	private String terminalType$name;
	public void setTerminalId(String terminalId){
		this.terminalId = terminalId;
	}
	public String getTerminalId(){
		return this.terminalId;
	}
	public void setTerminalGuid(String terminalGuid){
		this.terminalGuid = terminalGuid;
	}
	public String getTerminalGuid(){
		return this.terminalGuid;
	}
	public void setTerminalType(String terminalType){
		this.terminalType = terminalType;
	}
	public String getTerminalType(){
		return this.terminalType;
	}
	public void setTerminalType$name(String terminalType$name){
		this.terminalType$name = terminalType$name;
	}
	public String getTerminalType$name(){
		return this.terminalType$name;
	}
}
