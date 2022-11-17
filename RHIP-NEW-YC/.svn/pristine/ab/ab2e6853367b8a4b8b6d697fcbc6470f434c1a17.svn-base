package com.founder.rhip.ihm.controller.form;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.TargetDTO;

public class TargetQueryForm {
	//中心代码
	private String inputSuperOrganCode;
	//站代码
	private String inputOrganCode;
	//镇代码
	private String gBCode;
    //慢病or传染病
    private String viewType;
	/** 
	* @Title: getSelectOrgCode 
	* @Description: 获取选中的代码 
	* @param @return
	* @return String
	* @throws 
	*/
	public String getSelectOrgCode(){
		if(ObjectUtil.isNotEmpty(inputOrganCode)){
			return inputOrganCode;
		}else if(ObjectUtil.isNotEmpty(inputSuperOrganCode)){
			return inputSuperOrganCode;
		}
		return gBCode;
	}
	
	/** 
	* @Title: getSelectOrgCodeType 
	* @Description: 获取选中的机构类型
	* @param @return
	* @return OrgGenreCode
	* @throws 
	*/
	public Integer getSelectOrgCodeType(){
		if(ObjectUtil.isNotEmpty(inputOrganCode)){
			return TargetDTO.STATION;
		}else if(ObjectUtil.isNotEmpty(inputSuperOrganCode)){
			return TargetDTO.CENTER;
		}else if(ObjectUtil.isNotEmpty(gBCode)){
			return TargetDTO.GB;
		}
		return TargetDTO.NO_SELECT;
	}
	
	/** 
	* @Title: getSelectOrgCodeNextCodeType 
	* @Description: 获取选中机构的下级机构类型
	* @param @return
	* @return OrgGenreCode
	* @throws 
	*/
	public Integer getSelectOrgCodeNextCodeType(){
		if(ObjectUtil.isNotEmpty(inputOrganCode)){
			return TargetDTO.STATION;
		}else if(ObjectUtil.isNotEmpty(inputSuperOrganCode)){
			return TargetDTO.STATION;
		}else if(ObjectUtil.isNotEmpty(gBCode)){
			return TargetDTO.CENTER;
		}
		return TargetDTO.GB;
	}
	
	public String getInputSuperOrganCode() {
		return inputSuperOrganCode;
	}
	public void setInputSuperOrganCode(String inputSuperOrganCode) {
		this.inputSuperOrganCode = inputSuperOrganCode;
	}
	public String getInputOrganCode() {
		return inputOrganCode;
	}
	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}
	public String getgBCode() {
		return gBCode;
	}
	public void setgBCode(String gBCode) {
		this.gBCode = gBCode;
	}

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }
}
