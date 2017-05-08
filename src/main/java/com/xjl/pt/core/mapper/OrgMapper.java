package com.xjl.pt.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.Org;

@Repository
public interface OrgMapper {
	@Insert("insert into xjl_pt_org(org,org_name)"
			+ " values(#{org},#{orgName}")
	public void insert(Org org);
	@Select("select org as org, org_name as orgName from xjl_pt_core")
	public List<Org> select();
	@Delete("delete from xjl_pt_core where org=#{org}")
	public void delete(String org);
}
