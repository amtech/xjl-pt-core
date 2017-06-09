package com.xjl.pt.sx.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.xjl.pt.core.mapper.XJLMapper;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.sx.domain.SxImplItem;
/**
 * 实施清单
 * @author MapperCoderTools lilisheng
 *
*/
@Repository
public interface SxImplItemMapper {
	static final String TABLE_NAME = "xjl_sx_impl_item";
	static final String SELECT_ALL = "item_id as itemId,base_code as baseCode,item_name as itemName,item_type as itemType,according as according,impl_level as implLevel,permission as permission,impl_content as implContent,impl_org as implOrg,impl_org_type as implOrgType,legal_time_limit as legalTimeLimit,acceptance_conditions as acceptanceConditions,application_materials as applicationMaterials,join_org as joinOrg,intermediary_service as intermediaryService,progress as progress,quantitative_limit as quantitativeLimit,result_name as resultName,result_sample as resultSample,charge_flag as chargeFlag,charge_standard as chargeStandard,charge_according as chargeAccording,service_object as serviceObject,office_type as officeType,commitment_time_limit as commitmentTimeLimit,open_scope as openScope,service_type as serviceType,appointment_flag as appointmentFlag,online_payment_flag as onlinePaymentFlag,logistics_express_flag as logisticsExpressFlag,run_system_level as runSystemLevel,service_point as servicePoint,service_time as serviceTime,consulting_telephone as consultingTelephone,FAQ as faq,complaint_call as complaintCall,item_state as itemState,"+ XJLMapper.FIX_SELECT_FIELD;
	static final String INSERT_FIELD = "item_id,base_code,item_name,item_type,according,impl_level,permission,impl_content,impl_org,impl_org_type,legal_time_limit,acceptance_conditions,application_materials,join_org,intermediary_service,progress,quantitative_limit,result_name,result_sample,charge_flag,charge_standard,charge_according,service_object,office_type,commitment_time_limit,open_scope,service_type,appointment_flag,online_payment_flag,logistics_express_flag,run_system_level,service_point,service_time,consulting_telephone,FAQ,complaint_call,item_state," + XJLMapper.FIX_INSERT_FIELD;
	static final String INSERT_VALUE = "#{itemId},#{baseCode},#{itemName},#{itemType},#{according},#{implLevel},#{permission},#{implContent},#{implOrg},#{implOrgType},#{legalTimeLimit},#{acceptanceConditions},#{applicationMaterials},#{joinOrg},#{intermediaryService},#{progress},#{quantitativeLimit},#{resultName},#{resultSample},#{chargeFlag},#{chargeStandard},#{chargeAccording},#{serviceObject},#{officeType},#{commitmentTimeLimit},#{openScope},#{serviceType},#{appointmentFlag},#{onlinePaymentFlag},#{logisticsExpressFlag},#{runSystemLevel},#{servicePoint},#{serviceTime},#{consultingTelephone},#{faq},#{complaintCall},#{itemState}," + XJLMapper.FIX_INSERT_VALUE;
	static final String UPDATE_FIELD = "base_code=#{baseCode},item_name=#{itemName},item_type=#{itemType},according=#{according},impl_level=#{implLevel},permission=#{permission},impl_content=#{implContent},impl_org=#{implOrg},impl_org_type=#{implOrgType},legal_time_limit=#{legalTimeLimit},acceptance_conditions=#{acceptanceConditions},application_materials=#{applicationMaterials},join_org=#{joinOrg},intermediary_service=#{intermediaryService},progress=#{progress},quantitative_limit=#{quantitativeLimit},result_name=#{resultName},result_sample=#{resultSample},charge_flag=#{chargeFlag},charge_standard=#{chargeStandard},charge_according=#{chargeAccording},service_object=#{serviceObject},office_type=#{officeType},commitment_time_limit=#{commitmentTimeLimit},open_scope=#{openScope},service_type=#{serviceType},appointment_flag=#{appointmentFlag},online_payment_flag=#{onlinePaymentFlag},logistics_express_flag=#{logisticsExpressFlag},run_system_level=#{runSystemLevel},service_point=#{servicePoint},service_time=#{serviceTime},consulting_telephone=#{consultingTelephone},FAQ=#{faq},complaint_call=#{complaintCall},item_state=#{itemState}," + XJLMapper.FIX_UPDATE_FIELD;
	@Insert("insert into " + TABLE_NAME + "(" + INSERT_FIELD + ") values("+INSERT_VALUE+")")
	public void insert(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + XJLMapper.FIX_DELETE_FIELD + " where item_id=#{itemId}")	
	public void delete(XJLDomain domain);
	@Update("update " + TABLE_NAME + " set " + UPDATE_FIELD + " where item_id=#{itemId}")	
	public void update(XJLDomain domain);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' order by create_date desc")
	public List<SxImplItem> selectAll();
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where item_id=#{itemId}")
	public SxImplItem selectById(String dictId);
	@Select("select " + SELECT_ALL + " from " + TABLE_NAME + " where state='A' and (base_code like '%'||#{0}||'%' or item_name like  '%'||#{0}||'%' or according like  '%'||#{0}||'%' "
			+ " or impl_content like '%'||#{0}||'%' or acceptance_conditions like '%'||#{0}||'%' or result_name like  '%'||#{0}||'%') order by create_date desc")
	public List<SxImplItem> selectBySearch(String search);
	
	
}