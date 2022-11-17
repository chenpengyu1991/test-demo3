package com.founder.rhip.dm;

/**
 * 错误信息
 * 
 * @author liuk
 * 
 */
public enum DmErrorCode {

	/**
	 * 身份证为空
	 */
	IDCARD_IS_NULL("1", "身份证为空"),
	/**
	 * 姓名为空
	 */
	NAME_IS_NULL("2", "姓名为空"),
	/**
	 * 机构编码为空
	 */
	ORG_CODE_IS_NULL("3", "机构编码为空"),
	/**
	 * 人员查询不到
	 */
	PERSON_CANNOT_FOUND("4", "人员查询不到"),
	/**
	 * 机构查询不到
	 */
	ORG_CANNOT_FOUND("5", "机构查询不到"),
	/**
	 * 身份证格式不正确
	 */
	IDCARD_IS_ERROR("6", "身份证格式不正确");

	public String code;

	public String message;

	private DmErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 获取错误信息code
	 * 
	 * @return
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 获取错误信息详细
	 * 
	 * @return
	 */
	public String getMessage() {
		return this.message;
	}

}
