package com.xjl.pt.core.service;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class DictServiceTest {
	@Autowired
	private DictService dictService;
	@Autowired
	private UserService userService;
	@Test
	public void add(){
		User user = this.userService.queryById("9fcfdb3e-3bdb-4234-a0c4-f91d023c308e");
		Dict dict = new Dict();
		dict.setDictId(UUID.randomUUID().toString());
		dict.setDictName("事项类别");
		dictService.add(dict, user);
	}
}
