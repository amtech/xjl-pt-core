package com.xjl.pt.core.service;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xjl.pt.core.domain.User;
import com.xjl.pt.core.domain.UserInfo;
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
	 * 根据身份证号码获取信息
	 */
	public UserInfo queryByCardNo(String cardNo){
		return this.userInfoMapper.selectByCardNo(cardNo);
	}
	/**
	 * 根据手机号获取信息
	 */
	public UserInfo queryByPhoneNo(String phoneNo){
		return this.userInfoMapper.selectByPhoneNo(phoneNo);
	}
	
	/**
	 * 上传证件照片存入数据库,这个方法不要重写，后端会统一做一些事情，如果仅仅是更新图片，可以更加一个modifyPhoto的方法
	 * @deprecated 没有修改者用户，请参考父类中的modify方法（domain，user）
	 */
	public void modify(XJLDomain domain){
		this.userInfoMapper.updatePhoto(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.userInfoMapper.update(domain);
	}
}
