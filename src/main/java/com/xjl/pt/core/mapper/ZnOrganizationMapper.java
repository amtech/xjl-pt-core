package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZnOrganization;
/**
 * 办事指南实施机构
 * @author MapperCoderTools Arthur
 *
*/
@Repository
public interface ZnOrganizationMapper {
	static final String TABLE_NAME = "xjl_zn_organization";
	static final String SELECT_ALL = "organization_id as organizationId,impl_org as implOrg,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "organization_id,impl_org," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{organizationId},#{implOrg}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "organization_id=#{organizationId},impl_org=#{implOrg}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<ZnOrganization> selectAll();
	
	
	
}