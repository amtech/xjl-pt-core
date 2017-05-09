package com.xjl.pt.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjl.pt.core.domain.DictValue;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.DictValueMapper;
@Service
public class DictValueService extends XJLService {
	@Autowired
	private DictValueMapper dictValueMapper;
	
	@Override
	void _add(XJLDomain domain) {
		this.dictValueMapper.insert(domain);
	}

	@Override
	void _delete(XJLDomain domain) {
		throw new RuntimeException("该方法未实现");
	}

	@Override
	void _resetNewId(XJLDomain domain) {
		
	}
	/**
	 * 根据dictId获取所有的字典项列表
	 * @param dictId
	 * @return
	 */
	public List<DictValue> queryByDictId(String dictId){
		return this.dictValueMapper.selectByDictId(dictId);
	}

}
