package com.founder.rhip.idm.dto;


import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.LaborCapacity;
import com.founder.rhip.ehr.entity.control.idm.special.ListCm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/*肺结核*/
public class LeprosySaveDto implements Serializable {

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
    
    //诊断依据、诊断结果
    private Diagnosis diagnosis;
    
    //疫源地处理、密切接触者登记
    private EpidemicFocusClose epidemicFocusClose;
    
    //劳动力
    private LaborCapacity laborCapacity;
    
    /*患者信息*/
    @Transient
    private PersonInfo personInfo;

    /*临床表现-列表 */
    List<ListCm> listCms;
    
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

	public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getGeneralCondition());
            //患者ID add by yjf 2014/01/07
            if(ObjectUtil.isNotEmpty(this.personId)){
            	personInfo.setId(this.personId);
            }else{
            	personInfo.setId(null);
            }
        }
        return personInfo;
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

	public EpidemicFocusClose getEpidemicFocusClose() {
		return epidemicFocusClose;
	}

	public void setEpidemicFocusClose(EpidemicFocusClose epidemicFocusClose) {
		this.epidemicFocusClose = epidemicFocusClose;
	}

	public LaborCapacity getLaborCapacity() {
		return laborCapacity;
	}

	public void setLaborCapacity(LaborCapacity laborCapacity) {
		this.laborCapacity = laborCapacity;
	}

	public List<ListCm> getListCms() {
		return listCms;
	}

	public void setListCms(List<ListCm> listCms) {
		this.listCms = listCms;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}