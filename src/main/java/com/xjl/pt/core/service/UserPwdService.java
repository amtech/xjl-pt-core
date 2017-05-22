package com.xjl.pt.core.service;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.UserPwd;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserPwdMapper;

/**
 * �û���������ҵ����
 * @author guan.zheyuan
 */
@Service
public class UserPwdService extends XJLService  {

	@Autowired
	private UserPwdMapper userPwdMapper;
	@Override
	public void add(XJLDomain domain, User user) {
		//if (StringUtils.isBlank(domain.getOrg())){
			//throw new RuntimeException("�û���org����Ϊ��");
		//}
		domain.setCreateUserId(user.getUserId());
		domain.setCreateDate(Calendar.getInstance().getTime());
		domain.setCancelDate(null);
		domain.setCancelUserId(null);
		domain.setState(XJLDomain.StateType.A.name());
		_add(domain);
	}
	@Override
	public void _add(XJLDomain domain) {
		this.userPwdMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		// TODO Auto-generated method stub
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		domain.setCancelDate(new Date());
		domain.setCancelUserId("XJLXJL00-XJL1-XJL2-XJL3-XJLXJLXJLXJL");
		domain.setState(XJLDomain.StateType.X.name());
		this.userPwdMapper.delete(domain);
	}
	/**
	 * �õ��û�������Ϣ
	 */
	public UserPwd queryByMaster(XJLDomain domain){
		return this.userPwdMapper.selectByMaster(domain);
	}
}
