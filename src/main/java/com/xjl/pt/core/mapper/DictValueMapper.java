package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.DictValue;
import com.xjl.pt.core.domain.XJLDomain;

@Repository
public interface DictValueMapper {
	static final String TABLE_NAME = "xjl_pt_dict_value";
	@Insert("insert into " + TABLE_NAME + "(dict_id,dict_value_id,dict_value_code,dict_value_name," + XJLMapper.FIX_INSERT_FIELD + ")"
			+ " values(#{dictId},#{dictValueId},#{dictValueCode},#{dictValueName}," + XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select dict_id as dictId, dict_value_id as dictValueId,dict_value_code as dictValueCode,dict_value_name as dictValueName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where dict_id=#{dictId} and state='A'")
	public List<DictValue> selectByDictId(String dictId);
	@Select("select count(*) from " + TABLE_NAME  + " where dict_id=#{dictId} and state='A'")
	public int selectCountByDictId(String dictId);
}
