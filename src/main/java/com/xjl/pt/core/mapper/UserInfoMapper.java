package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * �û�������Ϣ���ݳ־ò�
 * @author guan.zheyuan
 *
 */
@Repository
public interface UserInfoMapper {
	static final String TABLE_NAME = "xjl_pt_userinfo";
	
	
	/**
	 * ִ����������
	 * @param userInfo
	 */
	@Insert("insert into "+TABLE_NAME+"(user_id,username,cardno,phoneno,headshot,hand_card_photo,hand_card_backphoto,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{userName},#{cardNo},#{phoneNo},#{headShot},#{handCardPhoto},#{handCardBackPhoto},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
}
