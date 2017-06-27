package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.BsStrategy;
import com.xjl.pt.core.mapper.BsStrategyMapper;

/**
 * 办事攻略
 * @author ServiceCoderTools 陶杰
 *
 */
@Service
public class BsStrategyService extends XJLService {
	@Autowired
	private BsStrategyMapper bsStrategyMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.bsStrategyMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.bsStrategyMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.bsStrategyMapper.update(domain);
	}
	public List<BsStrategy> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.bsStrategyMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		
	}
	/**
	 * 通过攻略id查找数据
	 */
	public BsStrategy queryById(String StrategyId){
		return this.bsStrategyMapper.selectById(StrategyId);
	}
	/**
	 * 通过攻略id屏蔽某条攻略,作用相当于逻辑删除
	 */
	public void modifyStateById(String StrategyId){
		this.bsStrategyMapper.updateStateById(StrategyId);
	}
	/**
	 * 通过创建用户id查找数据
	 */
	public List<BsStrategy> queryByUserId(String userId){
		return this.bsStrategyMapper.selectByUserId(userId);
	}
}
