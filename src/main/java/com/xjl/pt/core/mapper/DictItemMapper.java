package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.DictItem;
import com.xjl.pt.core.domain.XJLDomain;

@Repository
public interface DictItemMapper {
	static final String TABLE_NAME = "xjl_pt_dict_item";
	@Insert("insert into " + TABLE_NAME + "(dict_id,dict_item_id,dict_item_code,dict_item_name," + XJLMapper.FIX_INSERT_FIELD + ")"
			+ " values(#{dictId},#{dictItemId},#{dictItemCode},#{dictItemName}," + XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select dict_id as dictId, dict_item_id as dictItemId,dict_item_code as dictItemCode,dict_item_name as dictItemName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where dict_id=#{dictId} and state='A'")
	public List<DictItem> selectByDictId(String dictId);
	@Select("select dict_id as dictId, dict_item_id as dictItemId,dict_item_code as dictItemCode,dict_item_name as dictItemName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where dict_id=#{0} and (dict_item_code like '%'||#{1}||'%' or dict_item_name like '%'||#{1}||'%') and state='A'")
	public List<DictItem> selectByDictIdWithSearch(String dictId,String search);
	@Select("select count(*) from " + TABLE_NAME  + " where dict_id=#{dictId} and state='A'")
	public int selectCountByDictId(String dictId);
}
