package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserMapper;
@Service
public class UserService extends XJLService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public void add(XJLDomain domain, User user) {
		if (StringUtils.isBlank(domain.getOrg())){
			throw new RuntimeException("用户的org不能为空");
		}
//		domain.setOrg(user.getOrg());
		domain.setCreateUserId(user.getUserId());
		domain.setCreateDate(Calendar.getInstance().getTime());
		domain.setCancelDate(null);
		domain.setCancelUserId(null);
		domain.setState(XJLDomain.StateType.A.name());
		_add(domain);
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
