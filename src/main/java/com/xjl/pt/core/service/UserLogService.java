package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.xjl.pt.core.domain.UserLog;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserLogMapper;

/**
 * 用户日志基本业务类
 * @author guan.zheyuan
 *
 */
@Service
@ContextConfiguration(locations = { "classpath*:/ApplicationContext-*.xml"})  
public class UserLogService  extends XJLService   {
	
	@Autowired
	private UserLogMapper userLogMapper;
	
	public  void print(){
		System.out.println(this.userLogMapper);
	}
	/**
	 * 设置固定字段的值
	 * @param domain
	 * @param user
	 */
	public void add(XJLDomain domain, UserLog userLog){
		domain.setOrg(userLog.getOrg());
		domain.setMaster(UUID.randomUUID().toString());
		domain.setCreateUserId(userLog.getUserId());
		domain.setCreateDate(Calendar.getInstance().getTime());
		domain.setCancelDate(null);
		domain.setCancelUserId(null);
		domain.setState(XJLDomain.StateType.A.name());
		_add(domain);
	}

	@Override
	public void _add(XJLDomain domain) {
		// TODO Auto-generated method stub
		this.userLogMapper.insert(domain);
	}

	@Override
	public void _delete(XJLDomain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void _resetNewId(XJLDomain domain) {
		// TODO Auto-generated method stub
		
	}

}
