package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 用户类
 * @author li.lisheng
 *
 */
public interface UserMapper {
	static final String TABLE_NAME = "xjl_pt_user";
	@Insert("insert into " + TABLE_NAME + "(user_id,user_name," + XJLMapper.FIX_INSERT_FIELD +")"
			+ "values(#{userId},#{userName}," + XJLMapper.FIX_INSERT_VALUE + ")")
	public void insert(XJLDomain domain);
	@Select("select user_id as userId, user_name userName," + XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where state='A'")
	public List<User> selectAll();
	@Select("select user_id as userId, user_name userName," + XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where user_id=#{userId}")
	public User selectById(String userId);
	@Delete("update " + TABLE_NAME + " set "+XJLMapper.FIX_DELETE_FIELD + " where user_id=#{userId}")
	public void delete(XJLDomain domain);
}
