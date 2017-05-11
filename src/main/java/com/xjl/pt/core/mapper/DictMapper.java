package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.XJLDomain;

@Repository
public interface DictMapper {
	static final String TABLE_NAME = "xjl_pt_dict";
	@Insert("insert into " + TABLE_NAME + "(dict_id,dict_name," + XJLMapper.FIX_INSERT_FIELD + ")"
			+ " values(#{dictId},#{dictName}," + XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select dict_id as dictId, dict_name as dictName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where state='A' order by dict_name")
	public List<Dict> selectAll();
	@Select("select dict_id as dictId, dict_name as dictName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where state='A' and dict_name like '%'||#{dictName}||'%' order by dict_name")
	public List<Dict> selectByName(String dictName);
	
	@Select("select dict_id as dictId, dict_name as dictName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where dict_id=#{dictId}")
	public Dict selectById(String dictId);
	@Delete("update " + TABLE_NAME + " set "+XJLMapper.FIX_DELETE_FIELD + " where dict_id=#{dictId}")
	public void delete(XJLDomain domain);
}
