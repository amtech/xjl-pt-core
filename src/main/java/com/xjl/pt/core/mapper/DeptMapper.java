package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.Dept;
/**
 * 部门表
 * @author MapperCoderTools
 *
*/
@Repository
public interface DeptMapper {
	static final String TABLE_NAME = "xjl_pt_dept";
	static final String SELECT_ALL = "dept_name as deptName,dept_id as deptId,parent_dept_id as parentDeptId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "dept_name,dept_id,parent_dept_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{deptName},#{deptId},#{parentDeptId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "dept_name = #{deptName},parent_dept_id = #{parentDeptId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<Dept> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where dept_id = #{deptId}")
	public Dept selectById(String dictId);
	
	
	
}