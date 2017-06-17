package com.xjl.pt.core.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.UserLog;
import com.xjl.pt.core.domain.XJLDomain;
/**
 * 用户日志数据持久层
 * @author guan.zheyuan
 *
 */
@Repository
public interface UserLogMapper {
	static final String TABLE_NAME="xjl_pt_user_log";
	static final String USERLOG_SELECT_FIELD="ip,city,user_id as userid,user_name as username,uri,master,state";
	
	
	/**
	 * 执行插入
	 * @param domain
	 */
	@Insert("insert into "+TABLE_NAME+"(ip,user_id,user_name,city,uri,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{ip},#{userId},#{userName},#{city},#{url},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	
	/**
	 * 得到上一次登录日志
	 */
	@Select("select "+USERLOG_SELECT_FIELD+","+XJLMapper.FIX_SELECT_FIELD+" from "+TABLE_NAME+" where create_date =(select max(create_date) from "+TABLE_NAME+" where user_id=#{userId})")
	public UserLog selectForMax(String userId);
	
	/**
	 * 得到城市名称为空的数据
	 * @return
	 */
	@Select("select "+USERLOG_SELECT_FIELD+" from "+TABLE_NAME+" where city is null and state='A'")
	public List<UserLog> selectForCityNull();
	
	/**
	 * 添加城市定位
	 * @param domain
	 */
	@Update("update "+TABLE_NAME+" set city=#{city} where master=#{master}")
	public void updateCity(XJLDomain domain);
}
