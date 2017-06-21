package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 征信条目
* @author DomainCoderTools Arthur
*
*/
@TableDB(name="xjl_cd_credit_item")
public class CdCreditItem extends XJLDomain {
	//条目id
	private String creditItemId;
	//征信条目名称
	private String creditItemName;
	//征信条目分值
	private Integer creditItemScore;
	//征信条目内容
	private String creditItemContent;
	//征信id
	private String creditId;
	//征信id 对应的名称，非数据库字段
	private String creditId$name;
	public void setCreditItemId(String creditItemId){
		this.creditItemId = creditItemId;
	}
	public String getCreditItemId(){
		return this.creditItemId;
	}
	public void setCreditItemName(String creditItemName){
		this.creditItemName = creditItemName;
	}
	public String getCreditItemName(){
		return this.creditItemName;
	}
	public void setCreditItemScore(Integer creditItemScore){
		this.creditItemScore = creditItemScore;
	}
	public Integer getCreditItemScore(){
		return this.creditItemScore;
	}
	public void setCreditItemContent(String creditItemContent){
		this.creditItemContent = creditItemContent;
	}
	public String getCreditItemContent(){
		return this.creditItemContent;
	}
	public void setCreditId(String creditId){
		this.creditId = creditId;
	}
	public String getCreditId(){
		return this.creditId;
	}
	public void setCreditId$name(String creditId$name){
		this.creditId$name = creditId$name;
	}
	public String getCreditId$name(){
		return this.creditId$name;
	}
}
