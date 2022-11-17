package com.founder.rhip.ehr.common;

import java.util.Date;
import java.util.Map;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

/**
 * 集成数据数量记录工具
 * 
 * @author GaoFei
 *
 */
public class IntegrationMonitorRecorder {
	
public static final String HEALTH_EXAMINATION = "health_examination";
	
	public static final String DISCHARGE_SUMMARY = "discharge_summary"; // 出院小结
	public static final String OUTPATIENT_PRESCRIPTION = "outpatient_prescription"; // 门诊处方
	public static final String OUTPATIENT_RECORD = "outpatient_record"; // 门诊
	public static final String OPERATION_RECORD = "operation_record"; // 手术记录
	public static final String CONSULTATION_RECORD = "consultation_record"; // 会诊记录
	public static final String LABORATORY_EXAMINATION_RECORD = "laboratory_examination_record"; // 检验记录
	public static final String ASSISTANT_EXAMINATION_RECORD = "assistant_examination_record"; // 辅助检查
	public static final String EXPENSE_RECORD = "expense_record"; // 收费记录
	public static final String REFERRAL_RECORD = "referral_record"; // 转诊记录
	public static final String INPATIENT_ORDER = "inpatient_order"; // 住院医嘱
	public static final String INPATIENT_RECORD = "inpatient_record"; // 住院记录
	public static final String DIAGNOSIS_RECORD = "diagnosis_record"; // 诊断记录
	public static final String TRANS_BLOOD_RECORD = "trans_blood_record"; // 输血记录
	public static final String INPATIENT_MEDICAL_RECORD_HOME_PAGE = "inpatient_medical_record_home_page"; // 住院病案首页
	public static final String PHYSICAL_EXAMINATION_REPORT = "physical_examination_report"; // 体检报告
	public static final String DOCTOR_ADVICE = "doctor_advice"; // 医嘱记录
	
	public static final String BIRTH_CERTIFICATE = "C01";
	public static final String NEONATAL_DISEASE_SCREEN = "C02";
	public static final String NEONATAL_FAMILY_VISIT = "C03";
	public static final String CHILD_HEALTHCARD = "C04";
	public static final String CHILD_HEALTHEXAMINATION = "C05";
	public static final String FRAIL_CHILD_FOLLOWUP = "C06";
	public static final String PREMARITAL_HEALTH_SERVICE = "W01";
	public static final String WOMAN_DISEASE_CENSUS = "W02";
	public static final String BIRTH_CONTROL_SERVICE = "W03";
	public static final String MOTHERHOOD_PERIOD_FOLLOWUP = "W04";
	public static final String PRENATAL_SCREEN_DIAGNOSIS = "W05";
	public static final String DELIVERY_RECORD_INFO = "W06";
	public static final String BIRTH_DEFECT_MONITOR = "W07";
	public static final String PRENATAL_FOLLOWUP = "W08";
	public static final String POSTNATAL_FOLLOWUP = "W09";
	public static final String POSTPARTUM_DAYS_HEALTHINFO = "W10";
	
	public static final String VACCINATE_RECORD = "v18-1";
	public static final String VACCINATE_INFO = "v18-2";
	public static final String CHILDREN_TABU_RECORD = "v18-3";
	public static final String CHILDREN_SIDE_REACTION = "v18-4";
	//药品监管
	public static final String STORAGE_IN = "storage_in"; //药库入库
	
	public static final String STORAGE_IN_DETAIL = "storage_in_detail"; // 药库入库详细
	
	public static final String STORAGE_OUT = "storage_out"; // 药库出库
	
	public static final String STORAGE_OUT_DETAIL = "storage_out_detail"; // 药库出库详细
	
	public static final String STORAGE = "storage"; // 药库库存
	
	public static final String STORAGE_RETURN = "storage_return"; // 药库退货
	
	public static final String STORAGE_RETURN_DETAIL = "storage_return_detail"; // 药库退货详细
	
	public static final String PHARMACY_IN = "pharmacy_in"; // 药房入库
	
	public static final String PHARMACY_IN_DETAIL = "pharmacy_in_detail"; // 药房入库详细
	
	public static final String PHARMACY_OUT = "pharmacy_out"; // 药房出库
	
	public static final String PHARMACY_OUT_DETAIL = "pharmacy_out_detail"; // 药房出库详细
	
	public static final String PHARMACY = "pharmacy"; // 药房库存
	
	public static final String PHARMACY_RETURN = "pharmacy_return"; // 药房退货
	
	public static final String PHARMACY_RETURN_DETAIL = "pharmacy_return_detail"; // 药房退货详细
	
	public static final String PHARMACY_CANCEL = "pharmacy_cancel"; // 药房退药
	
	public static final String PHARMACY_CANCEL_DETAIL = "pharmacy_cancel_detail"; // 药房退药详细
	
	public static final String DRUG_UP_KEEP = "drug_up_keep"; // 药品养护
	
	public static final String CONSUMABLE_IN = "consumable_in"; // 耗材监控(入库单)
	
	public static final String CONSUMABLE_IN_DETAIL = "consumable_in_detail"; // 耗材监控(入库明细)
	
	public static final String CONSUMABLE_OUT = "consumable_out"; // 耗材监控(出库单)
	
	public static final String CONSUMABLE_OUT_DETAIL = "consumable_out_detail"; // 耗材监控(出库明细)
	
	public static final String CONSUMABLE_STORE = "consumable_store"; // 耗材监控(库存)
	
	public static final String CONSUMABLE_BREAKAGE = "consumable_breakage"; // 耗材监控(报损)
	
	public static final String EQUIPMENT_STORE = "equipment_store"; // 设备监控(库存)
	
	public static final String EQUIPMENT_BREAKAGE = "equipment_breakage"; // 设备监控(报损)
	
	/**
	 * 记录集成医疗数据处理条数
	 * 
	 * @param map 记录插入、更新、失败数量记录
	 * @param key 机构代码
	 * @param type 类型0：实际插入数量，1：实际更新数量，2：失败数量
	 */
	public static void recordMedicalCount(Map<String, Long[]> map, String key, int type) {
		if (map == null || key == null) {
			return;
		}
		Long[] counts = null;
		if ((counts = map.get(key)) == null) {
			counts = new Long[10]; // counts[0]:插入数量 counts[1]:更新数量 counts[2]:失败数量 counts[3]:应传数量 counts[4]:｛用药数量或其他类型数量｝
			counts[type] = 1L;
			map.put(key, counts);
		} else {
			if (counts[type] == null) {
				counts[type] = 1L;
			} else {
				counts[type] += 1;
			}
		}
	}
	
	/**
	 * 记录公卫数据集成数据量统计
	 * 
	 * @param map 记录新增、更新、失败数量记录
	 * @param type 类型0:实际插入数量，1：实际更新数量，2：失败数量
	 * @param category 
	 */
	public static void recordHealthCareCount(Map<String, Long[]> map, int type, String category) {
		if (map == null || category == null) {
			return;
		}
		Long[] counts = null;
		if ((counts = map.get(category)) == null) {
			counts = new Long[3]; // counts[0]:新增数量 counts[1]:更新数量 counts[2]:失败数量
			counts[type] = 1L;
		} else {
			if (counts[type] == null) {
				counts[type] = 1L;
			} else {
				counts[type] += 1;
			}
		}
		map.put(category, counts);
	}
	
	/**
	 * 匹配集成健康类型
	 * @param type
	 * @return
	 */
	public static IntegrationNumberType matchIntegrationType(String type) {
		if (ObjectUtil.isNullOrEmpty(type)) {
			return null;
		}
		IntegrationNumberType integrationNumberType = null;
		switch (type) {
			case OUTPATIENT_RECORD:
				integrationNumberType = IntegrationNumberType.OUTPATIENT;
				break;
			case INPATIENT_RECORD:
				integrationNumberType = IntegrationNumberType.INPATIENT;
				break;
			case OUTPATIENT_PRESCRIPTION:
				integrationNumberType = IntegrationNumberType.OUTPATIENT_PRESCRIPTION;
				break;
			case LABORATORY_EXAMINATION_RECORD:
				integrationNumberType = IntegrationNumberType.LABORATORY_EXAMINATION;
				break;
			case EXPENSE_RECORD:
				integrationNumberType = IntegrationNumberType.CHARGE;
				break;
			case DIAGNOSIS_RECORD:
				integrationNumberType = IntegrationNumberType.MEDIDAL_DIAGNOSIS;
				break;
			case OPERATION_RECORD:
				integrationNumberType = IntegrationNumberType.SURGERY;
				break;
			case PHYSICAL_EXAMINATION_REPORT:
				integrationNumberType = IntegrationNumberType.PHYSICAL_EXAMINATION;
				break;
			case DISCHARGE_SUMMARY:
				integrationNumberType = IntegrationNumberType.DISCHARGE_SUMMARY;
				break;
			case INPATIENT_MEDICAL_RECORD_HOME_PAGE:
				integrationNumberType = IntegrationNumberType.INPATIENT_MEDICAL_RECORD;
				break;
			case CONSULTATION_RECORD:
				integrationNumberType = IntegrationNumberType.CONSULTATION;
				break;
			case REFERRAL_RECORD:
				integrationNumberType = IntegrationNumberType.REFERRAL;
				break;
			case DOCTOR_ADVICE:
				integrationNumberType = IntegrationNumberType.DOCTOR_ADVICE;
				break;
			case BIRTH_CERTIFICATE:
				integrationNumberType = IntegrationNumberType.BIRTH_CERTIFICATE;
				break;
			case NEONATAL_DISEASE_SCREEN:
				integrationNumberType = IntegrationNumberType.NEWBORN_DISEASE_SCREEN;
				break;
			case NEONATAL_FAMILY_VISIT:
				integrationNumberType = IntegrationNumberType.NEWBORN_HOME_VISIT;
				break;
			case CHILD_HEALTHCARD:
				integrationNumberType = IntegrationNumberType.CHILD_HEALTH_CARD;
				break;
			case CHILD_HEALTHEXAMINATION:
				integrationNumberType = IntegrationNumberType.CHILD_PYSICAL_EXAMINATION;
				break;
			case FRAIL_CHILD_FOLLOWUP:
				integrationNumberType = IntegrationNumberType.DEBILITY_CHILDREN_FOLLOW;
				break;
			case PREMARITAL_HEALTH_SERVICE:
				integrationNumberType = IntegrationNumberType.PREMARITAL_CARE;
				break;
			case WOMAN_DISEASE_CENSUS:
				integrationNumberType = IntegrationNumberType.WOMEN_DISEASES_SURVEY;
				break;
			case BIRTH_CONTROL_SERVICE:
				integrationNumberType = IntegrationNumberType.BIRTH_CONTROL;
				break;
			case MOTHERHOOD_PERIOD_FOLLOWUP:
				integrationNumberType = IntegrationNumberType.PERINATAL_PERIOD_CARE;
				break;
			case PRENATAL_SCREEN_DIAGNOSIS:
				integrationNumberType = IntegrationNumberType.PRENATAL_SCREENING_DIAGNOSIS;
				break;
			case DELIVERY_RECORD_INFO:
				integrationNumberType = IntegrationNumberType.DELIVERY_RECORD;
				break;
			case BIRTH_DEFECT_MONITOR:
				integrationNumberType = IntegrationNumberType.BIRTH_DEFECTS_MONITOR;
				break;
			case PRENATAL_FOLLOWUP:
				integrationNumberType = IntegrationNumberType.PRENATAL_FOLLOW;
				break;
			case POSTNATAL_FOLLOWUP:
				integrationNumberType = IntegrationNumberType.POSTNATAL_VISIT;
				break;
			case POSTPARTUM_DAYS_HEALTHINFO:
				integrationNumberType = IntegrationNumberType.POSTNATAL_42DAY_EXAMINATION;
				break;
			case VACCINATE_RECORD:
				integrationNumberType = IntegrationNumberType.VACCINATE_RECORD;
				break;
			case VACCINATE_INFO:
				integrationNumberType = IntegrationNumberType.VACCINATE_INFO;
				break;
			case CHILDREN_TABU_RECORD:
				integrationNumberType = IntegrationNumberType.CHILDREN_TABU_RECORD;
				break;
			case CHILDREN_SIDE_REACTION:
				integrationNumberType = IntegrationNumberType.CHILDREN_SIDE_REACTION;
				break;
			//药品监管begin modify by:MeiXingjian
			case STORAGE_IN:
				integrationNumberType = IntegrationNumberType.STORAGE_IN;
				break;
			case STORAGE_IN_DETAIL:
				integrationNumberType = IntegrationNumberType.STORAGE_IN_DETAIL;
				break;
			case STORAGE_OUT:
				integrationNumberType = IntegrationNumberType.STORAGE_OUT;
				break;
			case STORAGE_OUT_DETAIL:
				integrationNumberType = IntegrationNumberType.STORAGE_OUT_DETAIL;
				break;
			case STORAGE:
				integrationNumberType = IntegrationNumberType.STORAGE;
				break;
			case STORAGE_RETURN:
				integrationNumberType = IntegrationNumberType.STORAGE_RETURN;
				break;
			case STORAGE_RETURN_DETAIL:
				integrationNumberType = IntegrationNumberType.STORAGE_RETURN_DETAIL;
				break;
			case PHARMACY_IN:
				integrationNumberType = IntegrationNumberType.PHARMACY_IN;
				break;
			case PHARMACY_IN_DETAIL:
				integrationNumberType = IntegrationNumberType.PHARMACY_IN_DETAIL;
				break;
			case PHARMACY_OUT:
				integrationNumberType = IntegrationNumberType.PHARMACY_OUT;
				break;
			case PHARMACY_OUT_DETAIL:
				integrationNumberType = IntegrationNumberType.PHARMACY_OUT_DETAIL;
				break;
			case PHARMACY:
				integrationNumberType = IntegrationNumberType.PHARMACY;
				break;
			case PHARMACY_RETURN:
				integrationNumberType = IntegrationNumberType.PHARMACY_RETURN;
				break;
				
			case PHARMACY_RETURN_DETAIL:
				integrationNumberType = IntegrationNumberType.PHARMACY_RETURN_DETAIL;
				break;
			case PHARMACY_CANCEL:
				integrationNumberType = IntegrationNumberType.PHARMACY_CANCEL;
				break;
			case PHARMACY_CANCEL_DETAIL:
				integrationNumberType = IntegrationNumberType.PHARMACY_CANCEL_DETAIL;
				break;
			case DRUG_UP_KEEP:
				integrationNumberType = IntegrationNumberType.DRUG_UP_KEEP;
				break;
			case CONSUMABLE_IN:
				integrationNumberType = IntegrationNumberType.CONSUMABLE_IN;
				break;
			case CONSUMABLE_IN_DETAIL:
				integrationNumberType = IntegrationNumberType.CONSUMABLE_IN_DETAIL;
				break;
			case CONSUMABLE_OUT:
				integrationNumberType = IntegrationNumberType.CONSUMABLE_OUT;
				break;
			case CONSUMABLE_OUT_DETAIL:
				integrationNumberType = IntegrationNumberType.CONSUMABLE_OUT_DETAIL;
				break;
			case CONSUMABLE_STORE:
				integrationNumberType = IntegrationNumberType.CONSUMABLE_STORE;
				break;
			case CONSUMABLE_BREAKAGE:
				integrationNumberType = IntegrationNumberType.CONSUMABLE_BREAKAGE;
				break;
			case EQUIPMENT_STORE:
				integrationNumberType = IntegrationNumberType.EQUIPMENT_STORE;
				break;
			case EQUIPMENT_BREAKAGE:
				integrationNumberType = IntegrationNumberType.EQUIPMENT_BREAKAGE;
				break;
			//药品监管end modify by:MeiXingjian
			default:
				break;
		}
		return integrationNumberType;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date generateCurrentDate() {
		// 处理日期
		String dateStr = DateUtil.toDateString(new Date(), null);
		Date date = DateUtil.parseSimpleDate(dateStr, "yyyy/MM/dd");
		return date;
	}
}
