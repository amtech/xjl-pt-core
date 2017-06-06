package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.Table;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 表
 * @author lilisheng
 *
 */
@Repository
public interface TableMapper {
	public static final String TABLE_NAME="XJL_PT_TABLE";
	@Insert("insert into " + TABLE_NAME +"(table_id,table_name,table_desc,"+ XJLMapper.FIX_INSERT_FIELD
			+ ") values(#{tableId},#{tableName},#{tableDesc},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain table);
	@Select("select table_id as tableId,table_name as tableName,table_desc as tableDesc"
			+ ","+XJLMapper.FIX_SELECT_FIELD
			+ " from " + TABLE_NAME + " where state='A'")
	public List<Table> selectAll();
	@Select("select table_id as tableId,table_name as tableName,table_desc as tableDesc"
			+ ","+XJLMapper.FIX_SELECT_FIELD
			+ " from " + TABLE_NAME + " where table_id=#{tableId}")
	public Table selectById(String tableId);
	@Select("select table_id as tableId,table_name as tableName,table_desc as tableDesc"
			+ ","+XJLMapper.FIX_SELECT_FIELD
			+ " from " + TABLE_NAME + " where table_name=#{tableName}")
	public Table selectByName(String tableName);
	@Update("update " + TABLE_NAME + " set "+ XJLMapper.FIX_DELETE_FIELD + " where table_id=#{tableId}")
	public void delete(XJLDomain table);
	@Update("update " + TABLE_NAME + " set "
			+ "table_name = #{tableName},table_desc = #{tableDesc}, "
			+ XJLMapper.FIX_UPDATE_FIELD 
			+" where table_id=#{tableId}")
	public void update(XJLDomain table);
	@Select("select table_id as tableId,table_name as tableName,table_desc as tableDesc"
			+ ","+XJLMapper.FIX_SELECT_FIELD
			+ " from " + TABLE_NAME + " where table_name like '%'||#{search}||'%' or table_desc like '%'||#{search}||'%'" )
	public List<Table> selectBySearch(String search);
}
