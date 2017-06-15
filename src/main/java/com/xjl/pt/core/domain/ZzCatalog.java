package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 个人空间库证照目录
* @author DomainCoderTools 陶杰
*
*/
@TableDB(name="xjl_zz_catalog")
public class ZzCatalog extends XJLDomain {
	//目录id
	private String catalogId;
	//个人空间库证照目录名称
	private String catalogName;
	//用户id
	private String userId;
	//用户id 对应的名称，非数据库字段
	private String userId$name;
	public void setCatalogId(String catalogId){
		this.catalogId = catalogId;
	}
	public String getCatalogId(){
		return this.catalogId;
	}
	public void setCatalogName(String catalogName){
		this.catalogName = catalogName;
	}
	public String getCatalogName(){
		return this.catalogName;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return this.userId;
	}
	public void setUserId$name(String userId$name){
		this.userId$name = userId$name;
	}
	public String getUserId$name(){
		return this.userId$name;
	}
}
