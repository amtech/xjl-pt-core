package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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
		((DictValue)domain).setDictValueId(UUID.randomUUID().toString());
	}
	/**
	 * 根据dictId获取所有的字典项列表
	 * @param dictId
	 * @return
	 */
	public List<DictValue> queryByDictId(String dictId,int page, int pageSize){
		PageHelper.startPage(page, pageSize);
		return this.dictValueMapper.selectByDictId(dictId);
	}
	/**
	 * 查询字典值
	 * @param dictId 字典id
	 * @param search 搜索条件
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<DictValue> queryByDictId(String dictId,String search, int page, int pageSize){
		PageHelper.startPage(page, pageSize);
		return this.dictValueMapper.selectByDictIdWithSearch(dictId,search);
	}
	/**
	 * 根据dictId获取值的数量
	 * @param dictId
	 * @return
	 */
	public int countByDictId(String dictId){
		return this.dictValueMapper.selectCountByDictId(dictId);
	}
}
