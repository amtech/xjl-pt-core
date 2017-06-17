package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 个人证照目录分类
* @author DomainCoderTools 陶杰
*
*/
@TableDB(name="xjl_zz_catalog_licence")
public class ZzCatalogLicence extends XJLDomain {
	//目录id
	private String catalogId;
	//目录id 对应的名称，非数据库字段
	private String catalogId$name;
	//证照id
	private String licenceId;
	//证照id 对应的名称，非数据库字段
	private String licenceId$name;
	public void setCatalogId(String catalogId){
		this.catalogId = catalogId;
	}
	public String getCatalogId(){
		return this.catalogId;
	}
	public void setCatalogId$name(String catalogId$name){
		this.catalogId$name = catalogId$name;
	}
	public String getCatalogId$name(){
		return this.catalogId$name;
	}
	public void setLicenceId(String licenceId){
		this.licenceId = licenceId;
	}
	public String getLicenceId(){
		return this.licenceId;
	}
	public void setLicenceId$name(String licenceId$name){
		this.licenceId$name = licenceId$name;
	}
	public String getLicenceId$name(){
		return this.licenceId$name;
	}
}
