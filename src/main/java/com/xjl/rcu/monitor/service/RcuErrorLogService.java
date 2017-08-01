package com.xjl.rcu.monitor.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.rcu.monitor.domain.RcuErrorLog;
import com.xjl.rcu.monitor.mapper.RcuErrorLogMapper;

/**
 * rcu错误日志表
 * @author ServiceCoderTools lilisheng
 *
 */
@Service
public class RcuErrorLogService extends XJLService {
	@Autowired
	private RcuErrorLogMapper rcuErrorLogMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.rcuErrorLogMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.rcuErrorLogMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.rcuErrorLogMapper.update(domain);
	}
	public List<RcuErrorLog> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.rcuErrorLogMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public RcuErrorLog queryById(String errorId) {
		return this.rcuErrorLogMapper.selectById(errorId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((RcuErrorLog)domain).setErrorId(UUID.randomUUID().toString());
	}
}
