package com.xjl.pt.core.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xjl.pt.core.domain.License;

/**
 * 证照信息
 * @author guan.zheyuan
 */
public interface LicenseMapper {
	static final String TABLE_NAME="xjl_zz_license"; 
	static final String SELECT_ALL="license_id,license_name,license_category,license_org,issuing_date,expiration_date,license_status,owner_no,owner_type,license_source_type,license_trust_level,license_content_url,license_file_url,license_file_type,"+XJLMapper.FIX_SELECT_FIELD;
	/**
	 * 查询所有有效证照
	 * @return
	 */
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state ='A' order by create_date desc ")
	public List<License> selectAll();
}
