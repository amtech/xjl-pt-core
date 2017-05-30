package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjl.pt.core.config.XJLConfig;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserMapper;
@Service
public class UserService extends XJLService {
	@Autowired
	private XJLConfig xjlConfig;
	@Autowired
	private UserMapper userMapper;
	@Override
	protected void _preDomain(XJLDomain domain, User user) {
		if (user == null){
			//用户自己注册
			domain.setOrg(this.xjlConfig.getOrg());
			domain.setCreateUserId(null);
			domain.setCreateDate(Calendar.getInstance().getTime());
		} else {
			domain.setOrg(user.getOrg());
			domain.setCreateUserId(user.getUserId());
			domain.setCreateDate(Calendar.getInstance().getTime());
		}
		domain.setMaster(UUID.randomUUID().toString());
		domain.setCancelDate(null);
		domain.setCancelUserId(null);
		domain.setState(XJLDomain.StateType.A.name());
	}
	@Override
	public void _add(XJLDomain domain) {
		this.userMapper.insert(domain);
	}

	@Override
	public void _delete(XJLDomain domain) {
		this.userMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.userMapper.update(domain);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((User)domain).setUserId(UUID.randomUUID().toString());
	}
	public User queryById(String userId){
		return this.userMapper.selectById(userId);
	}
	public User queryFixUser(){
		return this.queryById("9fcfdb3e-3bdb-4234-a0c4-f91d023c308e");
	}
}
