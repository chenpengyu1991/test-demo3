package com.founder.rhip.ehr.common;

/**
 * 集成编号代码，用于集成监控分类
 * 
 * @author GaoFei
 *
 */
public enum IntegrationNumberType {
	OUTPATIENT("h01", "门诊记录"),	
	MEDIDAL_DIAGNOSIS("h02", "诊断记录"),	
	OUTPATIENT_PRESCRIPTION("h03", "门诊处方"),	
	ORDER_DRUG("h04", "医嘱用药"),	
	CHARGE("h05", "费用"),	
	INPATIENT("h06", "住院记录"),	
	SURGERY("h07","手术记录"),	
	BLOOD_TRANS("h08", "输血记录"),	
	LABORATORY_EXAMINATION("h09", "检验"),	
	PHYSICAL_EXAMINATION("h10", "体检"),	
	DISCHARGE_SUMMARY("h11", "出院小结"),	
	INPATIENT_MEDICAL_RECORD("h12", "病案首页"),	
	REFERRAL("h13", "转诊"),
	CONSULTATION("h14", "会诊"),
	ASSISTANTEXAMINATION("h15", "检查"),
	MEDICAL_EVENT("h16", "医疗活动"),
	PERSON_INFO("h17", "人员信息"),
	OBSERVATION_INFO("h18","观察信息"),
	LABORATORY_EXAMINATION_DETAIL("h19", "检验详情"),
	HEALTH_EXAMINATION("h20", "体检总结"),
	CHARGE_DETAIL("h21", "费用详情"),
	REGISTER_RECORD("h22", "门急诊挂号"),	
	DOCTOR_ADVICE("h23", "住院医嘱"),	
	TREATMENT_RECORD("h24", "治疗处置"),	
	RESCUE_RECORD("h25", "抢救数据"),	
	
	PLAN_IMMUNIZATION("v18", "计免"),
	VACCINATE_RECORD("v18-1", "预防接种登记"),
	VACCINATE_INFO("v18-2", "预防接种信息"),
	CHILDREN_TABU_RECORD("v18-3", "儿童禁忌记录"),
	CHILDREN_SIDE_REACTION("v18-4", "儿童副反应记录"),
	BIRTH_CERTIFICATE("C01", "出生医学证明"),
	BIRTH_DEFECTS_MONITOR("W07", "出生缺陷监测"),
	NEWBORN_DISEASE_SCREEN("C02", "新生儿疾病筛查"),
	NEWBORN_HOME_VISIT("C03", "新生儿家庭访视"),
	CHILD_HEALTH_CARD("C04", "儿童保健卡"),
	CHILD_PYSICAL_EXAMINATION("C05", "儿童健康体检"),
	DEBILITY_CHILDREN_FOLLOW("C06", "体弱儿童管理随访"),
	BIRTH_CONTROL("W03", "计划生育技术服务"),
	PREMARITAL_CARE("W01", "婚前保健服务"),
	PERINATAL_PERIOD_CARE("W04", "孕产期保健服务与高危管理随访"),
	PRENATAL_SCREENING_DIAGNOSIS("W05", "产前筛查与诊断"),
	PRENATAL_FOLLOW("W08", "产前随访服务"),
	DELIVERY_RECORD("W06", "分娩记录"),
	POSTNATAL_42DAY_EXAMINATION("W10", "产后42天健康检查"),
	POSTNATAL_VISIT("W09", "产后访视服务"),
	WOMEN_DISEASES_SURVEY("W02", "妇女病普查"),
	DRUG_CHARGE("d35", "药品目录收费"),
	STORAGE_IN("da01", "药库入库"),
	STORAGE_IN_DETAIL("da02", "药库入库详细"),
	STORAGE_OUT("da03", "药库出库"),
	STORAGE_OUT_DETAIL("da04", "药库出库详细"),
	STORAGE("da05", "药库库存"),
	STORAGE_RETURN("da06", "药库退货"),
	STORAGE_RETURN_DETAIL("da07", "药库退货详细"),
	PHARMACY_IN("da08", "药房入库"),
	PHARMACY_IN_DETAIL("da09", "药房入库详细"),
	PHARMACY_OUT("da10", "药房出库"),
	PHARMACY_OUT_DETAIL("da11", "药房出库详细"),
	PHARMACY("da12", "药房库存"),
	PHARMACY_RETURN("da13", "药房退货"),
	PHARMACY_RETURN_DETAIL("da14", "药房退货详细"),
	PHARMACY_CANCEL("da15", "药房退药"),
	PHARMACY_CANCEL_DETAIL("da16", "药房退药详细"),
	DRUG_UP_KEEP("da17", "药品养护"),
	CONSUMABLE_IN("da18", "耗材监控(入库单)"),
	CONSUMABLE_IN_DETAIL("da19", "耗材监控(入库明细)"),
	CONSUMABLE_OUT("da20", "耗材监控(出库单)"),
	CONSUMABLE_OUT_DETAIL("da21", "耗材监控(出库明细)"),
	CONSUMABLE_STORE("da22", "耗材监控(库存)"),
	CONSUMABLE_BREAKAGE("da23", "耗材监控(报损)"),
	EQUIPMENT_STORE("da24", "设备监控(库存)"),
	EQUIPMENT_BREAKAGE("da25", "设备监控(报损)"),
	
	BS_BLOOD_DONOR_INFO("bs01", "献血记录"),
	BS_REIMBURSEMENT("bs02", "免费用血"),
	BS_BLOODBANK("bs03", "血液库存"),
	BS_BLOOD2HOS("bs04", "血液出库"),
	
	JJ_ALARM_EVENT("jj01", "急救事件"),
	JJ_ACCEPT_EVENT("jj02", "接受事件"),
	JJ_TASK("jj03", "急救任务"),
	JJ_AMBULANCE("jj04", "急救车辆"),
	;

	private String code;
	private String name;
	
	
	private IntegrationNumberType(String code, String name) {
		this.code = code;
		this.name = name;
	}


	
	public String getName() {
		return name;
	}

	
	public String getCode() {
		return code;
	}



	
	public void setCode(String code) {
		this.code = code;
	}



	public void setName(String name) {
		this.name = name;
	}

	
}
