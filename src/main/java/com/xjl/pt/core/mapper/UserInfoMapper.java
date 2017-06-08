package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.UserInfo;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * 用户登录数据持久层
 * @author guan.zheyuan
 *
 */
@Repository
public interface UserInfoMapper {
	static final String TABLE_NAME = "xjl_pt_userinfo";
	static final String USERINFO_SELECT_FIELD="user_id as userid,card_no as cardno,phone_no as phoneno,hand_shot_photo_uri as handShotPhotoUrl,hand_card_photo_uri as handCardPhotoUrl,card_back_photo_uri as cardBackPhotoUrl,auth_state as authState,card_name as cardName ,card_front_photo_uri as cardFrontPhotoUrl,auth_date as authDate,auth_user_id as authUserId,auth_channel_type as authChannelType,auth_channel_name as authChannelName";
	
	/**
	 * 执行插入
	 * @param userInfo
	 */
	@Insert("insert into "+TABLE_NAME+"(user_id,card_no,phone_no,card_name,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{cardNo},#{phoneNo},#{cardName},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	
	@Insert("insert into "+TABLE_NAME+"(user_id,card_no,phone_no,hand_card_photo_uri,auth_channel_type,auth_channel_name,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{cardNo},#{phoneNo},#{handCardPhotoUrl},'2','自助终端',"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insertHandCardPhotoUrl(XJLDomain domain);
	/**
	 * 更新
	 */
	@Update("update  "+TABLE_NAME+" set  hand_shot_photo_uri=#{handShotPhotoUrl},hand_card_photo_uri=#{handCardPhotoUrl},card_back_photo_uri=#{cardBackPhotoUrl} where card_no = #{cardNo}")
	public void updatePhoto(XJLDomain domain);
	@Update("update  "+TABLE_NAME+" set  "
			+ "user_id=#{userid},card_no=#{cardno},phone_no=#{phoneno},"
			+ "hand_shot_photo_uri=#{handShotPhotoUrl},hand_card_photo_uri=#{handCardPhotoUrl},"
			+ "card_back_photo_uri=#{cardBackPhotoUrl},auth_state=#{authState},"
			+ "card_name=#{cardName} ,card_front_photo_uri=#{cardFrontPhotoUrl},"
			+ "auth_date=#{authDate},auth_user_id=#{authUserId},"
			+ "auth_channel_type=#{authChannelType},auth_channel_name=#{authChannelName}"
			+ " where card_no = #{cardNo}")
	public void update(XJLDomain domain);
	
	@Update("update "+TABLE_NAME+" set  phone_no=#{phoneNo} where user_id=#{userId}")
	public void updatePhone(XJLDomain domain);
	
	/** 
	 * 得到用户信息
	 * @param cardNo
	 */
	@Select("select "+USERINFO_SELECT_FIELD+" from "+TABLE_NAME+" where card_no =#{cardNo}  and state='A' ")
	public UserInfo selectByCardNo(String cardNo); 
	/**
	 * 得到用户信息
	 * @param phoneNo
	 */
	@Select("select  "+USERINFO_SELECT_FIELD+","+XJLMapper.FIX_SELECT_FIELD+" from "+TABLE_NAME+" where phone_no =#{phoneNo}  and state='A' ")
	public UserInfo selectByPhoneNo(String phoneNo);
	/**
	 * 用户编号得到用户信息
	 * @param userId
	 */
	@Select("select "+USERINFO_SELECT_FIELD+"  from  "+TABLE_NAME+" where  user_id=#{userId} and state='A' ")
	public UserInfo selectByUserId(String userId);
	
	/**
	 * 逻辑删除
	 */
	@Delete("update "+TABLE_NAME+" set "+XJLMapper.FIX_DELETE_FIELD+" where user_id=#{userId}")
	public void delete(XJLDomain domain);
}
