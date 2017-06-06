package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.TableField;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 字段
 * @author lilisheng
 *
 */
@Repository
public interface TableFieldMapper {
	public static final String TABLE_NAME="XJL_PT_TABLE_FIELD";
	public static final String SELECT_SQL="select field_id as fieldId,field_name as fieldName,field_desc as fieldDesc"
			+ ",field_comment as fieldComment,field_type as fieldType,field_length as fieldLength"
			+ ",dict_id as dictId, table_id as tableId,foreign_table_id foreignTableId"
			+ ","+XJLMapper.FIX_SELECT_FIELD
			+ " from " + TABLE_NAME;
	
	@Insert("insert into " + TABLE_NAME +"("
			+ "field_id,field_name,field_desc,field_comment,field_type,"
			+ "field_length,dict_id,table_id,foreign_table_id,"+ XJLMapper.FIX_INSERT_FIELD
			+ ") values("
			+ "#{fieldId},#{fieldName},#{fieldDesc},#{fieldComment},#{fieldType},"
			+ "#{fieldLength},#{dictId},#{tableId},#{foreignTableId},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain field);
	@Select(SELECT_SQL + " where table_id=#{tableId} and state='A'")
	public List<TableField> selectByTableId(String tableId);
	@Select("select count(*) from " + TABLE_NAME + " where table_id=#{tableId} and state='A'")
	public int selectCountByTableId(String tableId);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where field_id=#{fieldId}")
	public void delete(XJLDomain field);
	@Update("update " + TABLE_NAME + " set field_name=#{fieldName},field_desc=#{fieldDesc},"
			+ "field_comment=#{fieldComment},field_type=#{fieldType},field_length=#{fieldLength},dict_id=#{dictId},"
			+ "foreign_table_id=#{foreignTableId},"+XJLMapper.FIX_UPDATE_FIELD
			+ " where field_id=#{fieldId}")
	public void update(XJLDomain field);
	@Select(SELECT_SQL + " where field_id=#{fieldId}")
	public TableField selectById(String fieldId);
	@Select(SELECT_SQL + " where table_id=#{0} AND field_name=#{1}")
	public TableField selectByTableIdAndFieldName(String tableId, String fieldName);
}
