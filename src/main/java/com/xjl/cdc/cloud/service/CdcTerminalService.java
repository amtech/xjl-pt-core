package com.xjl.cdc.cloud.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.cdc.cloud.domain.CdcTerminal;
import com.xjl.cdc.cloud.mapper.CdcTerminalMapper;

/**
 * 云检测中心终端
 * @author ServiceCoderTools lilisheng
 *
 */
@Service
public class CdcTerminalService extends XJLService {
	@Autowired
	private CdcTerminalMapper cdcTerminalMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.cdcTerminalMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.cdcTerminalMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.cdcTerminalMapper.update(domain);
	}
	public List<CdcTerminal> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.cdcTerminalMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public CdcTerminal queryById(String terminalId) {
		return this.cdcTerminalMapper.selectById(terminalId);
	}
	public CdcTerminal queryByGUID(String terminalGUID) {
		return this.cdcTerminalMapper.selectByGUID(terminalGUID);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((CdcTerminal)domain).setTerminalId(UUID.randomUUID().toString());
	}
}
