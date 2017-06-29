package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.MessagePrompt;
import com.xjl.pt.core.mapper.MessagePromptMapper;

/**
 * 站内信
 * @author ServiceCoderTools 陶杰
 *
 */
@Service
public class MessagePromptService extends XJLService {
	@Autowired
	private MessagePromptMapper messagePromptMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.messagePromptMapper.insert(domain);
	}
	@Override
	public void _delete(XJLDomain domain) {
		this.messagePromptMapper.delete(domain);
	}
	@Override
	public void _modify(XJLDomain domain) {
		this.messagePromptMapper.update(domain);
	}
	public List<MessagePrompt> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.messagePromptMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	public MessagePrompt queryById(String promptId) {
		return this.messagePromptMapper.selectById(promptId);
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
		((MessagePrompt)domain).setPromptId(UUID.randomUUID().toString());
	}
}
