package com.founder.rhip.portal.common;

public enum SurveyStatus {

	SAVE("0"),//未开启调查
	START("1"),//2开启调查
	ENDS("2");//结束调查


	private String value;

	SurveyStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
