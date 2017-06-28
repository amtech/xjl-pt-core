package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.BjPieceLicence;
import com.xjl.pt.core.mapper.BjPieceLicenceMapper;

/**
 * 办件材料关联表
 * @author ServiceCoderTools 陶杰
 *
 */
@Service
public class BjPieceLicenceService extends XJLService {
	@Autowired
	private BjPieceLicenceMapper bjPieceLicenceMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.bjPieceLicenceMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.bjPieceLicenceMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.bjPieceLicenceMapper.update(domain);
	}
	public List<BjPieceLicence> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.bjPieceLicenceMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
	/**
	 * 通过办件id获得该办件的所有材料信息
	 * @param pieceId
	 * @return
	 */
	public List<BjPieceLicence> queryByPieceId(String pieceId){
		return this.bjPieceLicenceMapper.selectByPieceId(pieceId);
	}
}
