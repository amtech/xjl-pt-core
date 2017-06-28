package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 历史办件
* @author DomainCoderTools 陶杰
*
*/
@TableDB(name="xjl_bj_history_piece")
public class BjHistoryPiece extends XJLDomain {
	//办件状态
	private String managementStatus;
	//办件状态 对应名称(非数据库字段)
	private String managementStatus$name;
	//申请人类型
	private String ownerType;
	//申请人
	private String ownerOn;
	//结束时间
	private String endTime;
	//申报时间
	private String reportingTime;
	//办理进度
	private String processProgress;
	//办理部门
	private String managementDept;
	//事项名称
	private String matteName;
	//办件编号
	private String pieceId;
	public void setManagementStatus(String managementStatus){
		this.managementStatus = managementStatus;
	}
	public String getManagementStatus(){
		return this.managementStatus;
	}
	public void setOwnerType(String ownerType){
		this.ownerType = ownerType;
	}
	public String getOwnerType(){
		return this.ownerType;
	}
	public void setOwnerOn(String ownerOn){
		this.ownerOn = ownerOn;
	}
	public String getOwnerOn(){
		return this.ownerOn;
	}
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	public String getEndTime(){
		return this.endTime;
	}
	public void setReportingTime(String reportingTime){
		this.reportingTime = reportingTime;
	}
	public String getReportingTime(){
		return this.reportingTime;
	}
	public void setProcessProgress(String processProgress){
		this.processProgress = processProgress;
	}
	public String getProcessProgress(){
		return this.processProgress;
	}
	public void setManagementDept(String managementDept){
		this.managementDept = managementDept;
	}
	public String getManagementDept(){
		return this.managementDept;
	}
	public void setMatteName(String matteName){
		this.matteName = matteName;
	}
	public String getMatteName(){
		return this.matteName;
	}
	public void setPieceId(String pieceId){
		this.pieceId = pieceId;
	}
	public String getPieceId(){
		return this.pieceId;
	}
	public String getManagementStatus$name() {
		return managementStatus$name;
	}
	public void setManagementStatus$name(String managementStatus$name) {
		this.managementStatus$name = managementStatus$name;
	}
	
}
