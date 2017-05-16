package com.xjl.pt.core.service;
import java.util.Calendar;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.UserInfoMapper;
/**
 * 用户基本信息数据业务类
 * @author guan.zheyuan
 */
@Service
public class UserInfoService extends XJLService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public void add(XJLDomain domain, User user) {
		//if (StringUtils.isBlank(domain.getOrg())){
			//throw new RuntimeException("用户的org不能为空");
		//}
		domain.setMaster(UUID.randomUUID().toString());
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
}
