package com.xjl.cdc.cloud.domain;

import com.xjl.pt.core.annotation.TableDB;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 终端项目
 * @author you.guess
 *
 */
@TableDB(name="xjl_cdc_project")
public class CdcProject extends XJLDomain {
	//项目id
	private String projectId;
	//项目名称
	private String projectName;
	//项目状态
	private String projectState;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectState() {
		return projectState;
	}
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}
	
}
