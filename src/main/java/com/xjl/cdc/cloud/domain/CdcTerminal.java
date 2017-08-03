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
	//终端状态，1出厂检测成功，2主页设置成功
	private String terminalState;
	//终端url
	private String terminalUrl;
	//终端类型
	private String terminalType;
	//终端类型 对应的名称，非数据库字段
	private String terminalType$name;
	//对应的项目模块id
	private String moduleId;
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
	public String getTerminalState() {
		return terminalState;
	}
	public void setTerminalState(String terminalState) {
		this.terminalState = terminalState;
	}
	public String getTerminalUrl() {
		return terminalUrl;
	}
	public void setTerminalUrl(String terminalUrl) {
		this.terminalUrl = terminalUrl;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
}

