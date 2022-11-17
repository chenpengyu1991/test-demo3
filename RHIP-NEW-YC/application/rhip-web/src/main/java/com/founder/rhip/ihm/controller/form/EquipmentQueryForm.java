package com.founder.rhip.ihm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.StringUtil;

/**
 * 人力资源
 * @author chen_tao
 *
 */
public class EquipmentQueryForm {
	
	//查询类型
	private String orgType;
	//按市级医院
	private String hospitalCode;
	//按卫生院
	private String superOrganCode;
	//按社区卫生服务站
	private String organCode;
    //按镇
    private String gbCode;
    //机构类型
    private String genreCode;
    
    public Criteria getCriteria(){
    	Criteria ca = new Criteria();
    	String orgCode="";
    	switch(orgType){
    		case "1"://按市级医院
    			orgCode = hospitalCode;
    			ca.add("ORG_TYPE","A100");
    			break;
    		case "2"://按卫生院
    			orgCode = superOrganCode;
    			ca.add("ORGAN_CODE","B100");
    			break;
    		case "3"://按社区卫生服务站
    			orgCode = organCode;
    			ca.add("ORGAN_CODE","B200");
    			break;
    		case "4"://按镇
    			orgCode = gbCode;
    			break;
    	}
    	if(StringUtil.isNotEmpty(orgCode)){
        	switch(genreCode){
        		case "A100"://市级医院
        			ca.add("ORGAN_CODE",orgCode);
        			break;
        		case "B100"://卫生院
        			ca.add("SUP_ORGAN_CODE",orgCode);
        			break;
        		case "B200"://社区卫生服务站
        			ca.add("ORGAN_CODE",orgCode);
        			break;
        		case "0"://镇
        			ca.add("GBCODE",orgCode);
        			break;
        	}    		
    	}
		return ca;
    }
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getSuperOrganCode() {
		return superOrganCode;
	}
	public void setSuperOrganCode(String superOrganCode) {
		this.superOrganCode = superOrganCode;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getGbCode() {
		return gbCode;
	}
	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}
	public String getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

}
