package com.xjl.pt.core.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.xjl.pt.core.domain.Licence;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 证照信息
 * @author guan.zheyuan
 */
public interface LicenceMapper {
	static final String TABLE_NAME="xjl_zz_licence"; 
	static final String SELECT_ALL="license_id,license_name,license_category,license_org,issuing_date,expiration_date,license_status,owner_no,owner_type,license_source_type,license_trust_level,license_content_url,license_file_url,license_file_type,"+XJLMapper.FIX_SELECT_FIELD;
	/**
	 * 查询所有有效证照
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state ='A' order by create_date desc ")
	public List<Licence> selectAll();
	
	/**
	 * 通过证照编号得到证照信息
	 */
	@Select("select count(*) from "+TABLE_NAME+" where  state='A' and license_id=#{licenseId}")
	public int selectCountByLicenceid(String licenseId);
	
	/**
	 * 执行插入
	 * @param domain
	 */
	@Insert("insert into "+TABLE_NAME+"(license_id,license_name,license_category,license_org,issuing_date,expiration_date,license_status,owner_no,owner_type,license_source_type,license_trust_level,license_content_url,license_file_url,license_file_type,"+XJLMapper.FIX_INSERT_FIELD+")"
			+ "values(#{licenseId},#{licenseName},#{licenseCategory},#{licenseOrg},#{issuingDate},#{expirationDate},#{licenseStatus},#{ownerOn},#{ownerType},#{licenseSourceType},#{licenseTrustLevel},#{licenseContentUrl},#{licenseFileUrl},#{licenseFileType},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
}
