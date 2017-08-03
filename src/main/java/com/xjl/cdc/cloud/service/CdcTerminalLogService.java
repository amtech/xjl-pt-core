package com.xjl.cdc.cloud.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.cdc.cloud.domain.CdcTerminalLog;
import com.xjl.cdc.cloud.mapper.CdcTerminalLogMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.service.XJLService;

/**
 * 云检测中心终端访问日志
 * @author you.guess
 *
 */
@Service
public class CdcTerminalLogService extends XJLService {
	@Autowired
	private CdcTerminalLogMapper cdcTerminalLogMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cdcTerminalLogMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
	}
	@Override
	public void _modify(XJLDomain domain) {
	}
	public List<CdcTerminalLog> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cdcTerminalLogMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public CdcTerminalLog queryById(String logId) {
		return this.cdcTerminalLogMapper.selectById(logId);
	}
	public List<CdcTerminalLog> queryByTMId(String terminalId) {
		return this.cdcTerminalLogMapper.selectByTMId(terminalId);
	}
	public List<CdcTerminalLog> queryByGUID(String terminalGUID) {
		return this.cdcTerminalLogMapper.selectByGUID(terminalGUID);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((CdcTerminalLog)domain).setLogId(UUID.randomUUID().toString());
	}

}
