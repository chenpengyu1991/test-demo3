package com.founder.rhip.ehr.common;

public enum CdmParamCode {
	/**
	 * 收缩压
	 */
	 SYSTOLIC_BLOOD_PRESSURE("CDM0000014"),
	/**
	 * 舒张压
	 */
	 DIASTOLIC_BLOOD_PRESSURE("CDM0000015"),
	/**
	 * 是否吸烟
	 */
	SMOKE("CDM0000001"),
	/**
	 * 血糖值
	 */
	BLOOD_SUGAR_VALUES("CDM0000002"),
	/**
	 * 血清胆固醇值
	 */
	SERUM_TOTAL_CHOLESTEROL("CDM0000003"),
	/**
	 * 男性腰围值
	 */
	MALE_WAISTLINE("CDM0000004"),
	/**
	 * 女性腰围值
	 */
	FEMALE_MALE_WAISTLINE("CDM0000005"),
	/**
	 * 年龄段
	 */
	AGES("CDM0000006"),
	/**
	 * 体重
	 */
	BMI("CDM0000007"),
	/**
	 * 运动时间
	 */
	SPORT_TIME("CDM0000008"),
	/**
	 * 吸烟状况
	 */
	SMOKEING_STATUS("CDM0000009"),
	/**
	 * 饮酒状况
	 */
	DRINKING_STATUS("CDM0000010"),
	/**
	 * 总胆固醇
	 */
	TOTAL_CHOLESTEROL("CDM0000011"),
	/**
	 * 甘油三酯
	 */
	TRIGLYCERIDES("CDM0000012"),
	/**
	 * 家族史
	 */
	FAMILY_HISTORY("CDM0000013"),
	/**
	 * 第一类标准
	 */
	FIRST_CLASS_STANDARD("CDM000000A"),
	/**
	 * 第二类标准
	 */
	SECOND_CLASS_STANDARD("CDM000000B");
	private String value;

	CdmParamCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
