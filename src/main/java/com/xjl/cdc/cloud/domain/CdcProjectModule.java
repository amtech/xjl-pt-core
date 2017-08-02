package com.xjl.cdc.cloud.domain;

import com.xjl.pt.core.annotation.TableDB;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 终端项目模块
 * @author you.guess
 *
 */
@TableDB(name="xjl_cdc_project_module")
public class CdcProjectModule extends XJLDomain {
	//项目模块id
	private String moduleId;
	//项目模块名称
	private String moduleName;
	//项目模块URL
	private String moduleUrl;
	//项目模块状态
	private String moduleState;
	//关联项目id
	private String projectId;
	
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public String getModuleState() {
		return moduleState;
	}
	public void setModuleState(String moduleState) {
		this.moduleState = moduleState;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}
