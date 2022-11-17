
package com.founder.rhip.ehr.common;

/**
 * 健康教育资源分类
 * 
 * @author GaoFei
 * 
 */
public enum HealthEducationResourceType {
	DEVICE("1"),  // 宣传设备
	POSITION("2"), // 宣传阵地
	MATERIAL("3"); // 宣传材料

	private String code;

	private HealthEducationResourceType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
