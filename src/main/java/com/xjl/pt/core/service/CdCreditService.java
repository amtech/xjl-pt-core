package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.CdCredit;
import com.xjl.pt.core.mapper.CdCreditMapper;

/**
 * 征信库
 * @author ServiceCoderTools Arthur
 *
 */
@Service
public class CdCreditService extends XJLService {
	@Autowired
	private CdCreditMapper cdCreditMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cdCreditMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.cdCreditMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.cdCreditMapper.update(domain);
	}
	public List<CdCredit> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cdCreditMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public CdCredit queryById(String creditId) {
		return this.cdCreditMapper.selectById(creditId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((CdCredit)domain).setCreditId(UUID.randomUUID().toString());
	}
}
