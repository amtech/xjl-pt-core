package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 常见问题
* @author DomainCoderTools Arthur
*
*/
@TableDB(name="xjl_cj_issue")
public class CjIssue extends XJLDomain {
	//常见问题内容
	private String issueContent;
	//常见问题标题
	private String issueTitle;
	//常见问题编号
	private String issueId;
	public void setIssueContent(String issueContent){
		this.issueContent = issueContent;
	}
	public String getIssueContent(){
		return this.issueContent;
	}
	public void setIssueTitle(String issueTitle){
		this.issueTitle = issueTitle;
	}
	public String getIssueTitle(){
		return this.issueTitle;
	}
	public void setIssueId(String issueId){
		this.issueId = issueId;
	}
	public String getIssueId(){
		return this.issueId;
	}
}
