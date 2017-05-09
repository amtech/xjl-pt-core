package com.xjl.pt.core.service;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Org;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class UserTest {
	@Autowired UserService userService;
	@Autowired OrgService orgService;
	@Test
	public void add(){
		User user = new User();
		user.setUserId("XJLXJL00-XJL1-XJL2-XJL3-XJLXJLXJLXJL");
		user.setUserName("超级管理员");
		user.setState(XJLDomain.StateType.A.name());
		this.userService._add(user);
	}
	@Test
	public void addLi(){
		User manager = this.userService.queryById("XJLXJL00-XJL1-XJL2-XJL3-XJLXJLXJLXJL");
		Org org = this.orgService.queryById("06245e00-0321-4db5-b555-03fb077699c1");
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("理立胜");
		user.setOrg(org.getOrg());
		this.userService.add(user, manager);
	}
}
