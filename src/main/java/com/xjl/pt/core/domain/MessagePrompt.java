package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 站内信
* @author DomainCoderTools 陶杰
*
*/
@TableDB(name="xjl_message_prompt")
public class MessagePrompt extends XJLDomain {
	//拥有人类型
	private String ownerType;
	//拥有人
	private String ownerNo;
	//发送人身份证
	private String senderCardno;
	//发送人
	private String senderUsername;
	//站内信内容
	private String promptContent;
	//站内信标题
	private String promptTitle;
	//站内信编号
	private String promptId;
	//发送时间 (统一格式)非数据库字段
	private String createDateStr;
	public void setOwnerType(String ownerType){
		this.ownerType = ownerType;
	}
	public String getOwnerType(){
		return this.ownerType;
	}
	public void setOwnerNo(String ownerNo){
		this.ownerNo = ownerNo;
	}
	public String getOwnerNo(){
		return this.ownerNo;
	}
	public void setSenderCardno(String senderCardno){
		this.senderCardno = senderCardno;
	}
	public String getSenderCardno(){
		return this.senderCardno;
	}
	public void setSenderUsername(String senderUsername){
		this.senderUsername = senderUsername;
	}
	public String getSenderUsername(){
		return this.senderUsername;
	}
	public void setPromptContent(String promptContent){
		this.promptContent = promptContent;
	}
	public String getPromptContent(){
		return this.promptContent;
	}
	public void setPromptTitle(String promptTitle){
		this.promptTitle = promptTitle;
	}
	public String getPromptTitle(){
		return this.promptTitle;
	}
	public void setPromptId(String promptId){
		this.promptId = promptId;
	}
	public String getPromptId(){
		return this.promptId;
	}
	public String getCreateDateStr() {
		return createDateStr;
	}
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	
}
