package com.xjl.pt.core.service;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.UserInfo;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserInfoMapper;
/**
 * �û�������Ϣ����ҵ����
 * @author guan.zheyuan
 */
@Service
public class UserInfoService extends XJLService {
	@Autowired
	private UserInfoMapper userInfoMapper;
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
		 this.userInfoMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		// TODO Auto-generated method stub
	}
	/**
	 * �������֤�����ȡ��Ϣ
	 */
	public UserInfo queryByCardNo(String cardNo){
		return this.userInfoMapper.selectByCardNo(cardNo);
	}
	/**
	 * �����ֻ��Ż�ȡ��Ϣ
	 */
	public UserInfo queryByPhoneNo(String phoneNo){
		return this.userInfoMapper.selectByPhoneNo(phoneNo);
	}
	
	/**
	 * �ϴ�֤����Ƭ�������ݿ�
	 */
	public void modify(XJLDomain domain){
		this.userInfoMapper.updatePhoto(domain);
	}
}
