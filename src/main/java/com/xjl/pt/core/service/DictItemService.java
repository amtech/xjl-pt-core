package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.domain.DictItem;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.DictItemMapper;
@Service
public class DictItemService extends XJLService {
	@Autowired
	private DictItemMapper dictItemMapper;
	
	@Override
	public void _add(XJLDomain domain) {
		this.dictItemMapper.insert(domain);
	}

	@Override
	public void _delete(XJLDomain domain) {
		throw new RuntimeException("该方法未实现");
	}

	@Override
	public void _resetNewId(XJLDomain domain) {
		((DictItem)domain).setDictItemId(UUID.randomUUID().toString());
	}
	/**
	 * 根据dictId获取所有的字典项列表
	 * @param dictId
	 * @return
	 */
	public List<DictItem> queryByDictId(String dictId,int page, int pageSize){
		PageHelper.startPage(page, pageSize);
		return this.dictItemMapper.selectByDictId(dictId);
	}
	/**
	 * 查询字典值
	 * @param dictId 字典id
	 * @param search 搜索条件
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<DictItem> queryByDictId(String dictId,String search, int page, int pageSize){
		PageHelper.startPage(page, pageSize);
		return this.dictItemMapper.selectByDictIdWithSearch(dictId,search);
	}
	/**
	 * 根据dictId获取值的数量
	 * @param dictId
	 * @return
	 */
	public int countByDictId(String dictId){
		return this.dictItemMapper.selectCountByDictId(dictId);
	}
}
