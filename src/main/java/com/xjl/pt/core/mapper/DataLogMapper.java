package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.DataLog;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 数据日志
 * @author lilisheng
 *
 */
@Repository
public interface DataLogMapper {
	static final String TABLE_NAME = "xjl_pt_data_log";
	@Insert("insert into " + TABLE_NAME + "(table_name,master_value,data_json,operate_user_id,operate_date,operate_type," + XJLMapper.FIX_INSERT_FIELD + ")"
			+ " values(#{tableName},#{masterValue},#{dataJson},#{operateUserId},#{operateDate},#{operateType}," + XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select table_name as tableName,masterValue as masterValue,data_json as dataJson,"
			+ "operate_user_id as operateUserId,operate_date as operateDate,operate_type as operate_type,"
			+ XJLMapper.FIX_SELECT_FIELD + " from " + TABLE_NAME + " where table_name=#{1} and master_value=#{2}")
	public List<DataLog> select(String tableName,String masterValue);
}
