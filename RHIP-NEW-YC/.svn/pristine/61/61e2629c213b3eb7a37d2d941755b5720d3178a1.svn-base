package com.founder.rhip.mhm.dto;


import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ManagementDto implements Serializable {

    
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	private static final long serialVersionUID = 1L;

    /*状态表ID*/
    private Long statusId;
    /*事件表类型*/
    private Integer eventType;    
    /*事件表ID*/
    private Long eventId;
    /*当前操作者*/
    private User currentUser;
    /*当前操作机构*/
    private Organization currentOrg;
    /*患者PIXID*/
    private String pixId;
    
    /*患者PERSON_ID*/
    private Long personId;    

    private int logoff;
    
    /*基本信息*/
    private MhmBasicsInfo mhmBasicsInfo;
    /*诊断治疗表*/
    private MhmDiagnosis mhmDiagnosis;
    /*其他表*/
    private MhmOtherInfo mhmOtherInfo;       
    /*既往史*/
    private MhmPathHistory mhmPathHistory;    
    /*住院*/
    private MhmInhospital mhmInhospital;
    /*用药*/
    private MhmDrugRecord mhmDrugRecord;
    /*随访表*/
    private MhmFollowup mhmFollowup;    
    /*个案计划*/
    private MhmCase mhmCase; 
    /*个案计划明细*/
    private MhmCaseDetail mhmCaseDetail; 
    /*评估表*/
    private MhmAssess mhmAssess; 
    /*应急处置*/
    private MhmEmergency mhmEmergency; 
    /*体征表*/
    private MhmSign mhmSign;
    /*健康体检*/
    private MhmPhysicalExamination mhmPhysicalExamination;
	PageList<MhmFollowup> followupPageList;//随访列表

    @Transient
    private PersonInfo personInfo;

    @Transient
    /* 住院用药*/
    private String inMedication;

    private List<MhmDrugRecord> inMedicationRecords;

    @Transient
    /* 下一步治疗用药*/
    private String nextMedication;

    private List<MhmDrugRecord> nextMedicationRecords;

	@Transient
	private Map<String, String> fileMap;

	@Transient
	private Map<String, String> fileNameMap;

    @Transient
    /* 随访用药*/
    private String followupMedication;

    private List<MhmDrugRecord> followupMedicationRecords;
    
	public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            if(ObjectUtil.isNotEmpty(this.getMhmFollowup())){
            	BeanUtils.copyProperties(this.personInfo,this.getMhmFollowup());
            }else{
				if(null != this.getMhmBasicsInfo()) {
					BeanUtils.copyProperties(this.personInfo, this.getMhmBasicsInfo());
					personInfo.setHouseholdType(this.getMhmBasicsInfo().getFloatPopulation());
				}
            }
            
        }
        return personInfo;
    }

	public Map<String, String> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<String, String> fileMap) {
		this.fileMap = fileMap;
	}

	public Map<String, String> getFileNameMap() {
		return fileNameMap;
	}

	public void setFileNameMap(Map<String, String> fileNameMap) {
		this.fileNameMap = fileNameMap;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	
	public MhmBasicsInfo getMhmBasicsInfo() {
		return mhmBasicsInfo;
	}

	
	public void setMhmBasicsInfo(MhmBasicsInfo mhmBasicsInfo) {
		this.mhmBasicsInfo = mhmBasicsInfo;
	}


	public MhmDiagnosis getMhmDiagnosis() {
		return mhmDiagnosis;
	}

	
	public void setMhmDiagnosis(MhmDiagnosis mhmDiagnosis) {
		this.mhmDiagnosis = mhmDiagnosis;
	}

	
	public MhmOtherInfo getMhmOtherInfo() {
		return mhmOtherInfo;
	}

	
	public void setMhmOtherInfo(MhmOtherInfo mhmOtherInfo) {
		this.mhmOtherInfo = mhmOtherInfo;
	}

	
	public MhmPathHistory getMhmPathHistory() {
		return mhmPathHistory;
	}

	
	public void setMhmPathHistory(MhmPathHistory mhmPathHistory) {
		this.mhmPathHistory = mhmPathHistory;
	}

	
	public MhmInhospital getMhmInhospital() {
		return mhmInhospital;
	}

	
	public void setMhmInhospital(MhmInhospital mhmInhospital) {
		this.mhmInhospital = mhmInhospital;
	}

	
	public MhmDrugRecord getMhmDrugRecord() {
		return mhmDrugRecord;
	}

	
	public void setMhmDrugRecord(MhmDrugRecord mhmDrugRecord) {
		this.mhmDrugRecord = mhmDrugRecord;
	}

	
	public MhmFollowup getMhmFollowup() {
		return mhmFollowup;
	}

	
	public void setMhmFollowup(MhmFollowup mhmFollowup) {
		this.mhmFollowup = mhmFollowup;
	}

	
	public MhmCase getMhmCase() {
		return mhmCase;
	}

	
	public void setMhmCase(MhmCase mhmCase) {
		this.mhmCase = mhmCase;
	}

	
	public MhmCaseDetail getMhmCaseDetail() {
		return mhmCaseDetail;
	}

	
	public void setMhmCaseDetail(MhmCaseDetail mhmCaseDetail) {
		this.mhmCaseDetail = mhmCaseDetail;
	}

	
	public MhmAssess getMhmAssess() {
		return mhmAssess;
	}

	
	public void setMhmAssess(MhmAssess mhmAssess) {
		this.mhmAssess = mhmAssess;
	}

	
	public MhmEmergency getMhmEmergency() {
		return mhmEmergency;
	}

	
	public void setMhmEmergency(MhmEmergency mhmEmergency) {
		this.mhmEmergency = mhmEmergency;
	}

	public String getPixId() {
		return pixId;
	}

	public void setPixId(String pixId) {
		this.pixId = pixId;
	}
    
	
	public PageList<MhmFollowup> getFollowupPageList() {
		return followupPageList;
	}

	
	public void setFollowupPageList(PageList<MhmFollowup> followupPageList) {
		this.followupPageList = followupPageList;
	}

    public String getInMedication() {
        return inMedication;
    }

    public void setInMedication(String inMedication) {
        this.inMedication = inMedication;
    }

    public List<MhmDrugRecord> getInMedicationRecords() {
        return inMedicationRecords;
    }

    public void setInMedicationRecords(List<MhmDrugRecord> inMedicationRecords) {
        this.inMedicationRecords = inMedicationRecords;
    }

    public String getNextMedication() {
        return nextMedication;
    }

    public void setNextMedication(String nextMedication) {
        this.nextMedication = nextMedication;
    }

    public List<MhmDrugRecord> getNextMedicationRecords() {
        return nextMedicationRecords;
    }

    public void setNextMedicationRecords(List<MhmDrugRecord> nextMedicationRecords) {
        this.nextMedicationRecords = nextMedicationRecords;
    }

	public Organization getCurrentOrg() {
		return currentOrg;
	}

	public void setCurrentOrg(Organization currentOrg) {
		this.currentOrg = currentOrg;
	}

	public String getFollowupMedication() {
		return followupMedication;
	}

	public void setFollowupMedication(String followupMedication) {
		this.followupMedication = followupMedication;
	}

	public List<MhmDrugRecord> getFollowupMedicationRecords() {
		return followupMedicationRecords;
	}

	public void setFollowupMedicationRecords(List<MhmDrugRecord> followupMedicationRecords) {
		this.followupMedicationRecords = followupMedicationRecords;
	}

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public MhmSign getMhmSign() {
		return mhmSign;
	}

	public void setMhmSign(MhmSign mhmSign) {
		this.mhmSign = mhmSign;
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

    public MhmPhysicalExamination getMhmPhysicalExamination() {
        return mhmPhysicalExamination;
    }

    public void setMhmPhysicalExamination(MhmPhysicalExamination mhmPhysicalExamination) {
        this.mhmPhysicalExamination = mhmPhysicalExamination;
    }
}