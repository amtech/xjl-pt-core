package com.xjl.pt.core.service;

import java.util.Calendar;
import java.util.UUID;

import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 服务类通用方法
 * @author li.lisheng
 *
 */
public abstract class XJLService {
	/**
	 * 设置固定字段的值
	 * @param domain
	 * @param user
	 */
	public void add(XJLDomain domain, User user){
		domain.setOrg(user.getOrg());
		domain.setMaster(UUID.randomUUID().toString());
		domain.setCreateUserId(user.getUserId());
		domain.setCreateDate(Calendar.getInstance().getTime());
		domain.setCancelDate(null);
		domain.setCancelUserId(null);
		domain.setState(XJLDomain.StateType.A.name());
		this._resetNewId(domain);
		_add(domain);
	}
	/**
	 * 每个之类自己实现具体往数据中添加的方法
	 */
	abstract void _add(XJLDomain domain);
	/**
	 * 删除一条数据，实际上是把该数据的状态改为X，并记录修改人和修改时间
	 */
	public void delete(XJLDomain domain, User user){
		domain.setCancelDate(Calendar.getInstance().getTime());
		domain.setCancelUserId(user.getUserId());
		domain.setState(XJLDomain.StateType.X.name());
		this._delete(domain);
	}
	/**
	 * 删除一个domain
	 * @param domain
	 */
	abstract void _delete(XJLDomain domain);
	/**
	 * 修改记录，先删除原有记录，再添加一条新的记录
	 */
	public void modify(XJLDomain domain, User user){
		this.delete(domain,user);
		
		domain.setCreateUserId(user.getUserId());
		domain.setCreateDate(Calendar.getInstance().getTime());
		domain.setCancelDate(null);
		domain.setCancelUserId(null);
		domain.setState(XJLDomain.StateType.A.name());
		this._resetNewId(domain);
		this._add(domain);
	}
	/**
	 * 重新设置ID，也就是生成一个新的ID
	 * @param domain
	 */
	abstract void _resetNewId(XJLDomain domain);
}
