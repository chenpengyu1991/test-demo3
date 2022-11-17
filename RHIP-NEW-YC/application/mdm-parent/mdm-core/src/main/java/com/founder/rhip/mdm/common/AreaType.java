package com.founder.rhip.mdm.common;

public enum AreaType {

	VILLAGE("1"),//1代表行政村
	TOWN("2");//2代表乡镇地段
	
	private String value;

	AreaType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
