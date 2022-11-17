package com.founder.rhip.idm.dto;


import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.ListDd;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListSd;
import com.founder.rhip.ehr.entity.control.idm.special.ListSr;
import com.founder.rhip.idm.common.SpecialEvents;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/*肺结核*/
public class TbSaveDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /*状态表id*/
    private Long idmId;
    
    /*唯一事件id*/
    private Long eventId;
    
    /*事件表id*/
    private Long singleId;
    
    /*患者id*/
    private Long personId;
    
    /*专项状态*/
    private Integer specialStatus;

    //一般情况
    private GeneralCondition generalCondition;

    //发病情况
    private AttackCondition attackCondition;

    //实验室检查
    private LabExamine labExamine;

    //既往史
    private PastHistory pastHistory;

    //主要临床表现
    private ClinicalManifestations clinicalManifestations;

    //其他
    private OtherCondition otherCondition;

    //卡片信息
    private CaseInformation caseInformation;

    /*初步诊断*/
    private String tentativeDiagnosis;
    private String other;

    //诊断依据、诊断结果
    private Diagnosis diagnosis;
    
    //暴露史
    private ExposureHistory exposureHistory;
    
    //督导服药
    private List<ListSd> listSd;
    
    //用药延迟
    private List<ListDd> listDd;

    //访视记录
    private List<ListFr> listFr;

    //服务记录
    private List<ListSr> listSr;

    private String listSdJson;
    
    private String listDdJson;
    
    private String listFrJson;
    
    /*注销标志(0正常，1注销)*/
    private Integer logoff = 0;
    
    /*患者信息*/
    @Transient
    private PersonInfo personInfo;
    /*更新平台患者信息时，需要更新的字段*/ 
    @Transient
    private String[] personInfoParam;

    public List<ListSr> getListSr() {
        return listSr;
    }

    public void setListSr(List<ListSr> listSr) {
        this.listSr = listSr;
    }

    public Long getSingleId() {
        return singleId;
    }

    public void setSingleId(Long singleId) {
        this.singleId = singleId;
    }

    public GeneralCondition getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(GeneralCondition generalCondition) {
        this.generalCondition = generalCondition;
    }

    public AttackCondition getAttackCondition() {
        return attackCondition;
    }

    public void setAttackCondition(AttackCondition attackCondition) {
        this.attackCondition = attackCondition;
    }

    public LabExamine getLabExamine() {
        return labExamine;
    }

    public void setLabExamine(LabExamine labExamine) {
        this.labExamine = labExamine;
    }

    public PastHistory getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(PastHistory pastHistory) {
        this.pastHistory = pastHistory;
    }

    public ClinicalManifestations getClinicalManifestations() {
        return clinicalManifestations;
    }

    public void setClinicalManifestations(ClinicalManifestations clinicalManifestations) {
        this.clinicalManifestations = clinicalManifestations;
    }

    public OtherCondition getOtherCondition() {
        return otherCondition;
    }

    public void setOtherCondition(OtherCondition otherCondition) {
        this.otherCondition = otherCondition;
    }

    public CaseInformation getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    public ExposureHistory getExposureHistory() {
		return exposureHistory;
	}

	public void setExposureHistory(ExposureHistory exposureHistory) {
		this.exposureHistory = exposureHistory;
	}

	public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getGeneralCondition());
            personInfo.setOtherNationDesc(this.getGeneralCondition().getNationOther());
            if(NumberUtil.convert(SpecialEvents.T_TREATMENT.getValue(), Long.class).equals(this.eventId)){
    			personInfo.setIdcard(null);
    		}            
            personInfo.setHouseholdType(this.getGeneralCondition().getFloatPopulation());
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
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param idmId the idmId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the idmId
	 */
	public Long getIdmId() {
		return idmId;
	}

	/**
	 * @param idmId the idmId to set
	 */
	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public List<ListSd> getListSd() {
		return listSd;
	}

	public void setListSd(List<ListSd> listSd) {
		this.listSd = listSd;
	}

	public List<ListDd> getListDd() {
		return listDd;
	}

	public void setListDd(List<ListDd> listDd) {
		this.listDd = listDd;
	}

	public List<ListFr> getListFr() {
		return listFr;
	}

	public void setListFr(List<ListFr> listFr) {
		this.listFr = listFr;
	}

	public String getListSdJson() {
		return listSdJson;
	}

	public void setListSdJson(String listSdJson) {
		this.listSdJson = listSdJson;
	}

	public String getListDdJson() {
		return listDdJson;
	}

	public void setListDdJson(String listDdJson) {
		this.listDdJson = listDdJson;
	}

	public String getListFrJson() {
		return listFrJson;
	}

	public void setListFrJson(String listFrJson) {
		this.listFrJson = listFrJson;
	}

    public String getTentativeDiagnosis() {
        return tentativeDiagnosis;
    }

    public void setTentativeDiagnosis(String tentativeDiagnosis) {
        this.tentativeDiagnosis = tentativeDiagnosis;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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