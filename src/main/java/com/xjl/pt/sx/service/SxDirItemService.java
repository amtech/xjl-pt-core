package com.xjl.pt.sx.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.sx.domain.SxDirItem;
import com.xjl.pt.sx.mapper.SxDirItemMapper;

/**
 * 事项目录清单
 * @author ServiceCoderTools lilisheng
 *
 */
@Service
public class SxDirItemService extends XJLService {
	@Autowired
	private SxDirItemMapper sxDirItemMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.sxDirItemMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.sxDirItemMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.sxDirItemMapper.update(domain);
	}
	public List<SxDirItem> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.sxDirItemMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public SxDirItem queryById(String itemId) {
		return this.sxDirItemMapper.selectById(itemId);
	}
	public void deploy(String itemId, User user) {
		SxDirItem item = this.queryById(itemId);
		item.setItemState("2");
		this.modify(item, user);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((SxDirItem)domain).setItemId(UUID.randomUUID().toString());
	}
}
