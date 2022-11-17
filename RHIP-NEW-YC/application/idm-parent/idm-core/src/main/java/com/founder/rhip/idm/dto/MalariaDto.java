package com.founder.rhip.idm.dto;


import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class MalariaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /*状态表id*/
    private String idmId;
    
    /*唯一事件id*/
    private String eventId;
    
    /*事件表id*/
    private String singleId;

    /*患者id*/
    private Long personId;
    
    /*注销状态*/
    private int logoff;

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

    //卫生条件
    private HygienicCondition hygienicCondition;

    //主要临床表现
    private ClinicalManifestations clinicalManifestations;

    //传染源、传播途径
    private InfectionSourceRoute infectionSourceRoute;

    //其他
    private OtherCondition otherCondition;

    //卡片信息
    private CaseInformation caseInformation;
    
    //诊断依据、诊断结果
    private Diagnosis diagnosis;

    //疫源地处理、密切接触者登记
    private EpidemicFocusClose epidemicFocusClose;

    //药物治疗表
    private DrugTherapy drugTherapy;

    //重点人群督导服药
    private ListFg listFg;
    
    /*督导服药记录表－列表*/
    private List<ListSd> listSds;
    
    /*督导服药记录表－JSON字符串*/
    private String listSdJson;

    /*疫点处理－列表JSON字符串*/
    private String listEddJson;

    /*疫点处理－列表*/
    private List<ListEdd> listEdd;

    /*访视记录－列表JSON字符串*/
    private String listFrJson;

    /*访视记录－列表*/
    private List<ListFr> listFr;

    /*主动侦查－列表JSON字符串*/
    private String listAiJson;

    /*主动侦查－列表*/
    private List<ListAi> listAi;

    /*患者信息*/
    @Transient
    private PersonInfo personInfo;
    /*更新平台患者信息时，需要更新的字段*/ 
    @Transient
    private String[] personInfoParam;    

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

    public HygienicCondition getHygienicCondition() {
        return hygienicCondition;
    }

    public void setHygienicCondition(HygienicCondition hygienicCondition) {
        this.hygienicCondition = hygienicCondition;
    }

    public ClinicalManifestations getClinicalManifestations() {
        return clinicalManifestations;
    }

    public void setClinicalManifestations(ClinicalManifestations clinicalManifestations) {
        this.clinicalManifestations = clinicalManifestations;
    }

    public InfectionSourceRoute getInfectionSourceRoute() {
        return infectionSourceRoute;
    }

    public void setInfectionSourceRoute(InfectionSourceRoute infectionSourceRoute) {
        this.infectionSourceRoute = infectionSourceRoute;
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
        if(ObjectUtil.isNullOrEmpty(this.personInfo) && ObjectUtil.isNotEmpty(this.generalCondition)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getGeneralCondition());
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

    public EpidemicFocusClose getEpidemicFocusClose() {
        return epidemicFocusClose;
    }

    public void setEpidemicFocusClose(EpidemicFocusClose epidemicFocusClose) {
        this.epidemicFocusClose = epidemicFocusClose;
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
	 * @return the listSd
	 */
	public List<ListSd> getListSds() {
		return listSds;
	}

	/**
	 * @param listSds the listSd to set
	 */
	public void setListSds(List<ListSd> listSds) {
		this.listSds = listSds;
	}

	/**
	 * @return the listSdJson
	 */
	public String getListSdJson() {
		return listSdJson;
	}

	/**
	 * @param listSdJson the listSdJson to set
	 */
	public void setListSdJson(String listSdJson) {
		this.listSdJson = listSdJson;
	}

    public String getListEddJson() {
        return listEddJson;
    }

    public void setListEddJson(String listEddJson) {
        this.listEddJson = listEddJson;
    }

    public List<ListEdd> getListEdd() {
        return listEdd;
    }

    public void setListEdd(List<ListEdd> listEdd) {
        this.listEdd = listEdd;
    }

    public String getListFrJson() {
        return listFrJson;
    }

    public void setListFrJson(String listFrJson) {
        this.listFrJson = listFrJson;
    }

    public List<ListFr> getListFr() {
        return listFr;
    }

    public void setListFr(List<ListFr> listFr) {
        this.listFr = listFr;
    }

    public DrugTherapy getDrugTherapy() {
        return drugTherapy;
    }

    public void setDrugTherapy(DrugTherapy drugTherapy) {
        this.drugTherapy = drugTherapy;
    }

    public String getListAiJson() {
        return listAiJson;
    }

    public void setListAiJson(String listAiJson) {
        this.listAiJson = listAiJson;
    }

    public List<ListAi> getListAi() {
        return listAi;
    }

    public void setListAi(List<ListAi> listAi) {
        this.listAi = listAi;
    }

	/**
	 * @return the listFg
	 */
	public ListFg getListFg() {
		return listFg;
	}

	/**
	 * @param listFg the listFg to set
	 */
	public void setListFg(ListFg listFg) {
		this.listFg = listFg;
	}

	public String[] getPersonInfoParam() {
		return personInfoParam;
	}

	public void setPersonInfoParam(String[] personInfoParam) {
		this.personInfoParam = personInfoParam;
	}

    public int getLogoff() {
        return logoff;
    }

    public void setLogoff(int logoff) {
        this.logoff = logoff;
    }

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}