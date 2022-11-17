package com.founder.rhip.cdm.common;

/**
 * 随访错误编码
 * @author liuk
 *
 */
public enum FollowupErrorCode {

	/**
	 * 高血压保存失败
	 */
	HBP_SAVE_ERROR("100"),
	/**
	 * 糖尿病保存失败
	 */
	DI_SAVE_ERROR("200"),
	/**
	 * 脑卒中保存失败
	 */
	STROKE_SAVE_ERROR("300"),
	/**
	 * 冠心病保存失败
	 */
	CORONARY_SAVE_ERROR("400"),

	/**
	 * 肿瘤保存失败
	 */
	TUMOR_SAVE_ERROR("500"),

	/**
	 * 肿瘤未做首次随访
	 */
	TUMOR_NO_FIRST_FOLLOWUP("501"),

	/**
	 * 肿瘤未做首次随访
	 */
	TUMOR_FOLLOWUP_CANNOT_FOUND("502");

	private String value;

	FollowupErrorCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
