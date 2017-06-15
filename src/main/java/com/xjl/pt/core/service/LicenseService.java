package com.xjl.pt.core.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.domain.License;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.LicenseMapper;

/**
 * 证照数据持久层
 * @author guan.zheyuan
 *
 */
@Service
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
	public List<License> query(String search,int page,int pageSize){
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.licenseMapper.selectAll();
		}else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	};
	
	/**
	 * 通过证照编号得到数量
	 */
	public int  countByLicense(String licenseId){
		return this.licenseMapper.selectCountByLicenseid(licenseId);
	}
}