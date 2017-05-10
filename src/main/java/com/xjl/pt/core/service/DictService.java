package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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
	public List<Dict> queryByName(String dictName,int page, int pageSize){
		
		if (StringUtils.isBlank(dictName)){
			return this.query(page, pageSize);
		} else {
			PageHelper.startPage(page, pageSize);
			return this.dictMapper.selectByName(dictName);
		}
	}
	/**
	 * 查询字典
	 * @return
	 */
	public List<Dict> query(int page, int pageSize){
		PageHelper.startPage(page, pageSize);
		return this.dictMapper.selectAll();
	}
}
