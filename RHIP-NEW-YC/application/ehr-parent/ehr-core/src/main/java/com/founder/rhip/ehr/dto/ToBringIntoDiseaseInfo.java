package com.founder.rhip.ehr.dto;

import java.io.Serializable;

/**
 * 带纳入管理卡信息
 * 
 * @author liuk
 * 
 */
public class ToBringIntoDiseaseInfo implements Serializable {
	private static final long serialVersionUID = -6614370042427526635L;
	/**
	 * 病类型
	 */
	private String diseaseType;
	/**
	 * 疾病代码 icd_code
	 */
	private String icdCode;

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}
}
