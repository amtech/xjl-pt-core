package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 用户基本信息数据持久层
 * @author guan.zheyuan
 *
 */
@Repository
public interface UserInfoMapper {
	static final String TABLE_NAME = "xjl_pt_userinfo";
	
	
	/**
	 * 执行新增插入
	 * @param userInfo
	 */
	@Insert("insert into "+TABLE_NAME+"(user_id,username,cardno,phoneno,headshot,hand_card_photo,hand_card_backphoto,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{userName},#{cardNo},#{phoneNo},#{headShot},#{handCardPhoto},#{handCardBackPhoto},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
}
