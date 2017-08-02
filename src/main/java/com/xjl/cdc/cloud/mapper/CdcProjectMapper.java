package com.xjl.cdc.cloud.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.xjl.cdc.cloud.domain.CdcProject;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.XJLMapper;

@Repository
public interface CdcProjectMapper {
	static final String TABLE_NAME = "xjl_cdc_project";
	static final String TABLE_NAME_REL = "xjl_cdc_project_module";
	static final String SELECT_ALL = "project_id as projectId,project_name as projectName,project_state as projectState,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "project_id,project_name,project_state," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{projectId},#{projectName},#{projectState}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "project_name=#{projectName},project_state=#{projectState}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where project_id=#{projectId}")
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where project_id=#{projectId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<CdcProject> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where project_id=#{projectId}")
	public CdcProject selectById(String dictId);
}
