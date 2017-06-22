package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZzCatalog;
import com.xjl.pt.core.mapper.ZzCatalogMapper;

/**
 * 个人空间库证照目录
 * @author ServiceCoderTools 陶杰
 *
 */
@Service
public class ZzCatalogService extends XJLService {
	@Autowired
	private ZzCatalogMapper zzCatalogMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.zzCatalogMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.zzCatalogMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.zzCatalogMapper.update(domain);
	}
	public List<ZzCatalog> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.zzCatalogMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public ZzCatalog queryById(String catalogId) {
		return this.zzCatalogMapper.selectById(catalogId);
	}
	public List<ZzCatalog> queryByUserId(String userId){
		return this.zzCatalogMapper.selectByUserId(userId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
	/**
	 * 修改目录名称
	 * @param domain
	 */
	public void modifyCatalogName(XJLDomain domain){
		this.zzCatalogMapper.updateCatalogName(domain);
	}
}
