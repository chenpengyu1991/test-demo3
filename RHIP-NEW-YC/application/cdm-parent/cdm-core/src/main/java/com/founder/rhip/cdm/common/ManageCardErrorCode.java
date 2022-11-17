package com.founder.rhip.cdm.common;

public enum ManageCardErrorCode {
	/**
	 * 信息不全
	 */
	DISEASEINFO_INFO_ERROR("0"),
	/**
	 * 信息不全
	 */
    INFO_NOT_COMPLETE("1"),
    /**
	 *高血压已经管理
	 */
    HBP_HAS_MANAGED("2"),
    /**
   	 *糖尿病已经管理
   	 */
    DI_HAS_MANAGED("3"),
    /**
   	 *脑卒中已经管理
   	 */
    STROKE_HAS_MANAGED("4"),
    /**
   	 *冠心病已经管理
   	 */
    CORONARY_HAS_MANAGED("5"),
    /**
   	 *肿瘤已经管理
   	 */
    TUMOR_HAS_MANAGED("6"),
    /**
     * 报卡转为管理卡失败
     */
   COVERT_TO_DIS_ERROR("7"),
    /**
     * 获取纳入报卡失败
     */
    GET_TO_BE_MANAGED_REPORT_ERROR("8"),
    /**
     * 更新报卡纳入标志失败
     */
    UPDATE_REPORT_STATUS_ERROR("9"),
    /**
     * 管理卡保存失败
     */
    DISEASEINFO_SAVE_ERROR("10"),
    
    /**
     * 该人员已经其他社区中被管理
     */
    MANAGERED_BY_ANOTHER_ORG("11"),
	
    /**
     * 该人员已经被注销
     */
    PERSON_RECORD_IS_CANCEL("12"),

	/**
	 * 该人员未在本社区建档
	 */
	NO_PERSON_RECOR("13");

	private String value;

	ManageCardErrorCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
