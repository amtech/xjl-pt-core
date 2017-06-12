package com.xjl.pt.news.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.news.domain.NewsGovernmentAffairsOpenness;
/**
 * 政务公开内容
 * @author MapperCoderTools lilisheng
 *
*/
@Repository
public interface NewsGovernmentAffairsOpennessMapper {
	static final String TABLE_NAME = "xjl_news_government_affairs_openness";
	static final String SELECT_ALL = "openness_id as opennessId,openness_title as opennessTitle,openness_summary as opennessSummary,category_id as categoryId,openness_content as opennessContent,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "openness_id,openness_title,openness_summary,category_id,openness_content," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{opennessId},#{opennessTitle},#{opennessSummary},#{categoryId},#{opennessContent}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "openness_title=#{opennessTitle},openness_summary=#{opennessSummary},category_id=#{categoryId},openness_content=#{opennessContent}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where openness_id=#{opennessId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where openness_id=#{opennessId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<NewsGovernmentAffairsOpenness> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where openness_id=#{opennessId}")
	public NewsGovernmentAffairsOpenness selectById(String dictId);
	
	
	
}