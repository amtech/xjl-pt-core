package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.CdCreditItem;
import com.xjl.pt.core.mapper.CdCreditItemMapper;

/**
 * 征信条目
 * @author ServiceCoderTools Arthur
 *
 */
@Service
public class CdCreditItemService extends XJLService {
	@Autowired
	private CdCreditItemMapper cdCreditItemMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cdCreditItemMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.cdCreditItemMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.cdCreditItemMapper.update(domain);
	}
	public List<CdCreditItem> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cdCreditItemMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public CdCreditItem queryById(String creditItemId) {
		return this.cdCreditItemMapper.selectById(creditItemId);
	}
	public int queryByCreditId(String creditId){
		return this.cdCreditItemMapper.selectByCreditId(creditId);
	}
	public List<CdCreditItem> queryCreditItemByCreditId(String creditId){
		return this.cdCreditItemMapper.selectCreditItemByCreditId(creditId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((CdCreditItem)domain).setCreditItemId(UUID.randomUUID().toString());
	}
}
