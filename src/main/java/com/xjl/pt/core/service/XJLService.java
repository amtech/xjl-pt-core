package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;

import org.codehaus.jackson.JsonFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.xjl.pt.core.domain.DataLog;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 服务类通用方法
 * @author li.lisheng
 *
 */
public abstract class XJLService extends XJLBaseService{
	@Autowired
	private DataLogService dataLogService;
	/**
	 * 设置固定字段的值
	 * @param domain
	 * @param user
	 */
	public void add(XJLDomain domain, User user){
		super.add(domain, user);
		//添加完成之后记录日志
		DataLog dataLog = new DataLog();
		dataLog.setTableName(domain.getClass().getName());
		dataLog.setMasterValue(domain.getMaster());
		dataLog.setDataJson(JSON.toJSONString(domain));
		dataLog.setOperateDate(domain.getCreateDate());
		dataLog.setOperateType(DataLog.OPERATE_TYPE_ADD);
		dataLog.setOperateUserId(domain.getCreateUserId());
		this.dataLogService.add(dataLog, user);
		
	}
	/**
	 * 删除一条数据，实际上是把该数据的状态改为X，并记录修改人和修改时间
	 */
	public void delete(XJLDomain domain, User user){
		super.delete(domain, user);
		//删除完成之后记录日志
		DataLog dataLog = new DataLog();
		dataLog.setTableName(domain.getClass().getName());
		dataLog.setMasterValue(domain.getMaster());
		dataLog.setDataJson(JSON.toJSONString(domain));
		dataLog.setOperateDate(domain.getCancelDate());
		dataLog.setOperateType(DataLog.OPERATE_TYPE_DELETE);
		dataLog.setOperateUserId(domain.getCancelUserId());
		this.dataLogService.add(dataLog, user);
	}
	/**
	 * 修改记录，先删除原有记录，再添加一条新的记录
	 */
	public void modify(XJLDomain domain, User user){
		super.modify(domain, user);
		DataLog dataLog = new DataLog();
		dataLog.setTableName(domain.getClass().getName());
		dataLog.setMasterValue(domain.getMaster());
		dataLog.setDataJson(JSON.toJSONString(domain));
		dataLog.setOperateDate(domain.getCancelDate());
		dataLog.setOperateType(DataLog.OPERATE_TYPE_MODIFY);
		dataLog.setOperateUserId(domain.getCancelUserId());
		this.dataLogService.add(dataLog, user);
	}
}
