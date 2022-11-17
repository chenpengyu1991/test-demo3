package com.founder.rhip.idm.dto;


import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.ListCr;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SchistosomeDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /*状态表id*/
    private String idmId;
    
    /*唯一事件id*/
    private String eventId;
    
    /*事件表id*/
    private String singleId;
    
    /*患者id*/
    private Long personId;
    
    /*当前操作者*/
    private User currentUser;
    /*当前操作机构*/
    private Organization currentOrg;
    
    /*专项状态*/
    private Integer specialStatus;

    /*一般情况*/
    private GeneralCondition generalCondition;

    /*实验室检查*/
    private LabExamine labExamine;

    /*主要临床表现*/
    private ClinicalManifestations clinicalManifestations;
    
    /*疫源地处理、密切接触者登记*/
    private EpidemicFocusClose epidemicFocusClose;
    
    /*诊断依据、诊断结果 */   
    private Diagnosis diagnosis;
    
    /*卡片信息*/
    private CaseInformation caseInformation;
    
    /*既往史*/
    private PastHistory pastHistory;

    /*治疗记录*/
    private ListRr listRr;
  
    /*其他*/
    private OtherCondition otherCondition;
    
    /*治疗表－列表*/
    private List<ListRr> listRrs;
    
    /*治疗表－JSON字符串*/
    private String listRrJson;
    
    /*变更记录表－列表*/
    private List<ListCr> listCrs;
    
    /*变更记录表－JSON字符串*/
    private String listCrJson;
    
    /*患者信息*/
    private PersonInfo personInfo;
    
    /*患者信息*/
    private String[] personInfoParam;
    
    /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
    /*注销标志*/
    private Integer logoff = 0;
    /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
    
    public String getSingleId() {
        return singleId;
    }

    public void setSingleId(String singleId) {
        this.singleId = singleId;
    }

    public GeneralCondition getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(GeneralCondition generalCondition) {
        this.generalCondition = generalCondition;
    }

    public LabExamine getLabExamine() {
        return labExamine;
    }

    public void setLabExamine(LabExamine labExamine) {
        this.labExamine = labExamine;
    }

    public CaseInformation getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo) && ObjectUtil.isNotEmpty(this.generalCondition)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getGeneralCondition());
            personInfo.setHouseholdType(this.getGeneralCondition().getFloatPopulation());
            personInfo.setUpdateDate(new Date());
            if(SpecialEvents.S_BlOOD.getValue().equals(eventId) //暂住地登记不更新地址
            		&& this.generalCondition.getFloatPopulation().equals("2") ){
            	personInfo.setPaAddress(null);
            	personInfo.setPahouseNumber(null);
            	personInfo.setPastreet(null);
            	personInfo.setPatownShip(null);
            	personInfo.setHrAddress(null);
            	personInfo.setHrhouseNumber(null);
            	personInfo.setHrstreet(null);
            	personInfo.setHrtownShip(null);
            }
            //患者ID add by yjf 2014/01/07
            if(ObjectUtil.isNotEmpty(this.personId)){
            	personInfo.setId(this.personId);
            }else{
            	personInfo.setId(null);
            }            
        }
        return personInfo;
    }

    
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	/**
	 * @return the specialStatus
	 */
	public Integer getSpecialStatus() {
		return specialStatus;
	}

	/**
	 * @param specialStatus the specialStatus to set
	 */
	public void setSpecialStatus(Integer specialStatus) {
		this.specialStatus = specialStatus;
	}

	/**
	 * @return the idmId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the idmId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the idmId
	 */
	public String getIdmId() {
		return idmId;
	}

	/**
	 * @param idmId the idmId to set
	 */
	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}

	/**
	 * @return the clinicalManifestations
	 */
	public ClinicalManifestations getClinicalManifestations() {
		return clinicalManifestations;
	}

	/**
	 * @param clinicalManifestations the clinicalManifestations to set
	 */
	public void setClinicalManifestations(ClinicalManifestations clinicalManifestations) {
		this.clinicalManifestations = clinicalManifestations;
	}

	/**
	 * @return the epidemicFocusClose
	 */
	public EpidemicFocusClose getEpidemicFocusClose() {
		return epidemicFocusClose;
	}

	/**
	 * @param epidemicFocusClose the epidemicFocusClose to set
	 */
	public void setEpidemicFocusClose(EpidemicFocusClose epidemicFocusClose) {
		this.epidemicFocusClose = epidemicFocusClose;
	}

	/**
	 * @return the diagnosis
	 */
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the pastHistory
	 */
	public PastHistory getPastHistory() {
		return pastHistory;
	}

	/**
	 * @param pastHistory the pastHistory to set
	 */
	public void setPastHistory(PastHistory pastHistory) {
		this.pastHistory = pastHistory;
	}

	/**
	 * @return the listRr
	 */
	public ListRr getListRr() {
		return listRr;
	}

	/**
	 * @param listRr the listRr to set
	 */
	public void setListRr(ListRr listRr) {
		this.listRr = listRr;
	}

	/**
	 * @return the otherCondition
	 */
	public OtherCondition getOtherCondition() {
		return otherCondition;
	}

	/**
	 * @param otherCondition the otherCondition to set
	 */
	public void setOtherCondition(OtherCondition otherCondition) {
		this.otherCondition = otherCondition;
	}

	/**
	 * @return the listRrs
	 */
	public List<ListRr> getListRrs() {
		return listRrs;
	}

	/**
	 * @param listRrs the listRrs to set
	 */
	public void setListRrs(List<ListRr> listRrs) {
		this.listRrs = listRrs;
	}

	/**
	 * @return the listRrJson
	 */
	public String getListRrJson() {
		return listRrJson;
	}

	/**
	 * @param listRrJson the listRrJson to set
	 */
	public void setListRrJson(String listRrJson) {
		this.listRrJson = listRrJson;
	}

	/**
	 * @return the listCrs
	 */
	public List<ListCr> getListCrs() {
		return listCrs;
	}

	/**
	 * @param listCrs the listCrs to set
	 */
	public void setListCrs(List<ListCr> listCrs) {
		this.listCrs = listCrs;
	}

	/**
	 * @return the listCrJson
	 */
	public String getListCrJson() {
		return listCrJson;
	}

	/**
	 * @param listCrJson the listCrJson to set
	 */
	public void setListCrJson(String listCrJson) {
		this.listCrJson = listCrJson;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Organization getCurrentOrg() {
		return currentOrg;
	}

	public void setCurrentOrg(Organization currentOrg) {
		this.currentOrg = currentOrg;
	}

	public String[] getPersonInfoParam() {
		return personInfoParam;
	}

	public void setPersonInfoParam(String[] personInfoParam) {
		this.personInfoParam = personInfoParam;
	}

	public Integer getLogoff() {
		return logoff;
	}

	public void setLogoff(Integer logoff) {
		this.logoff = logoff;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}