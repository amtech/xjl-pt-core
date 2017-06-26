package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.BsStrategy;
/**
 * 办事攻略
 * @author MapperCoderTools 陶杰
 *
*/
@Repository
public interface BsStrategyMapper {
	static final String TABLE_NAME = "xjl_bs_strategy";
	static final String SELECT_ALL = "strategy_state as strategyState,strategy_content as strategyContent,strategy_title as strategyTitle,strategy_id as strategyId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "strategy_state,strategy_content,strategy_title,strategy_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{strategyState},#{strategyContent},#{strategyTitle},#{strategyId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "strategy_state=#{strategyState},strategy_content=#{strategyContent},strategy_title=#{strategyTitle},strategy_id=#{strategyId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL +" from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<BsStrategy> selectAll();
	@Update("update "+ TABLE_NAME +" set "+UPDATE_FIELD+" where strategy_id=#{strategyId}")
	public void update(XJLDomain domain);
	@Delete("update "+ TABLE_NAME +" set "+XJLMapper.FIX_DELETE_FIELD+" where strategy_id=#{strategyId}")
	public void delete(XJLDomain domain);
	/**
	 * 通过id查找攻略
	 * @param strategyId
	 * @return
	 */
	@Select("select " + SELECT_ALL +" from " + TABLE_NAME + " where state='A' and strategy_id=#{strategyId}")
	public BsStrategy selectById(String strategyId);
	/**
	 * 通过id屏蔽攻略
	 */
	@Delete("update "+ TABLE_NAME +" set strategy_state='01' "+" where strategy_id=#{strategyId}")
	public void updateStateById(String strategyId);
}