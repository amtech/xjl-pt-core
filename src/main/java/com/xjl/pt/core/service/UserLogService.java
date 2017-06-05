package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xjl.pt.core.config.XJLConfig;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.UserLog;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserLogMapper;

/**
 * 用户日志基本业务类
 * @author guan.zheyuan
 */
@Service
public class UserLogService  extends XJLService   {
	@Autowired
	private XJLConfig xjlConfig;
	@Autowired
	private UserLogMapper userLogMapper;
	
	public  void print(){
		System.out.println(this.userLogMapper);
	}

	@Override
	protected void _preDomain(XJLDomain domain, User user) {
		if (user == null){
			//游客日志
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
		// TODO Auto-generated method stub
		this.userLogMapper.insert(domain);
	}

	@Override
	public void _delete(XJLDomain domain) {
		throw new RuntimeException("不支持删除方法");
	}
	@Override
	public void _modify(XJLDomain domain) {
		throw new RuntimeException("不支持修改方法");
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		// TODO Auto-generated method stub
	}
	/**
	 * 得到最后一次登录日志
	 */
	public UserLog queryUserLogForMax(String userId){
		return this.userLogMapper.selectForMax(userId);
	};
	@Override
	protected void addDataLog(XJLDomain domain, User user, String operateType) {
		//用户日志表的增删改不记录数据日志
	}
}
