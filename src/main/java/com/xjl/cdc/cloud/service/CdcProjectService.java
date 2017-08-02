package com.xjl.cdc.cloud.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.cdc.cloud.domain.CdcProject;
import com.xjl.cdc.cloud.mapper.CdcProjectMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.service.XJLService;

@Service
public class CdcProjectService extends XJLService {
	@Autowired
	private CdcProjectMapper cdcProjectMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cdcProjectMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.cdcProjectMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.cdcProjectMapper.update(domain);
	}
	public List<CdcProject> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cdcProjectMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public List<CdcProject> query(String search) {
		if (StringUtils.isEmpty(search)){
			return this.cdcProjectMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public CdcProject queryById(String projectId) {
		return this.cdcProjectMapper.selectById(projectId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((CdcProject)domain).setProjectId(UUID.randomUUID().toString());
	}
}
