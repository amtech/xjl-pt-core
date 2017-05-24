package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.UserPwd;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 用户密码数据持久层
 * @author guan.zheyuan
 */
@Repository
public interface UserPwdMapper {
	static final String TABLE_NAME = "xjl_pt_user_password";
	static final String STATE_VALID="A";
	
	/**
	 * 执行新增插入操作
	 * @param userPwd
	 */
	@Insert("insert into "+TABLE_NAME+"(user_id,password,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{password},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	/**
	 * 执行更新操作
	 * @param domain
	 */
	@Delete("update "+TABLE_NAME+" set user_id=#{userId},"+XJLMapper.FIX_DELETE_FIELD+" where master=#{master}")
	public void delete(XJLDomain domain);
	/**
	 * 得到信息
	 */
	@Select("select user_id,password,"+XJLMapper.FIX_SELECT_FIELD+" from "+TABLE_NAME+"  where master=#{master} and state='"+STATE_VALID+"'")
	public UserPwd selectByMaster(XJLDomain domain);
}
