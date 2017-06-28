package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.BjPieceLicence;
/**
 * 办件材料关联表
 * @author MapperCoderTools 陶杰
 *
*/
@Repository
public interface BjPieceLicenceMapper {
	static final String TABLE_NAME = "xjl_bj_piece_licence";
	static final String SELECT_ALL = "licence_id as licenceId,piece_id as pieceId,pid as pid,useable as useable,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "licence_id,piece_id,pid,useable," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{licenceId},#{pieceId},#{pid},#{useable}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "licence_id=#{licenceId},piece_id=#{pieceId},pid=#{pid},useable=#{useable}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<BjPieceLicence> selectAll();
	@Update("update "+ TABLE_NAME +" set "+UPDATE_FIELD+" where pid=#{pid}")
	public void update(XJLDomain domain);
	@Delete("update "+ TABLE_NAME +" set "+XJLMapper.FIX_DELETE_FIELD+" where pid=#{pid}")
	public void delete(XJLDomain domain);
	
	/**
	 * 通过办件id查出该办件的材料信息
	 */
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' and piece_id=#{pieceId}")
	public List<BjPieceLicence> selectByPieceId(String pieceId);
	
}