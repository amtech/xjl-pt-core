package com.xjl.pt.core.tools;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-*.xml"})
public class CoderToolsTest {
	@Autowired
	private CoderTools coderTools;
	@Test
	public void getShortName(){
		String tableName = "xjl_pt_service_item";
		String shortName = XJLCoderTools.getShortName(tableName);
		Assert.assertEquals("service_item", shortName);
	}
	@Test
	public void getDomainName(){
		String tableName = "xjl_pt_service_Item";
		String domainName = XJLCoderTools.getDomainName(tableName);
		Assert.assertEquals("ServiceItem", domainName);
	}
	@Test
	public void getDomainFieldName(){
		String fieldName = "id";
		String domainFieldName = XJLCoderTools.getDomainFieldName(fieldName);
		Assert.assertEquals("id", domainFieldName);
		Assert.assertEquals("tableName", XJLCoderTools.getDomainFieldName("table_name"));
	}
	@Test
	public void getClassFile(){
		String className = "com.xjl.pt.core.domain.Abc";
		File classFile = XJLCoderTools.getClassFile(className);
		System.out.println(classFile.getAbsolutePath());
	}
	@Test
	public void generateDomain(){
		this.coderTools.generateSDM("xjl_zz_catalog_licence", "com.xjl.pt.core");
	}
	@Test
	public void generateSXDirItem(){
		this.coderTools.generateSDM("xjl_zz_catalog", "com.xjl.pt.sx");
	}
	@Test
	public void generateSXImplItem(){
		this.coderTools.generateSDM("xjl_zz_catalog", "com.xjl.pt.sx");
	}
	@Test
	public void generateGOVOpen(){
		this.coderTools.generateSDM("xjl_zz_catalog_licence", "com.xjl.pt.news");
	//	this.coderTools.generateSDM("xjl_zz_catalog", "com.xjl.pt.news");
	}
	@Test
	public void generateCDCTerminal(){
		this.coderTools.generateSDM("xjl_cdc_terminal", "com.xjl.cdc.cloud");
	}
}
