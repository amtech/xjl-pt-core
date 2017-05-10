package com.xjl.pt.core.service;

import java.util.List;
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
		dict.setDictName("行使层级");
		dictService.add(dict, user);
	}
	@Test
	public void query(){
		List<Dict> list = this.dictService.queryByName(null,1,10);
		for (Dict dict : list) {
			System.out.println(dict.getDictName());
		}
	}
}
