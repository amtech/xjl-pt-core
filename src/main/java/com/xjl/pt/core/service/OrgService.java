package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 机构
 * @author leasonlive
 *
 */

import com.xjl.pt.core.domain.Org;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.OrgMapper;
@Service
public class OrgService extends XJLService {
	@Autowired
	private OrgMapper orgMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.orgMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.orgMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.orgMapper.update(domain);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((Org)domain).setOrg(UUID.randomUUID().toString());
	}
	public List<Org> query(){
		return this.orgMapper.select();
	}
	public Org queryById(String org){
		return this.orgMapper.selectById(org);
	}
}
