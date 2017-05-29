package com.xjl.pt.core.tools;

import java.io.File;
import java.io.IOException;

import javax.swing.table.TableRowSorter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xjl.pt.core.domain.Table;
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
	/**
	 * 生成servcie/domain/mapper
	 * @param tableName
	 */
	public void generateSDM(String tableName){
		
	}
	public void generateDomain(String tableName,String basePackageName){
		log.debug("tableName:" + tableName + " basePackageName:" + basePackageName);
		Table table = this.tableService.queryByName(tableName);
		log.debug("table:" + table);
		String tableShortName = this.getShortName(tableName);
		log.debug("tableShortName:" + tableShortName);
		String domainName = this.getDomainName(tableShortName);
		log.debug("domainName:" + domainName);
		String domainPackageName = basePackageName+".domain";
		log.debug("domainPackageName:" + domainPackageName);
		String className = domainPackageName + "." + domainName;
		log.debug("className:" + className);
		File domainFile = this.getClassFile(className);
		this.forceCreateFile(domainFile);
		log.debug("强制创建文件成功");
		String domainContent = DomainCoderTools.generateDomainContent(domainPackageName, domainName, table.getTableDesc());
		try {
			log.debug("写入domainContent内容");
			FileUtils.write(domainFile, domainContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void generateController(String tableName){
		
	}
	public void generatePage(String tableName){
		
	}
	public String getShortName(String tableName){
		String lowerName = tableName.toLowerCase();
		if (lowerName.startsWith("xjl_pt_")){
			lowerName = StringUtils.substringAfter(lowerName, "xjl_pt_");
		}
		if (lowerName.startsWith("xjl_")){
			lowerName = StringUtils.substringAfter(lowerName, "xjl_");
		}
		return lowerName;
	}
	public String getDomainName(String tableName){
		String shortName = this.getShortName(tableName);
		String[] keys = StringUtils.split(shortName,"_");
		StringBuffer sb = new StringBuffer();
		for (String key : keys) {
			sb.append(StringUtils.capitalize(key));
		}
		return sb.toString();
	}
	public String getDomainFieldName(String fieldName){
		String shortName = this.getShortName(fieldName);
		String[] keys = StringUtils.split(shortName,"_");
		StringBuffer sb = new StringBuffer();
		for (String key : keys) {
			if (sb.length() == 0){
				sb.append(key);
			} else {
				sb.append(StringUtils.capitalize(key));
			}
		}
		return sb.toString();
	}
	public File getClassFile(String className){
		
		File rootPath = FileUtils.getFile("src/main/java");
		String classPath[] = StringUtils.split(className, ".");
		classPath[classPath.length-1] += ".java";
		File classFile = rootPath;
		for (String path : classPath) {
			classFile = new File(classFile, path);
		}
		return classFile;
	}
	public void forceCreateFile(File file){
		if (file.exists()){
			try {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			} catch (Exception e){
				throw new RuntimeException(e);
			}
		} 
	}
}
