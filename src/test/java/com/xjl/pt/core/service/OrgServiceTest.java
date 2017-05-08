package com.xjl.pt.core.service;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Org;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class OrgServiceTest {
	@Autowired
	private OrgService orgService;
	@Test
	public void add(){
		Org org = new Org();
		org.setOrg(UUID.randomUUID().toString());
		org.setOrgName("南京市");
		this.orgService.add(org);
	}
}
