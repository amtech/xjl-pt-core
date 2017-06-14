package com.xjl.pt.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.domain.License;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.LicenseMapper;

/**
 * 证照数据持久层
 * @author guan.zheyuan
 *
 */
public class LicenseService extends XJLService {
	@Autowired
	private LicenseMapper licenseMapper;

	@Override
	public void _add(XJLDomain domain) {
	}
	@Override
	public void _delete(XJLDomain domain) {
	}
	@Override
	public void _modify(XJLDomain domain) {
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
	/**
	 * 查询证照
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<License> query(int page,int pageSize){
		PageHelper.startPage(page, pageSize);
		return this.licenseMapper.selectAll();
	};
}