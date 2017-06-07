package com.xjl.pt.core.tools;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xjl.pt.core.domain.DictItem;

/**
 * 字典工具
 * @author lilisheng
 *
 */
public class DictItemTools {
	private static final Log log = LogFactory.getLog(DictItemTools.class);
	/**
	 * 根据字典代码得到字典名称
	 * @param codes 字典代码，多个字典代码用分号隔开
	 * @param dictItems 字典列表对象
	 * @return
	 */
	public static String getDictItemNames(String codes, List<DictItem> dictItems){
		if (StringUtils.isEmpty(codes)){
			return null;
		}
		String[] dictItemCodeList = StringUtils.split(codes, ",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i< dictItemCodeList.length; i++){
			log.debug(i + ":" + dictItemCodeList[i]);
			if (i > 0){
				sb.append(",");
			}
			for (DictItem dictItem : dictItems) {
				log.debug("字典:" + dictItem.getDictItemCode() + ":" + dictItem.getDictItemName());
				if (StringUtils.equals(dictItem.getDictItemCode().trim(),dictItemCodeList[i].trim())){
					log.debug("相同");
					sb.append(dictItem.getDictItemName());
					break;
				}
			}
		}
		return sb.toString();
	}
}
