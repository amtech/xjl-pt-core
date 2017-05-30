package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.Dept;
import com.xjl.pt.core.mapper.DeptMapper;

/**
 * 字典
 * @author ServiceCoderTools
 *
 */
@Service
public class DeptService extends XJLService {
	@Autowired
	private DeptMapper deptmapper;
	@Override
	public void _add(XJLDomain domain) {
		this.deptmapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.deptmapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.deptmapper.update(domain);
	}
	public List<Dept> query(int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return this.deptmapper.selectAll();
	}
	public Dept queryById(String deptId) {
		return this.deptmapper.selectById(deptId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((Dept)domain).setDeptId(UUID.randomUUID().toString());
	}
}
