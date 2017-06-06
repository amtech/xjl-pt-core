package com.xjl.pt.sx.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 事项目录清单
* @author DomainCoderTools lilisheng
*
*/
@TableDB(name="xjl_sx_dir_item")
public class SxDirItem extends XJLDomain {
	//事项类型
	private String itemType;
	//事项类型 对应的名称，非数据库字段
	private String itemType$name;
	//设定依据
	private String according;
	//基本编码
	private String baseCode;
	//事项名称
	private String itemName;
	//事项目录id
	private String itemId;
	//事项状态
	private String itemState;
	//版本号
	private String itemVersion;
	public void setItemType(String itemType){
		this.itemType = itemType;
	}
	public String getItemType(){
		return this.itemType;
	}
	public void setItemType$name(String itemType$name){
		this.itemType$name = itemType$name;
	}
	public String getItemType$name(){
		return this.itemType$name;
	}
	public void setAccording(String according){
		this.according = according;
	}
	public String getAccording(){
		return this.according;
	}
	public void setBaseCode(String baseCode){
		this.baseCode = baseCode;
	}
	public String getBaseCode(){
		return this.baseCode;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemName(){
		return this.itemName;
	}
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	public String getItemId(){
		return this.itemId;
	}
	public void setItemState(String itemState){
		this.itemState = itemState;
	}
	public String getItemState(){
		return this.itemState;
	}
	public void setItemVersion(String itemVersion){
		this.itemVersion = itemVersion;
	}
	public String getItemVersion(){
		return this.itemVersion;
	}
}
