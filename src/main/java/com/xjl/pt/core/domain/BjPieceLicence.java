package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 办件材料关联表
* @author DomainCoderTools 陶杰
*
*/
@TableDB(name="xjl_bj_piece_licence")
public class BjPieceLicence extends XJLDomain {
	//证照编号
	private String licenceId;
	//证照编号 对应的名称，非数据库字段
	private String licenceId$name;
	//办件编号
	private String pieceId;
	//办件编号 对应的名称，非数据库字段
	private String pieceId$name;
	//关联编号
	private String pid;
	//判断是否可用
	private String useable;
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
	public void setPieceId(String pieceId){
		this.pieceId = pieceId;
	}
	public String getPieceId(){
		return this.pieceId;
	}
	public void setPieceId$name(String pieceId$name){
		this.pieceId$name = pieceId$name;
	}
	public String getPieceId$name(){
		return this.pieceId$name;
	}
	public void setPid(String pid){
		this.pid = pid;
	}
	public String getPid(){
		return this.pid;
	}
	public String getUseable() {
		return useable;
	}
	public void setUseable(String useable) {
		this.useable = useable;
	}
	
}
