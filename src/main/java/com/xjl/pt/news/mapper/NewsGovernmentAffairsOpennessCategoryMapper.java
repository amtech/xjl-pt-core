package com.xjl.pt.news.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.news.domain.NewsGovernmentAffairsOpennessCategory;
/**
 * 政务公开类别
 * @author MapperCoderTools lilisheng
 *
*/
@Repository
public interface NewsGovernmentAffairsOpennessCategoryMapper {
	static final String TABLE_NAME = "xjl_news_government_affairs_openness_category";
	static final String SELECT_ALL = "category_id as categoryId,category_name as categoryName,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "category_id,category_name," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{categoryId},#{categoryName}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "category_name=#{categoryName}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where category_id=#{categoryId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where category_id=#{categoryId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<NewsGovernmentAffairsOpennessCategory> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where category_id=#{categoryId}")
	public NewsGovernmentAffairsOpennessCategory selectById(String dictId);
	
	
	
}