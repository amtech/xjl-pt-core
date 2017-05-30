package com.xjl.pt.core.tools;

import java.util.List;


import com.xjl.pt.core.domain.Table;
import com.xjl.pt.core.domain.TableField;

public class MapperCoderTools {
	public static final String generateMapperContent(String domainPackage, String domainName,Table 
			table, List<TableField> fieldList){
		String mapperPackage = domainPackage.substring(0,domainPackage.length()-6) + "mapper";
		String mapperName = domainName + "Mapper";
		StringBuffer sb = new StringBuffer();
		sb.append("package "+mapperPackage +";\r\n");
		sb.append("import org.apache.ibatis.annotations.Insert;\r\n");
		//sb.append("import org.apache.ibatis.annotations.Delete;\r\n");
		sb.append("import org.apache.ibatis.annotations.Select;\r\n");
		sb.append("import org.apache.ibatis.annotations.Update;\r\n");
		sb.append("import org.springframework.stereotype.Repository;\r\n");
		sb.append("import java.util.List;\r\n");
		sb.append("import com.xjl.pt.core.domain.XJLDomain;\r\n");
		sb.append("import " + domainPackage + "." + domainName + ";\r\n");
		sb.append("/**\r\n");
		sb.append(" * " + table.getTableDesc() + "\r\n");
		sb.append(" * @author MapperCoderTools\r\n");
		sb.append(" *\r\n");
		sb.append("*/\r\n");
		sb.append("@Repository\r\n");
		sb.append("public interface " + mapperName + " {\r\n");
		sb.append("\tstatic final String TABLE_NAME = \"" + table.getTableName() + "\";\r\n");
		sb.append("\tstatic final String SELECT_ALL = \"" + getSelectAllField(fieldList) + "\"+ XJLMapper.FIX_SELECT_FIELD;\r\n");
		sb.append("\tstatic final String INSERT_FIELD = \"" + getInsertAllField(fieldList) + "\" + XJLMapper.FIX_INSERT_FIELD;\r\n");
		sb.append("\tstatic final String INSERT_VALUE = \"" + getInsertAllFieldValue(fieldList)+ "\" + XJLMapper.FIX_INSERT_VALUE;\r\n");
		sb.append("\tstatic final String UPDATE_FIELD = \"" + getUpdateAllField(fieldList)+ "\" + XJLMapper.FIX_UPDATE_FIELD;\r\n");
		sb.append(insert());
		sb.append(delete(fieldList));
		sb.append(update(fieldList));
		sb.append(selectAll(domainName));
		sb.append(selectById(fieldList, domainName));
		sb.append("\t\r\n");
		sb.append("\t\r\n");
		sb.append("\t\r\n");
		sb.append("}");
		return sb.toString();
	}
	private static String insert(){
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Insert(\"insert into \" + TABLE_NAME + \"(\" + INSERT_FIELD + \") values(\"+INSERT_VALUE+\")\")\r\n");
		sb.append("\tpublic void insert(XJLDomain domain);\r\n");
		return sb.toString();
	}
	private static String delete(List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			if (TableField.FIELD_TYPE_PK.equals(tableField.getFieldType())){
				sb.append("\t@Update(\"update \" + TABLE_NAME + \" set \" + XJLMapper.FIX_DELETE_FIELD + \" where "+ tableField.getFieldName() + "=#{"+XJLCoderTools.getDomainFieldName(tableField.getFieldName())+"}\")	\r\n");
				sb.append("\tpublic void delete(XJLDomain domain);\r\n");
				break;
			}
		}
		return sb.toString();
	}
	private static String update(List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			if (TableField.FIELD_TYPE_PK.equals(tableField.getFieldType())){
				sb.append("\t@Update(\"update \" + TABLE_NAME + \" set \" + UPDATE_FIELD + \" where "+ tableField.getFieldName() + "=#{"+XJLCoderTools.getDomainFieldName(tableField.getFieldName())+"}\")	\r\n");
				sb.append("\tpublic void update(XJLDomain domain);\r\n");
				break;
			}
		}
		return sb.toString();
	}
	private static String selectAll(String domainName){
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Select(\"select \" + SELECT_ALL + \" from \" + TABLE_NAME + \" where state='A' order by create_date desc\")\r\n");
		sb.append("\tpublic List<" + domainName + "> selectAll();\r\n");
		return sb.toString();
	}
	private static String selectById(List<TableField> fieldList, String domainName){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			if (TableField.FIELD_TYPE_PK.equals(tableField.getFieldType())){
				sb.append("\t@Select(\"select \" + SELECT_ALL + \" from \" + TABLE_NAME + \" where " + tableField.getFieldName() + "=#{" + XJLCoderTools.getDomainFieldName(tableField.getFieldName()) +"}\")\r\n");
				sb.append("\tpublic " + domainName + " selectById(String dictId);\r\n");
				break;
			}
		}
		return sb.toString();
	}
	private static  String getSelectAllField(List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			sb.append(tableField.getFieldName());
			sb.append(" as ");
			sb.append(XJLCoderTools.getDomainFieldName(tableField.getFieldName()));
			sb.append(",");
		}
		return sb.toString();
	}
	private static  String getInsertAllField(List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			sb.append(tableField.getFieldName());
			sb.append(",");
		}
		return sb.toString();
	}
	private static  String getInsertAllFieldValue(List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			sb.append("#{" + XJLCoderTools.getDomainFieldName(tableField.getFieldName()) + "}");
			sb.append(",");
		}
		return sb.toString();
	}
	private static  String getUpdateAllField(List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			if (TableField.FIELD_TYPE_PK.equals(tableField.getFieldType())){
				continue;
			}
			sb.append(tableField.getFieldName());
			sb.append("=");
			sb.append("#{" + XJLCoderTools.getDomainFieldName(tableField.getFieldName()) + "}");
			sb.append(",");
		}
		return sb.toString();
	}
}
