package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.BjHistoryPiece;
/**
 * 历史办件
 * @author MapperCoderTools 陶杰
 *
*/
@Repository
public interface BjHistoryPieceMapper {
	static final String TABLE_NAME = "xjl_bj_history_piece";
	static final String SELECT_ALL = "management_status as managementStatus,owner_type as ownerType,owner_on as ownerOn,end_time as endTime,reporting_time as reportingTime,process_progress as processProgress,management_dept as managementDept,matte_name as matteName,piece_id as pieceId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "management_status,owner_type,owner_on,end_time,reporting_time,process_progress,management_dept,matte_name,piece_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{managementStatus},#{ownerType},#{ownerOn},#{endTime},#{reportingTime},#{processProgress},#{managementDept},#{matteName},#{pieceId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "management_status=#{managementStatus},owner_type=#{ownerType},owner_on=#{ownerOn},end_time=#{endTime},reporting_time=#{reportingTime},process_progress=#{processProgress},management_dept=#{managementDept},matte_name=#{matteName},piece_id=#{pieceId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<BjHistoryPiece> selectAll();
	@Update("update "+ TABLE_NAME +" set "+UPDATE_FIELD+" where piece_id=#{pieceId}")
	public void update(XJLDomain domain);
	@Delete("update "+ TABLE_NAME +" set "+XJLMapper.FIX_DELETE_FIELD+" where piece_id=#{pieceId}")
	public void delete(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' and piece_id=#{pieceId}")
	public BjHistoryPiece selectByPieceId(String pieceId);
	
	
}