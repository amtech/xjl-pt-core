package com.xjl.pt.core.service;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Org;
import com.xjl.pt.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class OrgServiceTest {
	@Autowired
	private OrgService orgService;
	@Autowired
	private UserService userService;
	@Test
	public void add(){
		User user = this.userService.queryById("c97106eb-65a2-4063-8ed9-43bb96016278");
		Org org = new Org();
		org.setOrg(UUID.randomUUID().toString());
		org.setOrgName("测试市");
		this.orgService.add(org,user);
	}
	@Test
	public void addXJLOrg(){
		User user = this.userService.queryById("XJLXJL00-XJL1-XJL2-XJL3-XJLXJLXJLXJL");
		Org org = new Org();
		org.setOrg(UUID.randomUUID().toString());
		org.setOrgName("XJL市");
		this.orgService.add(org,user);
	}
	@Test
	public void query(){
		List<Org> list = this.orgService.query();
		for (Org org : list) {
			System.out.println("org:" + org.getOrgName() + " createDate:" + org.getCreateDate());
		}
	}
}
