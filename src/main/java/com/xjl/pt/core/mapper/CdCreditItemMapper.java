package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.CdCreditItem;
/**
 * 征信条目
 * @author MapperCoderTools Arthur
 *
*/
@Repository
public interface CdCreditItemMapper {
	static final String TABLE_NAME = "xjl_cd_credit_item";
	static final String SELECT_ALL = "credit_item_id as creditItemId,credit_item_name as creditItemName,credit_item_score as creditItemScore,credit_item_content as creditItemContent,credit_id as creditId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "credit_item_id,credit_item_name,credit_item_score,credit_item_content,credit_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{creditItemId},#{creditItemName},#{creditItemScore},#{creditItemContent},#{creditId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "credit_item_name=#{creditItemName},credit_item_score=#{creditItemScore},credit_item_content=#{creditItemContent},credit_id=#{creditId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where credit_item_id=#{creditItemId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where credit_item_id=#{creditItemId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<CdCreditItem> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where credit_item_id=#{creditItemId}")
	public CdCreditItem selectById(String creditItemId);
	@Select("select count(1) from "+TABLE_NAME+" where state='A' and credit_id = #{creditId}")
	public int selectByCreditId(String creditId);
	@Select("select "+SELECT_ALL+" from "+TABLE_NAME+" where state='A' and credit_id = #{creditId} ")
	public List<CdCreditItem> selectCreditItemByCreditId(String creditId);
	
	
	
}