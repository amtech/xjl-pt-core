package com.xjl.cdc.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.xjl.cdc.cloud.domain.CdcProjectModule;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.XJLMapper;

@Repository
public interface CdcProjectModuleMapper {
	static final String TABLE_NAME = "xjl_cdc_project_module";
	static final String SELECT_ALL = "module_id as moduleId,module_name as moduleName,module_url as moduleUrl,module_state as moduleState,project_id as projectId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "module_id,module_name,module_url,module_state,project_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{moduleId},#{moduleName},#{moduleUrl},#{moduleState},#{projectId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "module_name=#{moduleName},module_url=#{moduleUrl},module_state=#{moduleState},project_id=#{projectId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where module_id=#{moduleId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where project_id=#{projectId}")	
	public void deleteByProjectId(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where module_id=#{moduleId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<CdcProjectModule> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where module_id=#{moduleId}")
	public CdcProjectModule selectById(String creditItemId);
	@Select("select count(1) from "+TABLE_NAME+" where state='A' and project_id = #{projectId}")
	public int selectByProjectId(String projectId);
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state='A' and project_id = #{projectId} ")
	public List<CdcProjectModule> selectProjectModuleByProjectId(String projectId);
	
}
