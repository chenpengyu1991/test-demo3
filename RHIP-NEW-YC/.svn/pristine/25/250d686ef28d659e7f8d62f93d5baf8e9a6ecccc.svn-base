package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.rhip.ehr.annotation.DisplayField;
import com.founder.rhip.ehr.common.IValidateDTO;
import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;


public class PersonalPhyExamDTO   implements IValidateDTO {

	private static final long serialVersionUID = 8255807308043267664L;

	//个人基本信息表事件
    private EHRHealthEvent ehrHeathEvent;

	//个人基本信息
	private PersonInfo personInfo;

	//体格检查记录
	private PhysiqueExamination physiqueExamination;

    //住院史标记
	@DisplayField(star = StarType.THREE)
    private String hospitalizedHistoryFlg="0";

	//住院史
	private List<HospitalizedHistory> hospitalizedHistoryList;

    //主要用药信息标记
	@DisplayField(star = StarType.THREE)
    private String drugHistoryFlag = "0";

	//主要用药信息
	private List<DrugHistory> drugHistoryList;

    //预防接种信息标记
	@DisplayField(star = StarType.THREE)
    private String vaccinationInfoFlg="0";

	//预防接种信息
	private List<VaccinationInfo> vaccinationInfoList;

    //家庭病床史标记
	@DisplayField(star = StarType.THREE)
    private String  familyBedHistoryFlg="0";

	//家庭病床史
	private List<FamilyBedHistory> familyBedHistoryList;

    //健康评价标记
	@DisplayField(star = StarType.THREE)
    private String healthEvaluateAnomalyFlg="0";

    //健康评价异常
    private List<HealthEvaluateAnomaly> healthEvaluateAnomalyList;
    
    //修改人与修改机构
	private String modifyInputerId;
	private String modifyInputName;
	private String modifyInputOrg;
	private String modifyInputOrganCode;
	private EchIdentification echIdentification;

	public EchIdentification getEchIdentification() {
		return echIdentification;
	}

	public void setEchIdentification(EchIdentification echIdentification) {
		this.echIdentification = echIdentification;
	}

	public PhysiqueExamination getPhysiqueExamination() {
		return physiqueExamination;
	}

	public void setPhysiqueExamination(PhysiqueExamination physiqueExamination) {
		this.physiqueExamination = physiqueExamination;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public List<HospitalizedHistory> getHospitalizedHistoryList() {
		return hospitalizedHistoryList;
	}

	public void setHospitalizedHistoryList(
			List<HospitalizedHistory> hospitalizedHistoryList) {
		this.hospitalizedHistoryList = hospitalizedHistoryList;
	}

	public List<DrugHistory> getDrugHistoryList() {
		return drugHistoryList;
	}

	public void setDrugHistoryList(List<DrugHistory> drugHistoryList) {
		this.drugHistoryList = drugHistoryList;
	}

	public List<VaccinationInfo> getVaccinationInfoList() {
		return vaccinationInfoList;
	}

	public void setVaccinationInfoList(List<VaccinationInfo> vaccinationInfoList) {
		this.vaccinationInfoList = vaccinationInfoList;
	}

	public EHRHealthEvent getEhrHeathEvent() {
		return ehrHeathEvent;
	}

	public void setEhrHeathEvent(EHRHealthEvent ehrHeathEvent) {
		this.ehrHeathEvent = ehrHeathEvent;
	}

	public List<FamilyBedHistory> getFamilyBedHistoryList() {
		return familyBedHistoryList;
	}

	public void setFamilyBedHistoryList(List<FamilyBedHistory> familyBedHistoryList) {
		this.familyBedHistoryList = familyBedHistoryList;
	}

    public List<HealthEvaluateAnomaly> getHealthEvaluateAnomalyList() {
        return healthEvaluateAnomalyList;
    }

    public void setHealthEvaluateAnomalyList(List<HealthEvaluateAnomaly> healthEvaluateAnomalyList) {
        this.healthEvaluateAnomalyList = healthEvaluateAnomalyList;
    }

    public String getHospitalizedHistoryFlg() {
        return hospitalizedHistoryFlg;
    }

    public void setHospitalizedHistoryFlg(String hospitalizedHistoryFlg) {
        this.hospitalizedHistoryFlg = hospitalizedHistoryFlg;
    }


    public String getDrugHistoryFlag() {
		return drugHistoryFlag;
	}

	public void setDrugHistoryFlag(String drugHistoryFlag) {
		this.drugHistoryFlag = drugHistoryFlag;
	}

		public String getVaccinationInfoFlg() {
        return vaccinationInfoFlg;
    }

    public void setVaccinationInfoFlg(String vaccinationInfoFlg) {
        this.vaccinationInfoFlg = vaccinationInfoFlg;
    }

    public String getFamilyBedHistoryFlg() {
        return familyBedHistoryFlg;
    }

    public void setFamilyBedHistoryFlg(String familyBedHistoryFlg) {
        this.familyBedHistoryFlg = familyBedHistoryFlg;
    }

    public String getHealthEvaluateAnomalyFlg() {
        return healthEvaluateAnomalyFlg;
    }

    public void setHealthEvaluateAnomalyFlg(String healthEvaluateAnomalyFlg) {
        this.healthEvaluateAnomalyFlg = healthEvaluateAnomalyFlg;
    }

	public String getModifyInputName() {
		return modifyInputName;
	}

	public void setModifyInputName(String modifyInputName) {
		this.modifyInputName = modifyInputName;
	}

	public String getModifyInputOrg() {
		return modifyInputOrg;
	}

	public void setModifyInputOrg(String modifyInputOrg) {
		this.modifyInputOrg = modifyInputOrg;
	}

	public String getModifyInputerId() {
		return modifyInputerId;
	}

	public void setModifyInputerId(String modifyInputerId) {
		this.modifyInputerId = modifyInputerId;
	}

	public String getModifyInputOrganCode() {
		return modifyInputOrganCode;
	}

	public void setModifyInputOrganCode(String modifyInputOrganCode) {
		this.modifyInputOrganCode = modifyInputOrganCode;
	}

}