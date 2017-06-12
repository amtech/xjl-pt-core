package com.xjl.pt.news.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 政务公开类别
* @author DomainCoderTools lilisheng
*
*/
@TableDB(name="xjl_news_government_affairs_openness_category")
public class NewsGovernmentAffairsOpennessCategory extends XJLDomain {
	//主键
	private String categoryId;
	//名称
	private String categoryName;
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getCategoryId(){
		return this.categoryId;
	}
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}
	public String getCategoryName(){
		return this.categoryName;
	}
}
