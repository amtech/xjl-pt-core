package com.xjl.cdc.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.xjl.cdc.cloud.domain.CdcTerminalLog;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.XJLMapper;
/**
 * 云检测中心终端日志
 * @author you.guess
 *
*/
@Repository
public interface CdcTerminalLogMapper {
	static final String TABLE_NAME = "xjl_cdc_terminal_log";
	static final String SELECT_ALL = "log_id as logId,terminal_id as terminalId,terminal_guid as terminalGuid,operate_type as operateType,operate_desc as operateDesc,operate_date as operateDate,ip,location,location_code as locationCode,lng,lat,province,city,country,town,village,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "log_id,terminal_id,terminal_guid,operate_type,operate_desc,operate_date,ip,location,location_code,lng,lat,province,city,country,town,village," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{logId},#{terminalId},#{terminalGuid},#{operateType},#{operateDesc},#{operateDate},#{ip},#{location},#{locationCode},#{lng},#{lat},#{province},#{city},#{country},#{town},#{village}," + XJLMapper.FIX_INSERT_VALUE;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<CdcTerminalLog> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where log_id=#{logId}")
	public CdcTerminalLog selectById(String terminalId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where terminal_id=#{terminalId}")
	public List<CdcTerminalLog> selectByTMId(String terminalId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where terminal_guid=#{terminalGuid}")
	public List<CdcTerminalLog> selectByGUID(String terminalGuid);
}
