package com.xjl.pt.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjl.pt.core.mapper.XJLMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class XJLMapperTest {
	@Test
	public void insertFixField(){
		String sql = "insert into a(a,b) values(#{1},#{2})";
		String sql2 = XJLMapper._insertFixField(sql);
		System.out.println(sql2);
	}
	@Test
	public void deleteFixField(){
		String sql = XJLMapper._deleteFixField("abc", "a=1 and b=2");
		System.out.println(sql);
		
		
	}
	@Test
	public void selectFixField(){
		String sql = XJLMapper._selectFixField("select a,b from table where a=1");
		System.out.println(sql);
	}
	@Test
	public void selectFixFieldWithState(){
		String sql = XJLMapper._selectFixFieldWithState("select a,b from table");
		System.out.println(sql);
		String sql2 = XJLMapper._selectFixFieldWithState("select a,b from table where a=1");
		System.out.println(sql2);
	}
}
