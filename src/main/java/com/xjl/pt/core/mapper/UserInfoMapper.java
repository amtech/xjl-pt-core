package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.UserInfo;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 用户基本信息数据持久层
 * @author guan.zheyuan
 *
 */
@Repository
public interface UserInfoMapper {
	static final String TABLE_NAME = "xjl_pt_userinfo";
	static final String USERINFO_SELECT_FIELD="user_id,cardno,phoneno,handshot,card_photo,card_backphoto,username";
	
	/**
	 * 执行新增插入
	 * @param userInfo
	 */
	@Insert("insert into "+TABLE_NAME+"(user_id,username,cardno,phoneno,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{userName},#{cardNo},#{phoneNo},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	/**
	 * 修改图片地址
	 */
	@Update("update  "+TABLE_NAME+" set  handshot=#{handShot},card_photo=#{cardPhoto},card_backphoto=#{cardBackPhoto} where cardno = #{cardNo}")
	public void updatePhoto(XJLDomain domain);
	/**
	 * 通过身份证查询
	 * @param cardNo
	 */
	@Select("select "+USERINFO_SELECT_FIELD+" from "+TABLE_NAME+" where cardno =#{cardNo}")
	public UserInfo selectByCardNo(String cardNo);
	/**
	 * 通过手机号查询
	 * @param phoneNo
	 */
	@Select("select "+USERINFO_SELECT_FIELD+" from "+TABLE_NAME+" where phoneno =#{phoneNo}")
	public UserInfo selectByPhoneNo(String phoneNo);
}
