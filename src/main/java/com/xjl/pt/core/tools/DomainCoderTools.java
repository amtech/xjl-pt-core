package com.xjl.pt.core.tools;

import com.xjl.pt.core.domain.XJLDomain;
/**
 * domain对象生成工具类
 * @author lilisheng
 *
 */
public class DomainCoderTools {
	public static final String generateDomainContent(String domainPackage, String domainName,String domainDesc){
		StringBuffer sb = new StringBuffer();
		sb.append("package "+domainPackage +";\r\n");
		sb.append("import com.xjl.pt.core.domain.XJLDomain;\r\n");
		sb.append("import java.util.Date;\r\n");
		sb.append("/**\r\n");
		sb.append("* " + domainDesc + "\r\n");
		sb.append("* @author DomainCoderTools\r\n");
		sb.append("*\r\n");
		sb.append("*/\r\n");
		sb.append("public class " + domainName + " extends XJLDomain {\r\n");
		sb.append("}\r\n");
		return sb.toString();
	}
}
