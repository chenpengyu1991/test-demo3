package com.founder.rhip.ehr.common;

/**
 * 集成监控类型
 * 
 * @author GaoFei
 *
 */
public enum IntegrationMonitorType {
	FRONTMACHINE(1, "前置机"),
	DRUGCATEGORY(2, "药品目录"),
	HOSPITALMEDICAL(3, "院内医疗数据"),
	PLANIMMUNIZATION(4, "计划免疫"),
	WOMENCHILDRENHEALTHCARE(5, "妇幼保健"),
	PHYSICALEXAMINATION(6, "体检"),
    MEDICALGOODS(8, "医药卫生用品"),
    BLOODSTATION(9, "血站"),
    DATA120(10, "120数据");

	private Integer code;
	private String name;
	
	private IntegrationMonitorType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	
	public Integer getCode() {
		return code;
	}

	
	public void setCode(Integer code) {
		this.code = code;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
