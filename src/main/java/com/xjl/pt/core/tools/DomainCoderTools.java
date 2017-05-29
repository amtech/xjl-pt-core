package com.xjl.pt.core.tools;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.xjl.pt.core.domain.TableField;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * domain对象生成工具类
 * @author lilisheng
 *
 */
public class DomainCoderTools {
	public static final String generateDomainContent(String domainPackage, String domainName,String domainDesc,List<TableField> fieldList){
		StringBuffer sb = new StringBuffer();
		StringBuffer setgetSb = new StringBuffer();
		sb.append("package "+domainPackage +";\r\n");
		sb.append("import com.xjl.pt.core.domain.XJLDomain;\r\n");
		sb.append("import java.util.Date;\r\n");
		sb.append("/**\r\n");
		sb.append("* " + domainDesc + "\r\n");
		sb.append("* @author DomainCoderTools\r\n");
		sb.append("*\r\n");
		sb.append("*/\r\n");
		sb.append("public class " + domainName + " extends XJLDomain {\r\n");
		for (TableField tableField : fieldList) {
			String domainFieldType = XJLCoderTools.getDomainFieldType(tableField.getFieldType());
			String domainFieldName = XJLCoderTools.getDomainFieldName(tableField.getFieldName());
			sb.append("\t//" + tableField.getFieldDesc()+"\r\n");
			sb.append("\tprivate "+domainFieldType + " " + domainFieldName+";\r\n");
			setgetSb.append(generateGetSetMethod(domainFieldName, domainFieldType));
			if (TableField.FIELD_TYPE_DICT.equals(tableField.getFieldType()) ||
					TableField.FIELD_TYPE_FK.equals(tableField.getFieldType())){
				String field$Name = domainFieldName+"$name";
				sb.append("\t//" + tableField.getFieldDesc()+" 对应的名称，非数据库字段\r\n");
				sb.append("\tprivate String " + field$Name+";\r\n");
				setgetSb.append(generateGetSetMethod(field$Name, "String"));
			}
			
		}
		sb.append(setgetSb);
		sb.append("}\r\n");
		return sb.toString();
	}
	public static String generateGetSetMethod(String domainFieldName, String domainFieldType){
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic void set" + StringUtils.capitalize(domainFieldName)+"("+domainFieldType + " " + domainFieldName + "){\r\n");
		sb.append("\t\tthis." + domainFieldName +" = "+domainFieldName+";\r\n");
		sb.append("\t}\r\n");
		sb.append("\tpublic " + domainFieldType + " get"+StringUtils.capitalize(domainFieldName)+"(){\r\n");
		sb.append("\t\treturn this." + domainFieldName+";\r\n");
		sb.append("\t}\r\n");
		return sb.toString();
	}
}
