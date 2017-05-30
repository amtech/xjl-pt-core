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
 */
@Service
public class UserLogService  extends XJLService   {
	
	@Autowired
	private UserLogMapper userLogMapper;
	
	public  void print(){
		System.out.println(this.userLogMapper);
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

}
