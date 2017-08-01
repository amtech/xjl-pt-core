package com.xjl.rcu.monitor.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* rcu错误日志表
* @author DomainCoderTools lilisheng
*
*/
@TableDB(name="xjl_rcu_error_log")
public class RcuErrorLog extends XJLDomain {
	//错误发生时间
	private String errorDate;
	//错误描述
	private String errorMessage;
	//错误代码
	private String errorCode;
	//设备代码
	private String deviceCode;
	//设备代码 对应的名称，非数据库字段
	private String deviceCode$name;
	//终端id
	private String terminalId;
	//rcu本身的id
	private String rcuId;
	//错误id
	private String errorId;
	public void setErrorDate(String errorDate){
		this.errorDate = errorDate;
	}
	public String getErrorDate(){
		return this.errorDate;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage(){
		return this.errorMessage;
	}
	public void setErrorCode(String errorCode){
		this.errorCode = errorCode;
	}
	public String getErrorCode(){
		return this.errorCode;
	}
	public void setDeviceCode(String deviceCode){
		this.deviceCode = deviceCode;
	}
	public String getDeviceCode(){
		return this.deviceCode;
	}
	public void setDeviceCode$name(String deviceCode$name){
		this.deviceCode$name = deviceCode$name;
	}
	public String getDeviceCode$name(){
		return this.deviceCode$name;
	}
	public void setTerminalId(String terminalId){
		this.terminalId = terminalId;
	}
	public String getTerminalId(){
		return this.terminalId;
	}
	public void setRcuId(String rcuId){
		this.rcuId = rcuId;
	}
	public String getRcuId(){
		return this.rcuId;
	}
	public void setErrorId(String errorId){
		this.errorId = errorId;
	}
	public String getErrorId(){
		return this.errorId;
	}
}
