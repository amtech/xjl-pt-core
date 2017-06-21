package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.TableDB;
/**
* 征信库
* @author DomainCoderTools Arthur
*
*/
@TableDB(name="xjl_cd_credit")
public class CdCredit extends XJLDomain {
	//征信id
	private String creditId;
	//征信主体类型
	private String creditEntityType;
	//征信主体类型 对应的名称，非数据库字段
	private String creditEntityType$name;
	//征信主体编码
	private String creditEntityNo;
	//征信主体分值
	private Integer creditEntityScore;
	//征信值数量，这个不是数据库中的属性，需要单独赋值和获取
	private Integer creditItemCount;
	public void setCreditId(String creditId){
		this.creditId = creditId;
	}
	public String getCreditId(){
		return this.creditId;
	}
	public void setCreditEntityType(String creditEntityType){
		this.creditEntityType = creditEntityType;
	}
	public String getCreditEntityType(){
		return this.creditEntityType;
	}
	public void setCreditEntityType$name(String creditEntityType$name){
		this.creditEntityType$name = creditEntityType$name;
	}
	public String getCreditEntityType$name(){
		return this.creditEntityType$name;
	}
	public void setCreditEntityNo(String creditEntityNo){
		this.creditEntityNo = creditEntityNo;
	}
	public String getCreditEntityNo(){
		return this.creditEntityNo;
	}
	public void setCreditEntityScore(Integer creditEntityScore){
		this.creditEntityScore = creditEntityScore;
	}
	public Integer getCreditEntityScore(){
		return this.creditEntityScore;
	}
	public Integer getCreditItemCount() {
		return creditItemCount;
	}
	public void setCreditItemCount(Integer creditItemCount) {
		this.creditItemCount = creditItemCount;
	}
}
