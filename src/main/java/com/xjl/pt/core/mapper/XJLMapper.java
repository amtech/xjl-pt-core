package com.xjl.pt.core.mapper;

import org.apache.commons.lang3.StringUtils;

/**
 * 平台对固定字段的处理工具
 * @author li.lisheng
 *
 */
public class XJLMapper {
	/**
	 * 插入固定字段到sql语句中
	 * @param sql 正常的sql语句，不带固定的7个字段
	 * @return
	 */
	public static final String _insertFixField(String sql){
		int key = sql.indexOf(")");
		StringBuffer sb = new StringBuffer(sql);
		sb.insert(key, FIX_INSERT_FIELD);
		sb.insert(key, ",");
		int key2 = sb.lastIndexOf(")");
		sb.insert(key2,FIX_INSERT_VALUE);
		sb.insert(key2, ",");
		return sb.toString();
	}
	/**
	 * 执行软删除（更改状态为X，不实际删除）
	 * @param tableName 表名称
	 * @param condition 条件，不带where
	 * @return
	 */
	public static final String _deleteFixField(String tableName, String condition){
		if (StringUtils.isBlank(condition)){
			throw new RuntimeException("更新条件不能为空");
		}
		StringBuffer sb = new StringBuffer("update ");
		sb.append(tableName);
		sb.append(" set ");
		sb.append(XJLMapper.FIX_DELETE_FIELD);
		sb.append(" where ");
		sb.append(condition);
		return sb.toString();
	}
	/**
	 * 在select语句中增加固定字段
	 * @param sql
	 * @return
	 */
	public static final String _selectFixField(String sql){
		StringBuffer sb = new StringBuffer(sql);
		int key = sb.indexOf(" from ");
		sb.insert(key, FIX_SELECT_FIELD);
		sb.insert(key, ",");
		return sb.toString();
	}
	/**
	 * 在select语句中增加固定字段,并且增加state=A的条件
	 * @param sql
	 * @return
	 */
	public static final String _selectFixFieldWithState(String sql){
		StringBuffer sb = new StringBuffer(sql);
		int key = sb.indexOf(" from ");
		sb.insert(key, FIX_SELECT_FIELD);
		sb.insert(key, ",");
		if (sb.indexOf(" where ")>0){
			sb.append(" and state='A'");
		} else {
			sb.append(" where state='A'");
		}
		return sb.toString();
	}
	public static final String FIX_INSERT_FIELD="org,master,create_date,create_user_id,state";
	public static final String FIX_INSERT_VALUE="#{org},#{master},#{createDate},#{createUserId},#{state}";
	public static final String FIX_DELETE_FIELD="cancel_date=#{cancelDate},cancel_user_id=#{cancelUserId},state=#{state}";
	public static final String FIX_UPDATE_FIELD="cancel_date=#{cancelDate},cancel_user_id=#{cancelUserId}";
	public static final String FIX_SELECT_FIELD="org as org,master as master,create_date as createDate,create_user_id as createUserId,cancel_date as cancelDate,cancel_user_id as cancelUserId,state as state";
	
}
