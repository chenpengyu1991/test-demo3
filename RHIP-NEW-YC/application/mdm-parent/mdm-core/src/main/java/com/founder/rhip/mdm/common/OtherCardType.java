package com.founder.rhip.mdm.common;

public enum OtherCardType {

	/**
	 * 居民身份证
	 */
	T01("01", "居民身份证"),
	/**
	 * 居民户口簿
	 */
	T02("02", "居民户口簿"),
	/**
	 * 护照
	 */
	T03("03", "护照"),
	/**
	 * 军官证
	 */
	T04("04", "军官证"),
	/**
	 * 驾驶证
	 */
	T05("05", "驾驶证"),
	/**
	 * 港涣居民来往内地通行证
	 */
	T06("06", "港涣居民来往内地通行证"),
	/**
	 * 台湾居民来往内地通行证
	 */
	T07("07", "台湾居民来往内地通行证"),
	/**
	 * 港澳台身份证
	 */
	T08("08", "港澳台身份证"),
	/**
	 * 出生证明
	 */
	T90("90", "出生证明"),
	/**
	 * 儿童保健卡
	 */
	T91("91", "儿童保健卡"),
	/**
	 * 预防接种卡
	 */
	T98("98", "预防接种卡"),
	/**
	 * 其他法定有效证件
	 */
	T99("99", "其他法定有效证件");
	
	private String code;
	
	private String name;

	OtherCardType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
}
