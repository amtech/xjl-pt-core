package com.xjl.pt.core.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.DictMapper;
@Service
public class DictService extends XJLService {
	@Autowired
	private DictMapper dictMapper;
	@Override
	void _add(XJLDomain domain) {
		this.dictMapper.insert(domain);
	}

	@Override
	void _delete(XJLDomain domain) {
		throw new RuntimeException("该方法还未实现");
	}

	@Override
	void _resetNewId(XJLDomain domain) {
		((Dict)domain).setDictId(UUID.randomUUID().toString());
	}
	/**
	 * 根据字典名称获取对象
	 * @param dictName 字典名称
	 * @return
	 */
	public Dict queryByName(String dictName){
		return this.dictMapper.selectByName(dictName);
	}

}
