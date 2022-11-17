package com.founder.rhip.ehr.dto;

/**
 * 个人健康档案调阅来源
 * @author GaoFei 
 * 
 */
public enum ViewSourceTypeEnum {
	RHIP("1","区域卫生信息平台"),
	HPS("2", "健康门户"),
//	ERE("3", "外部报卡"), 统一为区域卫生信息平台
	MME("3", "微信端"),
	OTHER("4", "其他");//TODO:后期可能要增加其他类型
	
	private String code;
	private String name;
	
	private ViewSourceTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
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

	public String getName() {
		return name;
	}
	
	
}
