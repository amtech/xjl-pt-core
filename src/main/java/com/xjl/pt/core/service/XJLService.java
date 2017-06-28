package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.xjl.pt.core.annotation.TableDB;
import com.xjl.pt.core.domain.DataLog;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 服务类通用方法
 * @author li.lisheng
 *
 */
public abstract  class XJLService extends XJLBaseService{
	private static Log log = LogFactory.getLog(XJLService.class);
	@Autowired
	private DataLogService dataLogService;
	/**
	 * 赋值，保存数据库，保存日志
	 * @param domain
	 * @param user
	 */
	@Override
	public final void add(XJLDomain domain, User user){
		super.add(domain, user);
		//this.addDataLog(domain, user, DataLog.OPERATE_TYPE_ADD);
		
	}
	
	/**
	 * 删除一条数据，实际上是把该数据的状态改为X，并记录修改人和修改时间
	 */
	public final void delete(XJLDomain domain, User user){
		super.delete(domain, user);
		//this.addDataLog(domain, user, DataLog.OPERATE_TYPE_DELETE);
	}
	/**
	 * 赋值，记录修改人和修改时间
	 * 保存数据库
	 * 保存日志
	 */
	@Override
	public final void modify(XJLDomain domain, User user){
		super.modify(domain, user);
		//this.addDataLog(domain, user, DataLog.OPERATE_TYPE_MODIFY);
	}
	/**
	 * 增加数据日志记录
	 * @param domain
	 * @param user
	 * @param operateType
	 */
	protected void addDataLog(XJLDomain domain, User user, String operateType){
		//添加完成之后记录日志
		DataLog dataLog = new DataLog();
		Class domainClass = domain.getClass();
		String tableName = domainClass.getSimpleName();
		TableDB tableDB = (TableDB)domain.getClass().getAnnotation(TableDB.class);
		if (tableDB != null){
			tableName = tableDB.name();
		}
		dataLog.setTableName(tableName);
		dataLog.setMasterValue(domain.getMaster());
		dataLog.setDataJson(JSON.toJSONString(domain));
		dataLog.setOperateDate(Calendar.getInstance().getTime());
		dataLog.setOperateType(operateType);
		dataLog.setOperateUserId(user.getUserId());
		this.dataLogService.add(dataLog, user);
	}
	
}
