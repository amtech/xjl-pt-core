package com.xjl.pt.core.service;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xjl.pt.core.domain.DataLog;
import com.xjl.pt.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class DataLogServiceTest {
	@Autowired
	private DataLogService dataLogService;
	@Autowired
	private UserService userService;
	@Test
	public void add(){
		User user = this.userService.queryFixUser();
		DataLog dataLog = new DataLog();
		dataLog.setTableName("xx_table");
		dataLog.setMasterValue("123");
		dataLog.setDataJson("{a:1,b:2}");
		dataLog.setOperateDate(Calendar.getInstance().getTime());
		dataLog.setOperateType(DataLog.OPERATE_TYPE_ADD);
		dataLog.setOperateUserId(user.getUserId());
		this.dataLogService.add(dataLog, user);
	}
}
