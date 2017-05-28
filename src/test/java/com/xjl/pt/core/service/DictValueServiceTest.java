package com.xjl.pt.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.DictItem;
import com.xjl.pt.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class DictValueServiceTest {
	@Autowired 
	DictService dictService;
	@Autowired
	DictItemService dictValueService;
	@Autowired
	private UserService userService;
	@Test
	public void add(){
		User user = this.userService.queryById("9fcfdb3e-3bdb-4234-a0c4-f91d023c308e");
		List<Dict> list = this.dictService.queryByName("事项类别",1,10);
		Dict dict = list.get(0);
		DictItem dictValue = new DictItem();
		dictValue.setDictId(dict.getDictId());
		dictValue.setDictItemCode("10");
		dictValue.setDictItemName("行政许可");
		this.dictValueService.add(dictValue, user);
		dictValue.setDictItemCode("20");
		dictValue.setDictItemName("行政处罚");
		this.dictValueService.add(dictValue, user);
		dictValue.setDictItemCode("30");
		dictValue.setDictItemName("行政给付");
		this.dictValueService.add(dictValue, user);
	}
	@Test
	public void query(){
		List<Dict> dicts = this.dictService.queryByName("事项类别",1,10);
		Dict dict = dicts.get(0);
		List<DictItem> list = this.dictValueService.queryByDictId(dict.getDictId(),1,10);
		for (DictItem dictValue : list) {
			System.out.println("code:" + dictValue.getDictItemCode() + " name:" + dictValue.getDictItemName());
		}
	}
}
