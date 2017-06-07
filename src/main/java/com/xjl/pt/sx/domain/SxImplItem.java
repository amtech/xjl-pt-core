package com.xjl.pt.sx.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.FieldDB;
import com.xjl.pt.core.annotation.TableDB;
import java.util.Date;
/**
* 实施清单
* @author DomainCoderTools lilisheng
*
*/
@TableDB(name="xjl_sx_impl_item")
public class SxImplItem extends XJLDomain {
	//事项id
	private String itemId;
	//基本编码
	private String baseCode;
	//事项名称
	private String itemName;
	//事项类型
	private String itemType;
	//事项类型 对应的名称，非数据库字段
	private String itemType$name;
	//设定依据
	private String according;
	//行使层级
	private String implLevel;
	//行使层级 对应的名称，非数据库字段
	private String implLevel$name;
	//权限划分
	private String permission;
	//实施内容
	private String implContent;
	//实施机构
	private String implOrg;
	//实施机构 对应的名称，非数据库字段
	private String implOrg$name;
	//实施主体性质
	private String implOrgType;
	//实施主体性质 对应的名称，非数据库字段
	private String implOrgType$name;
	//法定办结时限
	private String legalTimeLimit;
	//受理条件
	private String acceptanceConditions;
	//申请材料
	private String applicationMaterials;
	//联办机构
	private String joinOrg;
	//联办机构 对应的名称，非数据库字段
	private String joinOrg$name;
	//中介服务
	private String intermediaryService;
	//办理流程
	private String progress;
	//数量限制
	private Integer quantitativeLimit;
	//结果名称
	private String resultName;
	//结果样本
	private String resultSample;
	//是否收费
	private String chargeFlag;
	//收费标准
	private String chargeStandard;
	//收费依据
	private String chargeAccording;
	//服务对象
	private String serviceObject;
	//服务对象 对应的名称，非数据库字段
	private String serviceObject$name;
	//办件类型
	private String officeType;
	//办件类型 对应的名称，非数据库字段
	private String officeType$name;
	//承诺办结时限
	private String commitmentTimeLimit;
	//通办范围
	private String openScope;
	//通办范围 对应的名称，非数据库字段
	private String openScope$name;
	//办理形式
	private String serviceType;
	//办理形式 对应的名称，非数据库字段
	private String serviceType$name;
	//预约办理
	private String appointmentFlag;
	//网上支付
	private String onlinePaymentFlag;
	//物流快递
	private String logisticsExpressFlag;
	//运行系统
	private String runSystemLevel;
	//运行系统 对应的名称，非数据库字段
	private String runSystemLevel$name;
	//办理地点
	private String servicePoint;
	//办理时间
	private String serviceTime;
	//咨询电话
	private String consultingTelephone;
	//常见问题
	private String faq;
	//监督电话
	private String complaintCall;
	//事项状态
	private String itemState;
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	public String getItemId(){
		return this.itemId;
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
	public void setImplLevel(String implLevel){
		this.implLevel = implLevel;
	}
	public String getImplLevel(){
		return this.implLevel;
	}
	public void setImplLevel$name(String implLevel$name){
		this.implLevel$name = implLevel$name;
	}
	public String getImplLevel$name(){
		return this.implLevel$name;
	}
	public void setPermission(String permission){
		this.permission = permission;
	}
	public String getPermission(){
		return this.permission;
	}
	public void setImplContent(String implContent){
		this.implContent = implContent;
	}
	public String getImplContent(){
		return this.implContent;
	}
	public void setImplOrg(String implOrg){
		this.implOrg = implOrg;
	}
	public String getImplOrg(){
		return this.implOrg;
	}
	public void setImplOrg$name(String implOrg$name){
		this.implOrg$name = implOrg$name;
	}
	public String getImplOrg$name(){
		return this.implOrg$name;
	}
	public void setImplOrgType(String implOrgType){
		this.implOrgType = implOrgType;
	}
	public String getImplOrgType(){
		return this.implOrgType;
	}
	public void setImplOrgType$name(String implOrgType$name){
		this.implOrgType$name = implOrgType$name;
	}
	public String getImplOrgType$name(){
		return this.implOrgType$name;
	}
	public void setLegalTimeLimit(String legalTimeLimit){
		this.legalTimeLimit = legalTimeLimit;
	}
	public String getLegalTimeLimit(){
		return this.legalTimeLimit;
	}
	public void setAcceptanceConditions(String acceptanceConditions){
		this.acceptanceConditions = acceptanceConditions;
	}
	public String getAcceptanceConditions(){
		return this.acceptanceConditions;
	}
	public void setApplicationMaterials(String applicationMaterials){
		this.applicationMaterials = applicationMaterials;
	}
	public String getApplicationMaterials(){
		return this.applicationMaterials;
	}
	public void setJoinOrg(String joinOrg){
		this.joinOrg = joinOrg;
	}
	public String getJoinOrg(){
		return this.joinOrg;
	}
	public void setJoinOrg$name(String joinOrg$name){
		this.joinOrg$name = joinOrg$name;
	}
	public String getJoinOrg$name(){
		return this.joinOrg$name;
	}
	public void setIntermediaryService(String intermediaryService){
		this.intermediaryService = intermediaryService;
	}
	public String getIntermediaryService(){
		return this.intermediaryService;
	}
	public void setProgress(String progress){
		this.progress = progress;
	}
	public String getProgress(){
		return this.progress;
	}
	public void setQuantitativeLimit(Integer quantitativeLimit){
		this.quantitativeLimit = quantitativeLimit;
	}
	public Integer getQuantitativeLimit(){
		return this.quantitativeLimit;
	}
	public void setResultName(String resultName){
		this.resultName = resultName;
	}
	public String getResultName(){
		return this.resultName;
	}
	public void setResultSample(String resultSample){
		this.resultSample = resultSample;
	}
	public String getResultSample(){
		return this.resultSample;
	}
	public void setChargeFlag(String chargeFlag){
		this.chargeFlag = chargeFlag;
	}
	public String getChargeFlag(){
		return this.chargeFlag;
	}
	public void setChargeStandard(String chargeStandard){
		this.chargeStandard = chargeStandard;
	}
	public String getChargeStandard(){
		return this.chargeStandard;
	}
	public void setChargeAccording(String chargeAccording){
		this.chargeAccording = chargeAccording;
	}
	public String getChargeAccording(){
		return this.chargeAccording;
	}
	public void setServiceObject(String serviceObject){
		this.serviceObject = serviceObject;
	}
	public String getServiceObject(){
		return this.serviceObject;
	}
	public void setServiceObject$name(String serviceObject$name){
		this.serviceObject$name = serviceObject$name;
	}
	public String getServiceObject$name(){
		return this.serviceObject$name;
	}
	public void setOfficeType(String officeType){
		this.officeType = officeType;
	}
	public String getOfficeType(){
		return this.officeType;
	}
	public void setOfficeType$name(String officeType$name){
		this.officeType$name = officeType$name;
	}
	public String getOfficeType$name(){
		return this.officeType$name;
	}
	public void setCommitmentTimeLimit(String commitmentTimeLimit){
		this.commitmentTimeLimit = commitmentTimeLimit;
	}
	public String getCommitmentTimeLimit(){
		return this.commitmentTimeLimit;
	}
	public void setOpenScope(String openScope){
		this.openScope = openScope;
	}
	public String getOpenScope(){
		return this.openScope;
	}
	public void setOpenScope$name(String openScope$name){
		this.openScope$name = openScope$name;
	}
	public String getOpenScope$name(){
		return this.openScope$name;
	}
	public void setServiceType(String serviceType){
		this.serviceType = serviceType;
	}
	public String getServiceType(){
		return this.serviceType;
	}
	public void setServiceType$name(String serviceType$name){
		this.serviceType$name = serviceType$name;
	}
	public String getServiceType$name(){
		return this.serviceType$name;
	}
	public void setAppointmentFlag(String appointmentFlag){
		this.appointmentFlag = appointmentFlag;
	}
	public String getAppointmentFlag(){
		return this.appointmentFlag;
	}
	public void setOnlinePaymentFlag(String onlinePaymentFlag){
		this.onlinePaymentFlag = onlinePaymentFlag;
	}
	public String getOnlinePaymentFlag(){
		return this.onlinePaymentFlag;
	}
	public void setLogisticsExpressFlag(String logisticsExpressFlag){
		this.logisticsExpressFlag = logisticsExpressFlag;
	}
	public String getLogisticsExpressFlag(){
		return this.logisticsExpressFlag;
	}
	public void setRunSystemLevel(String runSystemLevel){
		this.runSystemLevel = runSystemLevel;
	}
	public String getRunSystemLevel(){
		return this.runSystemLevel;
	}
	public void setRunSystemLevel$name(String runSystemLevel$name){
		this.runSystemLevel$name = runSystemLevel$name;
	}
	public String getRunSystemLevel$name(){
		return this.runSystemLevel$name;
	}
	public void setServicePoint(String servicePoint){
		this.servicePoint = servicePoint;
	}
	public String getServicePoint(){
		return this.servicePoint;
	}
	public void setServiceTime(String serviceTime){
		this.serviceTime = serviceTime;
	}
	public String getServiceTime(){
		return this.serviceTime;
	}
	public void setConsultingTelephone(String consultingTelephone){
		this.consultingTelephone = consultingTelephone;
	}
	public String getConsultingTelephone(){
		return this.consultingTelephone;
	}
	public void setFaq(String faq){
		this.faq = faq;
	}
	public String getFaq(){
		return this.faq;
	}
	public void setComplaintCall(String complaintCall){
		this.complaintCall = complaintCall;
	}
	public String getComplaintCall(){
		return this.complaintCall;
	}
	public void setItemState(String itemState){
		this.itemState = itemState;
	}
	public String getItemState(){
		return this.itemState;
	}
}
