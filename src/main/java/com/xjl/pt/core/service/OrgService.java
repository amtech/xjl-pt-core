package com.xjl.pt.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 机构
 * @author leasonlive
 *
 */

import com.xjl.pt.core.domain.Org;
import com.xjl.pt.core.mapper.OrgMapper;
@Service
public class OrgService {
	@Autowired
	private OrgMapper orgMapper;
	public void add(Org org){
		this.orgMapper.insert(org);
	}
	public List<Org> query(){
		return this.orgMapper.select();
	}
	public void delete(String org){
		this.orgMapper.delete(org);
	}
}
