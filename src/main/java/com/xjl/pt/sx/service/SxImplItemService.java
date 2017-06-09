package com.xjl.pt.sx.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.sx.domain.SxImplItem;
import com.xjl.pt.sx.mapper.SxImplItemMapper;

/**
 * 实施清单
 * @author ServiceCoderTools lilisheng
 *
 */
@Service
public class SxImplItemService extends XJLService {
	@Autowired
	private SxImplItemMapper sxImplItemMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.sxImplItemMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.sxImplItemMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.sxImplItemMapper.update(domain);
	}
	public List<SxImplItem> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.sxImplItemMapper.selectAll();
		} else {
			PageHelper.startPage(page, pageSize);
			return this.sxImplItemMapper.selectBySearch(search);
		}
	}
	public SxImplItem queryById(String itemId) {
		return this.sxImplItemMapper.selectById(itemId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((SxImplItem)domain).setItemId(UUID.randomUUID().toString());
	}
}
