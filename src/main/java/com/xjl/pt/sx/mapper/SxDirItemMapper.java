package com.xjl.pt.sx.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.sx.domain.SxDirItem;
/**
 * 事项目录清单
 * @author MapperCoderTools lilisheng
 *
*/
@Repository
public interface SxDirItemMapper {
	static final String TABLE_NAME = "xjl_sx_dir_item";
	static final String SELECT_ALL = "item_type as itemType,according as according,base_code as baseCode,item_name as itemName,item_id as itemId,item_state as itemState,item_version as itemVersion,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "item_type,according,base_code,item_name,item_id,item_state,item_version," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{itemType},#{according},#{baseCode},#{itemName},#{itemId},#{itemState},#{itemVersion}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "item_type=#{itemType},according=#{according},base_code=#{baseCode},item_name=#{itemName},item_state=#{itemState},item_version=#{itemVersion}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where item_id=#{itemId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where item_id=#{itemId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<SxDirItem> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where item_id=#{itemId}")
	public SxDirItem selectById(String dictId);
	
	
	
}