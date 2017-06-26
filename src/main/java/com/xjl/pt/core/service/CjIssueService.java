package com.xjl.pt.core.service;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.CjIssue;
import com.xjl.pt.core.mapper.CjIssueMapper;
/**
 * 常见问题
 * @author ServiceCoderTools Arthur
 *
 */
@Service
public class CjIssueService extends XJLService {
	@Autowired
	private CjIssueMapper cjIssueMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cjIssueMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.cjIssueMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.cjIssueMapper.update(domain);
	}
	public List<CjIssue> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cjIssueMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
	
	public CjIssue queryById(String id){
		return null;
	}
}
