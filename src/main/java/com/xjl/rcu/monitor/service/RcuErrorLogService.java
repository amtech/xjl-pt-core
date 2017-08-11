package com.xjl.rcu.monitor.service;

import java.util.List;
import java.util.Map;
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
	public List<RcuErrorLog> queryByErrorTime(String beginTime, String endTime) {
		return this.rcuErrorLogMapper.selectByErrorTime(beginTime,endTime);
	}
	public List<RcuErrorLog> queryByErrorTimeTj(String beginTime, String endTime) {
		return this.rcuErrorLogMapper.selectByErrorTimeTj(beginTime,endTime);
	}
	public String selectByErrorTime(Map<String, Object> para) {
		String sql = "select " + RcuErrorLogMapper.SELECT_ALL + " from " + RcuErrorLogMapper.TABLE_NAME + " where 1=1";
		String beginTime = (String)para.get("beginTime");
		String endTime = (String)para.get("endTime");
		if(!"".equals(beginTime)) {
			sql+=" and error_date >= '"+beginTime+"'";
		}
		if(!"".equals(endTime)) {
			sql+=" and error_date <= '"+endTime+"'";
		}
		sql+=" order by error_date desc";
		return sql;
	}
	public String selectByErrorTimeTj(Map<String, Object> para) {
		String sql1 = "select device_code as logContent,'device' as logCountType,count(*) as logCount from " + RcuErrorLogMapper.TABLE_NAME + " where 1=1";
		String sql2 = "select error_code as logContent,'error' as logCountType,count(*) as logCount from " + RcuErrorLogMapper.TABLE_NAME + " where 1=1";
		String beginTime = (String)para.get("beginTime");
		String endTime = (String)para.get("endTime");
		if(!"".equals(beginTime)) {
			sql1+=" and error_date >= '"+beginTime+"'";
			sql2+=" and error_date >= '"+beginTime+"'";
		}
		if(!"".equals(endTime)) {
			sql1+=" and error_date <= '"+endTime+"'";
			sql2+=" and error_date <= '"+endTime+"'";
		}
		sql1+=" group by device_code";
		sql2+=" group by error_code";
		String sql = sql1+" union all "+sql2;
		return sql;
	}
}
