package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZzCatalog;
/**
 * 个人空间库证照目录
 * @author MapperCoderTools 陶杰
 *
*/
@Repository
public interface ZzCatalogMapper {
	static final String TABLE_NAME = "xjl_zz_catalog";
	static final String SELECT_ALL = "catalog_id as catalogId,catalog_name as catalogName,user_id as userId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "catalog_id,catalog_name,user_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{catalogId},#{catalogName},#{userId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "catalog_name=#{catalogName},user_id=#{userId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where catalog_id=#{catalogId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where catalog_id=#{catalogId}")	
	public void update(XJLDomain domain);
	/**
	 * 更新目录名称
	 * @param domain
	 */
	@Update("update " + TABLE_NAME + " set " + "catalog_name=#{catalogName} where catalog_id=#{catalogId}")	
	public void updateCatalogName(XJLDomain domain);
	
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<ZzCatalog> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where catalog_id=#{catalogId}")
	public ZzCatalog selectById(String dictId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where user_id=#{userId} and state='A'")
	public List<ZzCatalog> selectByUserId(String userId);
	
	
}