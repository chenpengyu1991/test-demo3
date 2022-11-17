package com.founder.rhip.ihm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.StringUtil;

public class DaTargetQueryForm {
	
	//查询类型
	private String genreCode;
	
	private String organCode;
	private String superOrganCode;
	private String gbCode;

    
    public Criteria getCriteria(){
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(genreCode)){
    		ca.add("ORG_TYPE",genreCode);
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		ca.add("ORGAN_CODE",organCode);
    	}
    	if(StringUtil.isNotEmpty(superOrganCode)){
    		ca.add("SUP_ORGAN_CODE",superOrganCode);
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("GBCODE",gbCode);
    	}    	
		return ca;
    }
	
	public String getGenreCode() {
		return genreCode;
	}
	
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getSuperOrganCode() {
		return superOrganCode;
	}

	public void setSuperOrganCode(String superOrganCode) {
		this.superOrganCode = superOrganCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

}
