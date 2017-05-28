package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.DataLogMapper;
/**
 * 数据日志
 * @author lilisheng
 *
 */
@Service
public class DataLogService extends XJLBaseService {
	@Autowired
	private DataLogMapper dataLogMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.dataLogMapper.insert(domain);
	}

	@Override
	public void _delete(XJLDomain domain) {
		throw new RuntimeException("不支持删除方法");

	}
	@Override
	public void _modify(XJLDomain domain) {
		throw new RuntimeException("不支持修改方法");
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		// TODO Auto-generated method stub

	}

}
