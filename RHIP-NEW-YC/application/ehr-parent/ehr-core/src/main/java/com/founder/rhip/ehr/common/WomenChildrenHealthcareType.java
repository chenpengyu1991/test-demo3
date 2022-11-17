package com.founder.rhip.ehr.common;


/**
 * 妇幼保健
 * 
 * @author GaoFei
 *
 */
public enum WomenChildrenHealthcareType {
	BIRTHCERTIFICATE("C01", "出生医学证明"),
	NeonatalDiseaseScreen("C02", "新生儿疾病筛查"),
	NeonatalFamilyVisit("C03", "新生儿家庭访视"),
	CHILDHEALTHCARD("C04", "儿童保健卡"),
	CHILDHEALTHEXAMINATION("C05", "儿童健康体检"),
	FRAILCHILDFOLLOWUP("C06", "体弱儿童管理随访"),
	PREMARITALHEALTHSERVICE("W01", "婚前保健服务"),
	WOMANDISEASECENSUS("W02", "妇女病普查"),
	BIRTHCONTROLSERVICE("W03", "计划生育技术服务"),
	MOTHERHOODPERIODFOLLOWUP("W04", "孕产期保健服务与高危管理随访"),
	PRENATALSCREENDIAGNOSIS("W05", "产前筛查与诊断"),
	DELIVERYRECORDINFO("W06", "分娩记录"),
	BIRTHDEFECTMONITOR("W07", "出生缺陷监测"),
	PRENATALFOLLOWUP("W08", "产前随访服务"),
	POSTNATALFOLLOWUP("W09", "产后访视服务"),
	PostpartumDaysHealthInfo("W10", "产后42天健康检查");
	
	private String code;
	private String des;
	
	private WomenChildrenHealthcareType(String code, String des) {
		this.code = code;
		this.des = des;
	}

	
	public String getCode() {
		return code;
	}

	
	public void setCode(String code) {
		this.code = code;
	}

	
	public String getDes() {
		return des;
	}

	
	public void setDes(String des) {
		this.des = des;
	}
	
}
