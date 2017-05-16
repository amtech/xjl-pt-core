package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import com.xjl.pt.core.domain.XJLDomain;

/**
 * �û��������ݳ־ò�
 * @author guan.zheyuan
 */
@Repository
public interface UserPwdMapper {
	static final String TABLE_NAME = "xjl_pt_user_password";
	
	/**
	 * ִ�������������
	 * @param userPwd
	 */
	@Insert("insert into "+TABLE_NAME+"(user_id,password,"+XJLMapper.FIX_INSERT_FIELD+")"
			+"values(#{userId},#{password},"+XJLMapper.FIX_INSERT_VALUE+")")
	public void insert(XJLDomain domain);
}
