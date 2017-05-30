package com.xjl.pt.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 数据库字段的定义
 * @author leasonlive
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface  FieldDB {
	/**
	 * 列的名称
	 * @return
	 */
	public String name();
	/**
	 * 列的类型，如varchar(20),date,int(10)等
	 * @return
	 */
	public String type();
}