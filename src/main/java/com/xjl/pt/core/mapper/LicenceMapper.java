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
	static final String SELECT_ALL="licence_id,licence_name,licence_category,licence_org,issuing_date,expiration_date,licence_status,owner_no,owner_type,licence_source_type,licence_trust_level,licence_file_url,licence_file_type,"+XJLMapper.FIX_SELECT_FIELD;
	/**
	 * 查询所有有效证照
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state ='A' order by create_date desc ")
	public List<Licence> selectAll();
	
	/**
	 * 通过证照编号得到证照信息
	 */
	@Select("select count(*) from "+TABLE_NAME+" where  state='A' and licence_id=#{licenceId}")
	public int selectCountByLicenceid(String licenceId);
	
	/**
	 * 执行插入
	 * @param domain
	 */
	@Insert("insert into "+TABLE_NAME+"(licence_id,licence_name,licence_category,licence_org,issuing_date,expiration_date,licence_status,owner_no,owner_type,licence_source_type,licence_trust_level,licence_file_url,licence_file_type,"+XJLMapper.FIX_INSERT_FIELD+")"
			+ "values(#{licenceId},#{licenceName},#{licenceCategory},#{licenceOrg},#{issuingDate},#{expirationDate},#{licenceStatus},#{ownerOn},#{ownerType},#{licenceSourceType},#{licenceTrustLevel},#{licenceFileUrl},#{licenceFileType},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
}
