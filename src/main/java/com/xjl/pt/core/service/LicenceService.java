package com.xjl.pt.core.service;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.domain.Licence;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.mapper.LicenceMapper;

/**
 * 证照数据持久层
 * @author guan.zheyuan
 *
 */
@Service
public class LicenceService extends XJLService {
	@Autowired
	private LicenceMapper licenceMapper;

	@Override
	public void _add(XJLDomain domain) {
		this.licenceMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.licenceMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.licenceMapper.update(domain);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
	/**
	 * 查询证照
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Licence> query(String search,int page,int pageSize){
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.licenceMapper.selectAll();
		}else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	};
	
	
	/**
	 * 通过证照编号得到数量
	 */
	public int  countByLicense(String licenseId){
		return this.licenceMapper.selectCountByLicenceid(licenseId);
	}
	
	/**
	 * 通过证照编号得到证照信息
	 * @return
	 */
	public Licence queryByLicenceId(String licenceId){
		return this.licenceMapper.selectByLicenceId(licenceId);
	}
	
	/**
	 * 通过ownid得到证照存放ftp的位置
	 */
	public List<Licence> queryUrlByOwnid(String ownerno){
		List<Licence> list=this.licenceMapper.selectUrlByOwnid(ownerno);
		return list;
	}
}