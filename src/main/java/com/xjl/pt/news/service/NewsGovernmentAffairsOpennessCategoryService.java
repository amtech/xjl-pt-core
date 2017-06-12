package com.xjl.pt.news.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.news.domain.NewsGovernmentAffairsOpennessCategory;
import com.xjl.pt.news.mapper.NewsGovernmentAffairsOpennessCategoryMapper;

/**
 * 政务公开类别
 * @author ServiceCoderTools lilisheng
 *
 */
@Service
public class NewsGovernmentAffairsOpennessCategoryService extends XJLService {
	@Autowired
	private NewsGovernmentAffairsOpennessCategoryMapper newsGovernmentAffairsOpennessCategoryMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.newsGovernmentAffairsOpennessCategoryMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.newsGovernmentAffairsOpennessCategoryMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.newsGovernmentAffairsOpennessCategoryMapper.update(domain);
	}
	public List<NewsGovernmentAffairsOpennessCategory> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.newsGovernmentAffairsOpennessCategoryMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public NewsGovernmentAffairsOpennessCategory queryById(String categoryId) {
		return this.newsGovernmentAffairsOpennessCategoryMapper.selectById(categoryId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((NewsGovernmentAffairsOpennessCategory)domain).setCategoryId(UUID.randomUUID().toString());
	}
}
