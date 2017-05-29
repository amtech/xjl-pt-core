package com.xjl.pt.core.tools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.table.TableRowSorter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xjl.pt.core.domain.Table;
import com.xjl.pt.core.domain.TableField;
import com.xjl.pt.core.service.TableFieldService;
import com.xjl.pt.core.service.TableService;

/**
 * 代码工具
 * @author lilisheng
 *
 */
@Component
public class CoderTools {
	private static Log log = LogFactory.getLog(CoderTools.class);
	@Autowired
	private TableService tableService;
	@Autowired
	private TableFieldService tableFieldService;
	/**
	 * 生成servcie/domain/mapper
	 * @param tableName
	 */
	public void generateSDM(String tableName, String basePackageName){
		log.debug("tableName:" + tableName + " basePackageName:" + basePackageName);
		Table table = this.tableService.queryByName(tableName);
		log.debug("table:" + table);
		List<TableField> fieldList = this.tableFieldService.queryByTableId(table.getTableId(), 1, 100);
		String tableShortName = XJLCoderTools.getShortName(tableName);
		log.debug("tableShortName:" + tableShortName);
		String domainName = XJLCoderTools.getDomainName(tableShortName);
		log.debug("domainName:" + domainName);
		String domainPackageName = basePackageName+".domain";
		log.debug("domainPackageName:" + domainPackageName);
		String className = domainPackageName + "." + domainName;
		log.debug("className:" + className);
		File domainFile = generateDomainFile(table, fieldList, domainName, domainPackageName, className);
		generateMapperFile(table, fieldList, domainName, domainPackageName, domainFile);
	}
	private void generateMapperFile(Table table, List<TableField> fieldList, String domainName,
			String domainPackageName, File domainFile) {
		log.debug("开始创建mapper文件");
		File mapperRoot = new File(domainFile.getParentFile().getParentFile(),"mapper");
		File mapperFile = new File(mapperRoot, domainName + "Mapper.java");
		XJLCoderTools.forceCreateFile(mapperFile);
		String mapperContent = MapperCoderTools.generateMapperContent(domainPackageName, domainName, table, fieldList);
		try {
			log.debug("写入mapperContent内容");
			FileUtils.write(mapperFile, mapperContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	private File generateDomainFile(Table table, List<TableField> fieldList, String domainName,
			String domainPackageName, String className) {
		File domainFile = XJLCoderTools.getClassFile(className);
		XJLCoderTools.forceCreateFile(domainFile);
		log.debug("强制创建文件成功");
		String domainContent = DomainCoderTools.generateDomainContent(domainPackageName, domainName, table.getTableDesc(),fieldList);
		try {
			log.debug("写入domainContent内容");
			FileUtils.write(domainFile, domainContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return domainFile;
	}
	
	public void generateController(String tableName){
		
	}
	public void generatePage(String tableName){
		
	}
	
}
