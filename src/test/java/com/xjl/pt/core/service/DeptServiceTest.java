package com.xjl.pt.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Dept;
import com.xjl.pt.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class DeptServiceTest {
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Test
	public void add(){
		User user = this.userService.queryFixUser();
		Dept dept=new Dept();
		dept.setDeptName("审批局2");
		this.deptService.add(dept, user);
	}
	@Test
	public void delete(){
		List<Dept> list = this.deptService.query(null, 1,1);
		User user = this.userService.queryFixUser();
		this.deptService.delete(list.get(0), user);
	}
	@Test
	public void modify(){
		List<Dept> list = this.deptService.query(null, 1,1);
		User user = this.userService.queryFixUser();
		list.get(0).setDeptName("审批件3");
		this.deptService.modify(list.get(0), user);
	}
}
