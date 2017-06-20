package com.xjl.pt.core.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xjl.pt.core.domain.Licence;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 证照信息
 * @author guan.zheyuan
 */ 
public interface LicenceMapper {
	static final String TABLE_NAME="xjl_zz_licence"; 
	static final String SELECT_ALL="licence_id as licenceId,licence_name as licenceName  ,licence_category as licenceCategory,licence_org,issuing_date as issuingDate,expiration_date as expirationDate ,licence_status as licenceStatus,owner_no as ownerOn,owner_type as ownerType,licence_source_type as licenceSourceType,licence_trust_level as licenceTrustLevel,licence_file_url as licenceFileUrl,licence_file_type as licenceFileType,licence_error_content as licenceErrorContent,"+XJLMapper.FIX_SELECT_FIELD;
	/**
	 * 查询所有有效证照
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state ='A' order by create_date desc ")
	public List<Licence> selectAll();
	
	/**
	 * 得到用户纠错信息
	 * @return
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state='A' and licence_status in ('06','07') order by  create_date desc  ")
	public List<Licence>selectAllForError();
	
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
	
	/**
	 * 通过ownid得到证照的ftp位置
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where  state='A' and owner_no=#{ownerOn}")
	public List<Licence> selectUrlByOwnid(String ownerNo);
	
	/**
	 * 通过证照编号得到证照信息
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where licence_id=#{licenceId}")
	public Licence selectByLicenceId(String licenceId);
	
	/**
	 * 修改证照信息
	 * @param domain
	 */
	@Update("update "+TABLE_NAME+" set licence_name =#{licenceName},issuing_date=#{issuingDate},expiration_date=#{expirationDate},licence_file_url=#{licenceFileUrl},licence_status=#{licenceStatus} where licence_id =#{licenceId}")
	public void update(XJLDomain domain);
	
	/**
	 * 逻辑删除数据
	 */
	@Delete("update "+TABLE_NAME+" set "+XJLMapper.FIX_DELETE_FIELD+" where licence_id=#{licenceId}")
	public void delete(XJLDomain domain);
	
	/**
	 * 增加纠错信息
	 * @param domain
	 */
	@Update("update "+TABLE_NAME+" set licence_error_content=#{licenceErrorContent},licence_status=#{licenceStatus} where licence_id=#{licenceId}")
	public void insertErrorContent(XJLDomain domain);
	
	
}
