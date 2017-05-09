package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.Org;
import com.xjl.pt.core.domain.XJLDomain;

@Repository
public interface OrgMapper {
	static final String TABLE_NAME = "xjl_pt_org";
	@Insert("insert into " + TABLE_NAME + "(org_name," + XJLMapper.FIX_INSERT_FIELD + ")"
			+ " values(#{orgName}," + XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain org);
	@Select("select org_name as orgName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from xjl_pt_org where state='A'")
	public List<Org> select();
	@Delete("update xjl_pt_org set " + XJLMapper.FIX_DELETE_FIELD + " where org=#{org}")
	public void delete(XJLDomain org);
	@Select("select org_name as orgName, "
			+ XJLMapper.FIX_SELECT_FIELD + " from xjl_pt_org where org=#{org}")
	public Org selectById(String org);
}
