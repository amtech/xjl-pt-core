package com.xjl.pt.news.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 政务公开内容
* @author DomainCoderTools lilisheng
*
*/
@TableDB(name="xjl_news_government_affairs_openness")
public class NewsGovernmentAffairsOpenness extends XJLDomain {
	//政务公开id
	private String opennessId;
	//标题
	private String opennessTitle;
	//摘要
	private String opennessSummary;
	//公开类别
	private String categoryId;
	//公开类别 对应的名称，非数据库字段
	private String categoryId$name;
	//政务公开内容
	private String opennessContent;
	public void setOpennessId(String opennessId){
		this.opennessId = opennessId;
	}
	public String getOpennessId(){
		return this.opennessId;
	}
	public void setOpennessTitle(String opennessTitle){
		this.opennessTitle = opennessTitle;
	}
	public String getOpennessTitle(){
		return this.opennessTitle;
	}
	public void setOpennessSummary(String opennessSummary){
		this.opennessSummary = opennessSummary;
	}
	public String getOpennessSummary(){
		return this.opennessSummary;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getCategoryId(){
		return this.categoryId;
	}
	public void setCategoryId$name(String categoryId$name){
		this.categoryId$name = categoryId$name;
	}
	public String getCategoryId$name(){
		return this.categoryId$name;
	}
	public void setOpennessContent(String opennessContent){
		this.opennessContent = opennessContent;
	}
	public String getOpennessContent(){
		return this.opennessContent;
	}
}
