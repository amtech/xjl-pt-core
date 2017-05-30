package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.Dict;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 字典
 * @author lilisheng
 *
 */
@Repository
public interface DictMapper {
	static final String TABLE_NAME = "xjl_pt_dict";
	static final String SELECT_ALL = "dict_id as dictId, dict_name as dictName, "+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "dict_id,dict_name," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{dictId},#{dictName}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "dict_name=#{dictName},"+XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by dict_name")
	public List<Dict> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' and dict_name like '%'||#{dictName}||'%' order by dict_name")
	public List<Dict> selectByName(String dictName);
	
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where dict_id=#{dictId}")
	public Dict selectById(String dictId);
	@Update("update " + TABLE_NAME + " set "+XJLMapper.FIX_DELETE_FIELD + " where dict_id=#{dictId}")
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where dict_id=#{dictId}")
	public void update(XJLDomain domain);
}
