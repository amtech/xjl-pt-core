package com.xjl.pt.core.tools;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.Table;
import com.xjl.pt.core.domain.TableField;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.DictMapper;
import com.xjl.pt.core.service.XJLService;

public class ServiceCoderTools {
	public static final String generateServiceContent(String domainPackage, String domainName,Table 
			table, List<TableField> fieldList){
		String mapperPackage = domainPackage.substring(0,domainPackage.length()-6) + "mapper";
		String mapperName = domainName + "Mapper";
		String servicePackage = domainPackage.substring(0,domainPackage.length()-6) + "service";
		String serviceName = domainName + "Service";
		StringBuffer sb = new StringBuffer();
		sb.append("package " + servicePackage + ";\r\n");
		sb.append("\r\n");
		sb.append("import java.util.List;\r\n");
		sb.append("import java.util.UUID;\r\n");
		sb.append("\r\n");
		sb.append("import org.apache.commons.lang3.StringUtils;\r\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
		sb.append("import org.springframework.stereotype.Service;\r\n");
		sb.append("\r\n");
		sb.append("import com.github.pagehelper.PageHelper;\r\n");
		sb.append("import com.xjl.pt.core.service.XJLService;\r\n");
		sb.append("import com.xjl.pt.core.domain.XJLDomain;\r\n");
		sb.append("import " + domainPackage + "." + domainName + ";\r\n");
		sb.append("import " + mapperPackage + "." + mapperName + ";\r\n");
		sb.append("\r\n");
		sb.append("/**\r\n");
		sb.append(" * " + table.getTableDesc() + "\r\n");
		sb.append(" * @author ServiceCoderTools " +System.getProperties().getProperty("user.name")+"\r\n");
		sb.append(" *\r\n");
		sb.append(" */\r\n");
		sb.append("@Service\r\n");
		sb.append("public class " + serviceName + " extends XJLService {\r\n");
		sb.append("\t@Autowired\r\n");
		sb.append("\tprivate " + mapperName + " " + StringUtils.uncapitalize(mapperName) + ";\r\n");
		sb.append(add(mapperName));
		sb.append(delete(mapperName));
		sb.append(modify(mapperName));
		sb.append(query(mapperName, domainName));
		sb.append(queryById(mapperName, domainName, fieldList));
		sb.append(resetNewId(mapperName, domainName, fieldList));
		sb.append("}\r\n");
		return sb.toString();
	}
	private static String resetNewId(String mapperName,String domainName,List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Override\r\n");
		sb.append("\tpublic void _resetNewId(XJLDomain domain) {\r\n");
		for (TableField tableField : fieldList) {
			if (TableField.FIELD_TYPE_PK.equals(tableField.getFieldType())){
				sb.append("\t\t((" + domainName + ")domain).set" + XJLCoderTools.getDomainName(tableField.getFieldName()) + "(UUID.randomUUID().toString());\r\n");
				break;
			}
		}
		
		sb.append("\t}\r\n");
		return sb.toString();
	}
	private static String queryById(String mapperName,String domainName,List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		for (TableField tableField : fieldList) {
			if (TableField.FIELD_TYPE_PK.equals(tableField.getFieldType())){
				sb.append("\tpublic " + domainName + " queryById(String " + XJLCoderTools.getDomainFieldName(tableField.getFieldName()) + ") {\r\n");
				sb.append("\t\treturn this." + StringUtils.uncapitalize(mapperName) + ".selectById(" + XJLCoderTools.getDomainFieldName(tableField.getFieldName()) + ");\r\n");
				sb.append("\t}\r\n");
				break;
			}
		}
		return sb.toString();
	}
	private static String query(String mapperName,String domainName){
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic List<" + domainName + "> query(String search, int page, int pageSize) {\r\n");
		sb.append("\t\tif (StringUtils.isEmpty(search)){\r\n");
		sb.append("\t\t\tPageHelper.startPage(page, pageSize);\r\n");
		sb.append("\t\t\treturn this." + StringUtils.uncapitalize(mapperName) + ".selectAll();\r\n");
		sb.append("\t\t} else {\r\n");
		sb.append("\t\t\tthrow new RuntimeException(\"带search值的查询还没有实现\");\r\n");
		sb.append("\t\t}\r\n");
		sb.append("\t}\r\n");
		return sb.toString();
	}
	private static String modify(String mapperName){
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Override\r\n");
		sb.append("\tpublic void _modify(XJLDomain domain) {\r\n");
		sb.append("\t\tthis." + StringUtils.uncapitalize(mapperName) + ".update(domain);\r\n");
		sb.append("\t}\r\n");
		return sb.toString();
	}
	private static String delete(String mapperName){
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Override\r\n");
		sb.append("\tpublic void _delete(XJLDomain domain) {\r\n");
		sb.append("\t\tthis." + StringUtils.uncapitalize(mapperName) + ".delete(domain);\r\n");
		sb.append("\t}\r\n");
		return sb.toString();
	}
	private static String add(String mapperName){
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Override\r\n");
		sb.append("\tpublic void _add(XJLDomain domain) {\r\n");
		sb.append("\t\tthis." + StringUtils.uncapitalize(mapperName) + ".insert(domain);\r\n");
		sb.append("\t}\r\n");
		return sb.toString();
	}
}
