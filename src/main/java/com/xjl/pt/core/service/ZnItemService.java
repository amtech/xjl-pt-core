package com.xjl.pt.core.service;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZnItem;
import com.xjl.pt.core.mapper.ZnItemMapper;

/**
 * 办事指南
 * @author ServiceCoderTools Arthur
 *
 */
@Service
public class ZnItemService extends XJLService {
	@Autowired
	private ZnItemMapper znItemMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.znItemMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		//this.znItemMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		//this.znItemMapper.update(domain);
	}
	public List<ZnItem> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.znItemMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public ZnItem queryById(String znItemId){
		return null;
	}
	/**
	 * 统计单位下办事指南条目
	 * @return
	 */
	public int queryZnItemCount(String organizationId){
		return this.znItemMapper.selectZnItemCount(organizationId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}
}
