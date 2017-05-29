package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import java.util.Date;
/**
* 部门表
* @author DomainCoderTools
*
*/
public class Dept extends XJLDomain {
	//部门名称
	private String deptName;
	//部门id
	private String deptId;
	//上级部门id
	private String parentDeptId;
	//上级部门id 对应的名称，非数据库字段
	private String parentDeptId$name;
	public void setDeptName(String deptName){
		this.deptName = deptName;
	}
	public String getDeptName(){
		return this.deptName;
	}
	public void setDeptId(String deptId){
		this.deptId = deptId;
	}
	public String getDeptId(){
		return this.deptId;
	}
	public void setParentDeptId(String parentDeptId){
		this.parentDeptId = parentDeptId;
	}
	public String getParentDeptId(){
		return this.parentDeptId;
	}
	public void setParentDeptId$name(String parentDeptId$name){
		this.parentDeptId$name = parentDeptId$name;
	}
	public String getParentDeptId$name(){
		return this.parentDeptId$name;
	}
}
