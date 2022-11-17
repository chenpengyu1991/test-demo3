package com.founder.rhip.ehr.common;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-1-14
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public enum ClinicType {
    PT("01","普通门诊"),
    ZJ("02","专家门诊"),
    JZ("03","急诊"),
    ZK("04","专科"),
    ZB("05","专病"),
    LH("06","联合门诊");   
    
    private String code;
    private String description;

    ClinicType(String code,String description) {
    	this.code = code;
    	this.description = description;
    }
    
    public static ClinicType getByStauts(String code){
    	ClinicType[] ClinicTypes =  ClinicType.values();
    	for(ClinicType clinicType:ClinicTypes){
    		if(clinicType.getCode().equals(code)){
    			return clinicType;
    		}
    	}
    	return null;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
