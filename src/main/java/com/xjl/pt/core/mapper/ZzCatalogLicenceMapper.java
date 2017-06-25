package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZzCatalogLicence;
/**
 * 个人证照目录分类
 * @author MapperCoderTools 陶杰
 *
*/
@Repository
public interface ZzCatalogLicenceMapper {
	static final String TABLE_NAME = "xjl_zz_catalog_licence";
	static final String SELECT_ALL = "catalog_id as catalogId,licence_id as licenceId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "catalog_id,licence_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{catalogId},#{licenceId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "catalog_id=#{catalogId},licence_id=#{licenceId}," + XJLMapper.FIX_UPDATE_FIELD;
	/**
	 * 执行插入操作
	 * @param domain
	 */
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	/**
	 * 执行查询操作(全字段)
	 * @return
	 */
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<ZzCatalogLicence> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where catalog_id=#{catalogId} and state='A'")
	public List<ZzCatalogLicence> selectByCatalogId(String catalogId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where catalog_id=#{catalogId} and licence_id=#{licenceId}")
	public List<ZzCatalogLicence> selectByCatalogIdAndLicenceId(String catalogId,String licenceId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where licence_id=#{licenceId} ")
	public List<ZzCatalogLicence> selectByLicenceId(String licenceId);
	
	/**
	 * 逻辑删除数据
	 */
	@Delete("update "+TABLE_NAME+" set "+XJLMapper.FIX_DELETE_FIELD+" where licence_id=#{licenceId}")
	public void delete(XJLDomain domain);
}