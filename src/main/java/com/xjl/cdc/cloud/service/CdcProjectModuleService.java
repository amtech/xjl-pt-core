package com.xjl.cdc.cloud.service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.cdc.cloud.domain.CdcProjectModule;
import com.xjl.cdc.cloud.mapper.CdcProjectModuleMapper;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.service.XJLService;

@Service
public class CdcProjectModuleService extends XJLService {
	@Autowired
	private CdcProjectModuleMapper cdcProjectModuleMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cdcProjectModuleMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.cdcProjectModuleMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.cdcProjectModuleMapper.update(domain);
	}
	public void deleteByProjectId(XJLDomain domain,User user) {
		domain.setCancelDate(Calendar.getInstance().getTime());
		domain.setCancelUserId(user.getUserId());
		domain.setState(XJLDomain.StateType.X.name());
		this.cdcProjectModuleMapper.deleteByProjectId(domain);
	}
	public List<CdcProjectModule> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cdcProjectModuleMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public CdcProjectModule queryById(String moduleId) {
		return this.cdcProjectModuleMapper.selectById(moduleId);
	}
	public int queryByProjectId(String projectId){
		return this.cdcProjectModuleMapper.selectByProjectId(projectId);
	}
	public List<CdcProjectModule> queryProjectModuleByProjectId(String projectId){
		return this.cdcProjectModuleMapper.selectProjectModuleByProjectId(projectId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((CdcProjectModule)domain).setModuleId(UUID.randomUUID().toString());
	}
}
