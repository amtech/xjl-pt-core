package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZnOrganization;
import com.xjl.pt.core.mapper.ZnOrganizationMapper;

/**
 * 办事指南实施机构
 * @author ServiceCoderTools Arthur
 *
 */
@Service
public class ZnOrganizationService extends XJLService {
	@Autowired
	private ZnOrganizationMapper znOrganizationMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.znOrganizationMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		//this.znOrganizationMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		//this.znOrganizationMapper.update(domain);
	}
	public List<ZnOrganization> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.znOrganizationMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public ZnOrganization queryById(String OrganizationId){
		return null;
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
}
