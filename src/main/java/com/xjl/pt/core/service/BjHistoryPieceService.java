package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.BjHistoryPiece;
import com.xjl.pt.core.mapper.BjHistoryPieceMapper;

/**
 * 历史办件
 * @author ServiceCoderTools 陶杰
 *
 */
@Service
public class BjHistoryPieceService extends XJLService {
	@Autowired
	private BjHistoryPieceMapper bjHistoryPieceMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.bjHistoryPieceMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.bjHistoryPieceMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.bjHistoryPieceMapper.update(domain);
	}
	/**
	 * 用于查找数据分页返回前台
	 * @param search
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<BjHistoryPiece> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.bjHistoryPieceMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
	/**
	 * 通过历史办件id查找数据
	 * @param pieceId
	 * @return
	 */
	public BjHistoryPiece queryByPieceId(String pieceId){
		return this.bjHistoryPieceMapper.selectByPieceId(pieceId);
	}
	
}
