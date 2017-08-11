package com.xjl.rcu.monitor.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.rcu.monitor.domain.RcuErrorLog;
import com.xjl.rcu.monitor.service.RcuErrorLogService;
/**
 * rcu错误日志表
 * @author MapperCoderTools lilisheng
 *
*/
@Repository
public interface RcuErrorLogMapper {
	static final String TABLE_NAME = "xjl_rcu_error_log";
	static final String SELECT_ALL = "error_date as errorDate,error_message as errorMessage,error_code as errorCode,device_code as deviceCode,terminal_id as terminalId,rcu_id as rcuId,error_id as errorId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "error_date,error_message,error_code,device_code,terminal_id,rcu_id,error_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{errorDate},#{errorMessage},#{errorCode},#{deviceCode},#{terminalId},#{rcuId},#{errorId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "error_date=#{errorDate},error_message=#{errorMessage},error_code=#{errorCode},device_code=#{deviceCode},terminal_id=#{terminalId},rcu_id=#{rcuId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where error_id=#{errorId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where error_id=#{errorId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<RcuErrorLog> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where error_id=#{errorId}")
	public RcuErrorLog selectById(String errorId);
	/**
	 * 增加按时间查询
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	@SelectProvider(type = RcuErrorLogService.class, method = "selectByErrorTime")
	public List<RcuErrorLog> selectByErrorTime(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	@SelectProvider(type = RcuErrorLogService.class, method = "selectByErrorTimeTj")
	public List<RcuErrorLog> selectByErrorTimeTj(@Param("beginTime") String beginTime,@Param("endTime") String endTime);

}