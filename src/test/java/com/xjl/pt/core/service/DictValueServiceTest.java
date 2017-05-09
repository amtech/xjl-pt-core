package com.xjl.pt.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.DictValue;
import com.xjl.pt.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class DictValueServiceTest {
	@Autowired 
	DictService dictService;
	@Autowired
	DictValueService dictValueService;
	@Autowired
	private UserService userService;
	@Test
	public void add(){
		User user = this.userService.queryById("9fcfdb3e-3bdb-4234-a0c4-f91d023c308e");
		Dict dict = this.dictService.queryByName("事项类别");
		DictValue dictValue = new DictValue();
		dictValue.setDictId(dict.getDictId());
		dictValue.setDictValueCode("10");
		dictValue.setDictValueName("行政许可");
		this.dictValueService.add(dictValue, user);
		dictValue.setDictValueCode("20");
		dictValue.setDictValueName("行政处罚");
		this.dictValueService.add(dictValue, user);
		dictValue.setDictValueCode("30");
		dictValue.setDictValueName("行政给付");
		this.dictValueService.add(dictValue, user);
	}
	@Test
	public void query(){
		Dict dict = this.dictService.queryByName("事项类别");
		List<DictValue> list = this.dictValueService.queryByDictId(dict.getDictId());
		for (DictValue dictValue : list) {
			System.out.println("code:" + dictValue.getDictValueCode() + " name:" + dictValue.getDictValueName());
		}
	}
}
