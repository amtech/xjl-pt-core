package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.MessagePrompt;
/**
 * 站内信
 * @author MapperCoderTools 陶杰
 *
*/
@Repository
public interface MessagePromptMapper {
	static final String TABLE_NAME = "xjl_message_prompt";
	static final String SELECT_ALL = "owner_type as ownerType,owner_no as ownerNo,sender_cardNo as senderCardno,sender_userName as senderUsername,prompt_content as promptContent,prompt_title as promptTitle,prompt_id as promptId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "owner_type,owner_no,sender_cardNo,sender_userName,prompt_content,prompt_title,prompt_id," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{ownerType},#{ownerNo},#{senderCardno},#{senderUsername},#{promptContent},#{promptTitle},#{promptId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "owner_type=#{ownerType},owner_no=#{ownerNo},sender_cardNo=#{senderCardno},sender_userName=#{senderUsername},prompt_content=#{promptContent},prompt_title=#{promptTitle}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where prompt_id=#{promptId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where prompt_id=#{promptId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<MessagePrompt> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where prompt_id=#{promptId}")
	public MessagePrompt selectById(String promptId);
	
	
	
}