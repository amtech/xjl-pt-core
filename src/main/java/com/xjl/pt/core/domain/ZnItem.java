package com.xjl.pt.core.domain;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.annotation.TableDB;
/**
* 办事指南
* @author DomainCoderTools Arthur
*
*/
@TableDB(name="xjl_zn_item")
public class ZnItem extends XJLDomain {
	//监督电话
	private String complaintCall;
	//咨询电话
	private String consultingTelephone;
	//办理时间
	private String serviceTime;
	//办理地点
	private String servicePoint;
	//网上支付
	private String onlinePaymentFlag;
	//物流快递
	private String logisticsExpressFlag;
	//预约办理
	private String appointmentFlag;
	//通办范围
	private String openScope;
	//审查标准
	private String reviewStandard;
	//办理形式
	private String serviceType;
	//办理流程
	private String progress;
	//申请材料
	private String applicationMaterials;
	//收费标准
	private String chargeStandard;
	//结果样本
	private String resultSample;
	//结果名称
	private String resultName;
	//承诺办结时限
	private String commitmentTimeLimit;
	//法定办结时限
	private String legalTimeLimit;
	//设定依据
	private String according;
	//事项类型
	private String itemType;
	//事项名称
	private String itemName;
	//办事指条目南编号
	private String itemId;
	//实施机构编号
	private String organizationId;
	
	public void setComplaintCall(String complaintCall){
		this.complaintCall = complaintCall;
	}
	public String getComplaintCall(){
		return this.complaintCall;
	}
	public void setConsultingTelephone(String consultingTelephone){
		this.consultingTelephone = consultingTelephone;
	}
	public String getConsultingTelephone(){
		return this.consultingTelephone;
	}
	public void setServiceTime(String serviceTime){
		this.serviceTime = serviceTime;
	}
	public String getServiceTime(){
		return this.serviceTime;
	}
	public void setServicePoint(String servicePoint){
		this.servicePoint = servicePoint;
	}
	public String getServicePoint(){
		return this.servicePoint;
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
	public void setAppointmentFlag(String appointmentFlag){
		this.appointmentFlag = appointmentFlag;
	}
	public String getAppointmentFlag(){
		return this.appointmentFlag;
	}
	public void setOpenScope(String openScope){
		this.openScope = openScope;
	}
	public String getOpenScope(){
		return this.openScope;
	}
	public void setReviewStandard(String reviewStandard){
		this.reviewStandard = reviewStandard;
	}
	public String getReviewStandard(){
		return this.reviewStandard;
	}
	public void setServiceType(String serviceType){
		this.serviceType = serviceType;
	}
	public String getServiceType(){
		return this.serviceType;
	}
	public void setProgress(String progress){
		this.progress = progress;
	}
	public String getProgress(){
		return this.progress;
	}
	public void setApplicationMaterials(String applicationMaterials){
		this.applicationMaterials = applicationMaterials;
	}
	public String getApplicationMaterials(){
		return this.applicationMaterials;
	}
	public void setChargeStandard(String chargeStandard){
		this.chargeStandard = chargeStandard;
	}
	public String getChargeStandard(){
		return this.chargeStandard;
	}
	public void setResultSample(String resultSample){
		this.resultSample = resultSample;
	}
	public String getResultSample(){
		return this.resultSample;
	}
	public void setResultName(String resultName){
		this.resultName = resultName;
	}
	public String getResultName(){
		return this.resultName;
	}
	public void setCommitmentTimeLimit(String commitmentTimeLimit){
		this.commitmentTimeLimit = commitmentTimeLimit;
	}
	public String getCommitmentTimeLimit(){
		return this.commitmentTimeLimit;
	}
	public void setLegalTimeLimit(String legalTimeLimit){
		this.legalTimeLimit = legalTimeLimit;
	}
	public String getLegalTimeLimit(){
		return this.legalTimeLimit;
	}
	public void setAccording(String according){
		this.according = according;
	}
	public String getAccording(){
		return this.according;
	}
	public void setItemType(String itemType){
		this.itemType = itemType;
	}
	public String getItemType(){
		return this.itemType;
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
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
}
