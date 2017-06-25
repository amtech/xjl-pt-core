package com.xjl.pt.core.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZnItem;
/**
 * 办事指南
 * @author MapperCoderTools Arthur
 *
*/
@Repository
public interface ZnItemMapper {
	static final String TABLE_NAME = "xjl_zn_item";
	static final String SELECT_ALL = "complaint_call as complaintCall,consulting_telephone as consultingTelephone,service_time as serviceTime,service_point as servicePoint,online_payment_flag as onlinePaymentFlag,logistics_express_flag as logisticsExpressFlag,appointment_flag as appointmentFlag,open_scope as openScope,review_standard as reviewStandard,service_type as serviceType,progress as progress,application_materials as applicationMaterials,charge_standard as chargeStandard,result_sample as resultSample,result_name as resultName,commitment_time_limit as commitmentTimeLimit,legal_time_limit as legalTimeLimit,according as according,item_type as itemType,item_name as itemName,item_id as itemId,organization_id as organizationId,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "complaint_call,consulting_telephone,service_time,service_point,online_payment_flag,logistics_express_flag,appointment_flag,open_scope,review_standard,service_type,progress,application_materials,charge_standard,result_sample,result_name,commitment_time_limit,legal_time_limit,according,item_type,item_name,item_id,organization_id" + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{complaintCall},#{consultingTelephone},#{serviceTime},#{servicePoint},#{onlinePaymentFlag},#{logisticsExpressFlag},#{appointmentFlag},#{openScope},#{reviewStandard},#{serviceType},#{progress},#{applicationMaterials},#{chargeStandard},#{resultSample},#{resultName},#{commitmentTimeLimit},#{legalTimeLimit},#{according},#{itemType},#{itemName},#{itemId},#{organizationId}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "complaint_call=#{complaintCall},consulting_telephone=#{consultingTelephone},service_time=#{serviceTime},service_point=#{servicePoint},online_payment_flag=#{onlinePaymentFlag},logistics_express_flag=#{logisticsExpressFlag},appointment_flag=#{appointmentFlag},open_scope=#{openScope},review_standard=#{reviewStandard},service_type=#{serviceType},progress=#{progress},application_materials=#{applicationMaterials},charge_standard=#{chargeStandard},result_sample=#{resultSample},result_name=#{resultName},commitment_time_limit=#{commitmentTimeLimit},legal_time_limit=#{legalTimeLimit},according=#{according},item_type=#{itemType},item_name=#{itemName},item_id=#{itemId}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<ZnItem> selectAll();
	@Select("select count(1) from "+TABLE_NAME+" where state='A' and organization_id=#{organizationId}")
	public int selectZnItemCount(String organizationId);
	
	
	
}