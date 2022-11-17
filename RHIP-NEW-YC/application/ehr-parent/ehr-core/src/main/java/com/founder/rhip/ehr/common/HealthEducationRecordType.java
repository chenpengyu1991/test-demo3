
package com.founder.rhip.ehr.common;

public enum HealthEducationRecordType {
	BULLETIN_BOARD("1"), // 宣传栏
	MATERIALS("2"); // 印刷资料

	private String code;

	private HealthEducationRecordType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
