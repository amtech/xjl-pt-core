package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.CdCredit;
/**
 * 征信库
 * @author MapperCoderTools Arthur
 *
*/
@Repository
public interface CdCreditMapper {
	static final String TABLE_NAME = "xjl_cd_credit";
	static final String SELECT_ALL = "credit_id as creditId,credit_entity_type as creditEntityType,credit_entity_no as creditEntityNo,credit_entity_score as creditEntityScore,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "credit_id,credit_entity_type,credit_entity_no,credit_entity_score," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{creditId},#{creditEntityType},#{creditEntityNo},#{creditEntityScore}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "credit_entity_type=#{creditEntityType},credit_entity_no=#{creditEntityNo},credit_entity_score=#{creditEntityScore}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where credit_id=#{creditId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where credit_id=#{creditId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<CdCredit> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where credit_id=#{creditId}")
	public CdCredit selectById(String dictId);
	
	
	
}