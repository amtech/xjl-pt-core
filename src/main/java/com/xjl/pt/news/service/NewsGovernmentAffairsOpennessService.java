package com.xjl.pt.news.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.news.domain.NewsGovernmentAffairsOpenness;
import com.xjl.pt.news.mapper.NewsGovernmentAffairsOpennessMapper;

/**
 * 政务公开内容
 * @author ServiceCoderTools lilisheng
 *
 */
@Service
public class NewsGovernmentAffairsOpennessService extends XJLService {
	@Autowired
	private NewsGovernmentAffairsOpennessMapper newsGovernmentAffairsOpennessMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.newsGovernmentAffairsOpennessMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.newsGovernmentAffairsOpennessMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.newsGovernmentAffairsOpennessMapper.update(domain);
	}
	public List<NewsGovernmentAffairsOpenness> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.newsGovernmentAffairsOpennessMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public NewsGovernmentAffairsOpenness queryById(String opennessId) {
		return this.newsGovernmentAffairsOpennessMapper.selectById(opennessId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((NewsGovernmentAffairsOpenness)domain).setOpennessId(UUID.randomUUID().toString());
	}
}
