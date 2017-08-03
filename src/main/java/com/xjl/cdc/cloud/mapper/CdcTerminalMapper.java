package com.xjl.cdc.cloud.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.cdc.cloud.domain.CdcTerminal;
/**
 * 云检测中心终端
 * @author MapperCoderTools lilisheng
 *
*/
@Repository
public interface CdcTerminalMapper {
	static final String TABLE_NAME = "xjl_cdc_terminal";
	static final String SELECT_ALL = "terminal_id as terminalId,terminal_guid as terminalGuid,terminal_type as terminalType,terminal_state as terminalState,terminal_url as terminalUrl,module_id as moduleId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "terminal_id,terminal_guid,terminal_type,terminal_state,terminal_url,module_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{terminalId},#{terminalGuid},#{terminalType},#{terminalState},#{terminalUrl},#{moduleId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "terminal_guid=#{terminalGuid},terminal_type=#{terminalType},terminal_state=#{terminalState},terminal_url=#{terminalUrl},module_id=#{moduleId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where terminal_id=#{terminalId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where terminal_id=#{terminalId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<CdcTerminal> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where terminal_id=#{terminalId}")
	public CdcTerminal selectById(String terminalId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where terminal_guid=#{terminalGuid}")
	public CdcTerminal selectByGUID(String terminalGuid);
	@Update("update " + TABLE_NAME + " set terminal_url=#{0} where module_id=#{1}")	
	public void updateUrlByModuleId(String url, String moduleId);
	
	
}