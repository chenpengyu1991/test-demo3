package com.founder.rhip.idm.dto;


import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class CaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idmId;

    private String caseStatus;

    //专项状态
    private String specialStatus;
    
    //流行病学调查List
    private String esList;

    //密切接触者登记List
    private String efcList;
    
    //实验室检查List
    private String leList;
    
	/*消毒情况*/
    private String disinfectList;
    
    //密切接触者登记列表
    private String closeList;
    
    //食谱 
    private String bddList;

    //卫生条件
    private String hcList;
    
    /*发病情况*/
    private String acList;
 
    /*发病前两周内接触动物*/
    private String esAnimalList;

    /*发病前一周内逐日活动情况*/
    private String esActivityList;
    
    /*发病后至隔离治疗前逐日活动情况*/
    private String esLeaveList;

    /*家庭、亲友*/
    private String efcFamilyList;

    /*工作单位或主要活动场所联系人*/
    private String efcWorkOrgList;
    
    //暴露史
    private String ehList;
    
    /*发病前2周内是否接触过非典病人或/和疑似非典患者*/
    private String esContactList;
    
    //一般情况
    private GeneralCondition generalCondition;

    //发病情况
    private AttackCondition attackCondition;

    //主要临床表现
    private ClinicalManifestations clinicalManifestations;

    //实验室检查
    private LabExamine labExamine;

    //流行病学调查
    private EpidemiologicalSurvey epidemiologicalSurvey;

    //诊断依据、诊断结果
    private Diagnosis diagnosis;

    //既往史
    private PastHistory pastHistory;

    //传染源、传播途径
    private InfectionSourceRoute infectionSourceRoute;

    //暴露史
    private ExposureHistory exposureHistory;

    //其他
    private OtherCondition otherCondition;

    //病前饮食情况
    private BeforeDiseaseDiet beforeDiseaseDiet;

    //卡片信息
    private CaseInformation caseInformation;

    //卫生条件
    private HygienicCondition hygienicCondition;

    //疫源地处理、密切接触者登记
    private EpidemicFocusClose epidemicFocusClose;

    //流行病学调查-列表
    private List<ListEs> idmListEsList;

    //疫源地处理，密切接触者登记-列表
    private List<ListEfc> idmListEfcList;

    /*消毒情况*/
    private List<ListEfc> idmDisinfectList;
    
    //实验室检查列表
    private List<ListLe> idmListLeList;
    
    //食谱 列表
    private List<ListBdd> idmListBddList;
    
    /*发病情况列表*/
    private List<ListAc> idmListAcList;
    
    /*发病前两周内接触动物*/
    private List<ListEs> idmListEsAnimal;
 
    /*发病前一周内逐日活动情况*/
    private List<ListEs> idmListEsActivity;
    
    /*发病后至隔离治疗前逐日活动情况*/
    private List<ListEs> idmListEsLeave;
    
    /*家庭、亲友*/
    private List<ListEfc> idmListEfcFamily;

    /*工作单位或主要活动场所联系人*/
    private List<ListEfc> idmListEfcWorkOrg;

    //暴露史
    private List<ListEh> idmListEhList;

    //卫生条件
    private List<ListHc> idmListHcList;

    /*发病前2周内是否接触过非典病人或/和疑似非典患者*/
    private List<ListEs> idmListEsContact;
    
    /*患者信息*/
    @Transient
    private PersonInfo personInfo;

    public String getIdmId() {
        return idmId;
    }

    public void setIdmId(String idmId) {
        this.idmId = idmId;
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

    public ClinicalManifestations getClinicalManifestations() {
        return clinicalManifestations;
    }

    public void setClinicalManifestations(ClinicalManifestations clinicalManifestations) {
        this.clinicalManifestations = clinicalManifestations;
    }

    public LabExamine getLabExamine() {
        return labExamine;
    }

    public void setLabExamine(LabExamine labExamine) {
        this.labExamine = labExamine;
    }

    public EpidemiologicalSurvey getEpidemiologicalSurvey() {
        return epidemiologicalSurvey;
    }

    public void setEpidemiologicalSurvey(EpidemiologicalSurvey epidemiologicalSurvey) {
        this.epidemiologicalSurvey = epidemiologicalSurvey;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public PastHistory getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(PastHistory pastHistory) {
        this.pastHistory = pastHistory;
    }

    public InfectionSourceRoute getInfectionSourceRoute() {
        return infectionSourceRoute;
    }

    public void setInfectionSourceRoute(InfectionSourceRoute infectionSourceRoute) {
        this.infectionSourceRoute = infectionSourceRoute;
    }

    public ExposureHistory getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(ExposureHistory exposureHistory) {
        this.exposureHistory = exposureHistory;
    }

    public OtherCondition getOtherCondition() {
        return otherCondition;
    }

    public void setOtherCondition(OtherCondition otherCondition) {
        this.otherCondition = otherCondition;
    }

    public BeforeDiseaseDiet getBeforeDiseaseDiet() {
        return beforeDiseaseDiet;
    }

    public void setBeforeDiseaseDiet(BeforeDiseaseDiet beforeDiseaseDiet) {
        this.beforeDiseaseDiet = beforeDiseaseDiet;
    }

    public CaseInformation getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    public HygienicCondition getHygienicCondition() {
        return hygienicCondition;
    }

    public void setHygienicCondition(HygienicCondition hygienicCondition) {
        this.hygienicCondition = hygienicCondition;
    }

    public EpidemicFocusClose getEpidemicFocusClose() {
        return epidemicFocusClose;
    }

    public void setEpidemicFocusClose(EpidemicFocusClose epidemicFocusClose) {
        this.epidemicFocusClose = epidemicFocusClose;
    }

    public String getEsList() {
        return esList;
    }

    public void setEsList(String esList) {
        this.esList = esList;
    }

    public String getEfcList() {
        return efcList;
    }

    public void setEfcList(String efcList) {
        this.efcList = efcList;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public List<ListEfc> getIdmListEfcList() {
        return idmListEfcList;
    }

    public void setIdmListEfcList(List<ListEfc> idmListEfcList) {
        this.idmListEfcList = idmListEfcList;
    }

    public List<ListEs> getIdmListEsList() {
        return idmListEsList;
    }

    public void setIdmListEsList(List<ListEs> idmListEsList) {
        this.idmListEsList = idmListEsList;
    }

	/**
	 * @return the idmDisinfectList
	 */
	public List<ListEfc> getIdmDisinfectList() {
		return idmDisinfectList;
	}

	/**
	 * @param idmDisinfectList the idmDisinfectList to set
	 */
	public void setIdmDisinfectList(List<ListEfc> idmDisinfectList) {
		this.idmDisinfectList = idmDisinfectList;
	}

	/**
	 * @return the disinfectList
	 */
	public String getDisinfectList() {
		return disinfectList;
	}
	
	/**
	 * @param disinfectList the disinfectList to set
	 */
	public void setDisinfectList(String disinfectList) {
		this.disinfectList = disinfectList;
	}

	public String getLeList() {
		return leList;
	}

	public void setLeList(String leList) {
		this.leList = leList;
	}

	public String getCloseList() {
		return closeList;
	}

	public void setCloseList(String closeList) {
		this.closeList = closeList;
	}
	

	public List<ListLe> getIdmListLeList() {
		return idmListLeList;
	}

	public void setIdmListLeList(List<ListLe> idmListLeList) {
		this.idmListLeList = idmListLeList;
	}

	public List<ListBdd> getIdmListBddList() {
		return idmListBddList;
	}

	public void setIdmListBddList(List<ListBdd> idmListBddList) {
		this.idmListBddList = idmListBddList;
	}

	public String getBddList() {
		return bddList;
	}

	public void setBddList(String bddList) {
		this.bddList = bddList;
	}

	public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getGeneralCondition());
        }
        return personInfo;
    }

	/**
	 * @return the acList
	 */
	public String getAcList() {
		return acList;
	}

	/**
	 * @param acList the acList to set
	 */
	public void setAcList(String acList) {
		this.acList = acList;
	}

	/**
	 * @return the idmListAcList
	 */
	public List<ListAc> getIdmListAcList() {
		return idmListAcList;
	}

	/**
	 * @param idmListAcList the idmListAcList to set
	 */
	public void setIdmListAcList(List<ListAc> idmListAcList) {
		this.idmListAcList = idmListAcList;
	}

	/**
	 * @return the esAnimalList
	 */
	public String getEsAnimalList() {
		return esAnimalList;
	}

	/**
	 * @param esAnimalList the esAnimalList to set
	 */
	public void setEsAnimalList(String esAnimalList) {
		this.esAnimalList = esAnimalList;
	}

	/**
	 * @return the idmListEsAnimal
	 */
	public List<ListEs> getIdmListEsAnimal() {
		return idmListEsAnimal;
	}

	/**
	 * @param idmListEsAnimal the idmListEsAnimal to set
	 */
	public void setIdmListEsAnimal(List<ListEs> idmListEsAnimal) {
		this.idmListEsAnimal = idmListEsAnimal;
	}

	/**
	 * @return the esActivityList
	 */
	public String getEsActivityList() {
		return esActivityList;
	}

	/**
	 * @param esActivityList the esActivityList to set
	 */
	public void setEsActivityList(String esActivityList) {
		this.esActivityList = esActivityList;
	}

	/**
	 * @return the esLeaveList
	 */
	public String getEsLeaveList() {
		return esLeaveList;
	}

	/**
	 * @param esLeaveList the esLeaveList to set
	 */
	public void setEsLeaveList(String esLeaveList) {
		this.esLeaveList = esLeaveList;
	}

	/**
	 * @return the idmListEsActivity
	 */
	public List<ListEs> getIdmListEsActivity() {
		return idmListEsActivity;
	}

	/**
	 * @param idmListEsActivity the idmListEsActivity to set
	 */
	public void setIdmListEsActivity(List<ListEs> idmListEsActivity) {
		this.idmListEsActivity = idmListEsActivity;
	}

	/**
	 * @return the idmListEsLeave
	 */
	public List<ListEs> getIdmListEsLeave() {
		return idmListEsLeave;
	}

	/**
	 * @param idmListEsLeave the idmListEsLeave to set
	 */
	public void setIdmListEsLeave(List<ListEs> idmListEsLeave) {
		this.idmListEsLeave = idmListEsLeave;
	}

	/**
	 * @return the idmListEsContact
	 */
	public List<ListEs> getIdmListEsContact() {
		return idmListEsContact;
	}

	/**
	 * @param idmListEsContact the idmListEsContact to set
	 */
	public void setIdmListEsContact(List<ListEs> idmListEsContact) {
		this.idmListEsContact = idmListEsContact;
	}

	/**
	 * @return the esContactList
	 */
	public String getEsContactList() {
		return esContactList;
	}

	/**
	 * @param esContactList the esContactList to set
	 */
	public void setEsContactList(String esContactList) {
		this.esContactList = esContactList;
	}

    public String getEhList() {
        return ehList;
    }

    public void setEhList(String ehList) {
        this.ehList = ehList;
    }

    public List<ListEh> getIdmListEhList() {
        return idmListEhList;
    }

    public void setIdmListEhList(List<ListEh> idmListEhList) {
        this.idmListEhList = idmListEhList;
    }

	/**
	 * @return the idmListEfcFamily
	 */
	public List<ListEfc> getIdmListEfcFamily() {
		return idmListEfcFamily;
	}

	/**
	 * @param idmListEfcFamily the idmListEfcFamily to set
	 */
	public void setIdmListEfcFamily(List<ListEfc> idmListEfcFamily) {
		this.idmListEfcFamily = idmListEfcFamily;
	}

	/**
	 * @return the efcFamilyList
	 */
	public String getEfcFamilyList() {
		return efcFamilyList;
	}

	/**
	 * @param efcFamilyList the efcFamilyList to set
	 */
	public void setEfcFamilyList(String efcFamilyList) {
		this.efcFamilyList = efcFamilyList;
	}

	/**
	 * @return the idmListEfcWorkOrg
	 */
	public List<ListEfc> getIdmListEfcWorkOrg() {
		return idmListEfcWorkOrg;
	}

	/**
	 * @param idmListEfcWorkOrg the idmListEfcWorkOrg to set
	 */
	public void setIdmListEfcWorkOrg(List<ListEfc> idmListEfcWorkOrg) {
		this.idmListEfcWorkOrg = idmListEfcWorkOrg;
	}

	/**
	 * @return the efcWorkOrgList
	 */
	public String getEfcWorkOrgList() {
		return efcWorkOrgList;
	}

	/**
	 * @param efcWorkOrgList the efcWorkOrgList to set
	 */
	public void setEfcWorkOrgList(String efcWorkOrgList) {
		this.efcWorkOrgList = efcWorkOrgList;
	}

    public String getHcList() {
        return hcList;
    }

    public void setHcList(String hcList) {
        this.hcList = hcList;
    }

    public List<ListHc> getIdmListHcList() {
        return idmListHcList;
    }

    public void setIdmListHcList(List<ListHc> idmListHcList) {
        this.idmListHcList = idmListHcList;
    }

	public String getSpecialStatus() {
		return specialStatus;
	}

	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}
}