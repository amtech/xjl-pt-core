package com.xjl.pt.core.tools;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.xjl.pt.core.domain.TableField;

public class XJLCoderTools {
	public static String getShortName(String tableName){
		String lowerName = tableName.toLowerCase();
		if (lowerName.startsWith("xjl_pt_")){
			lowerName = StringUtils.substringAfter(lowerName, "xjl_pt_");
		}
		if (lowerName.startsWith("xjl_")){
			lowerName = StringUtils.substringAfter(lowerName, "xjl_");
		}
		return lowerName;
	}
	public static String getDomainName(String tableName){
		String shortName = XJLCoderTools.getShortName(tableName);
		String[] keys = StringUtils.split(shortName,"_");
		StringBuffer sb = new StringBuffer();
		for (String key : keys) {
			sb.append(StringUtils.capitalize(key));
		}
		return sb.toString();
	}
	public static String getDomainFieldName(String fieldName){
		String shortName = XJLCoderTools.getShortName(fieldName);
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
	public static File getClassFile(String className){
		
		File rootPath = FileUtils.getFile("src/main/java");
		String classPath[] = StringUtils.split(className, ".");
		classPath[classPath.length-1] += ".java";
		File classFile = rootPath;
		for (String path : classPath) {
			classFile = new File(classFile, path);
		}
		return classFile;
	}
	public static void forceCreateFile(File file){
		if (file.exists()){
			try {
			FileUtils.forceMkdir(file.getParentFile());
			file.createNewFile();
			} catch (Exception e){
				throw new RuntimeException(e);
			}
		} 
	}
	public static String getDomainFieldType(String fieldType){
		switch (fieldType){
		case TableField.FIELD_TYPE_STRING:
			return "String";
		case TableField.FIELD_TYPE_NUMBER:
			return "Integer";
		case TableField.FIELD_TYPE_DATE:
			return "Date";
		case TableField.FIELD_TYPE_DICT:
			return "String";
		case TableField.FIELD_TYPE_FK:
			return "String";
		case TableField.FIELD_TYPE_PK:
			return "String";
			default:
				throw new RuntimeException("不支持的类型:" + fieldType);
		}
			
	}
	
}
