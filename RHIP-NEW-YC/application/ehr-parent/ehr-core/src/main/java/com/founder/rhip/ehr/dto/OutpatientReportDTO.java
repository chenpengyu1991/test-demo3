package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.ExpenseInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

public class OutpatientReportDTO {

    private DiseaseDiagnosisInfo diseaseDiagnosisInfo;

    private List<StudyEvent> studyEventList;

    private List<ExamineEvent> examineEventList;

    private List<DrugUsage> drugUsageList;

    private PersonInfo personInfo;

    private OutpatientInfo outpatientInfo;

    private ExpenseInfo expenseInfo;

    private String ehrId;

    private Long personId;

    private List<DrugUsageDTO> drugUsageDTOs;


    //总价
    private BigDecimal totalPrice;

    //开具处方医师姓名
    private String prescribeDoctorName;

    //就诊日期时间
    private Date clinicDate;

    //就诊机构名称
    private String clinicOrganName;

    //就诊卡类型/报卡类别代码
    private String reportCardTypeCode;

    //就诊科室名称
    private String medicalRoomName;

    //是否用药
    private boolean isDrug;

    //是否检验
    private boolean isExam;

    //是否检查
    private boolean isStydy;

    //门诊号
    private String outpatientNo;

    //处方号
    private String recordNumber;

    //就诊者姓名
    private String clinicPeopleName;

    //性别代码
    private String gender;

    //年龄
    private String age;


    //诊断名称
    private String diagnosisDesc;

    //现住址-省(自治区、直辖市)
    private String paprovince;

    //现住址-市(地区、州)
    private String pacity;

    //现住址-县(区)
    private String pacounty;

    //现住址-乡(镇、街道办事处)
    private String patownShip;

    //现住址-村(街、路、弄等)
    private String pastreet;

    //现住址-门牌号码
    private String pahouseNumber;

    /**
     * 将同一个处方号下的用药集中到一起
     */
    private List<Map<String, Object>> recordNumnerDrugs;

    public List<Map<String, Object>> getRecordNumnerDrugs() {
        return recordNumnerDrugs;
    }

    public void setRecordNumnerDrugs(List<Map<String, Object>> recordNumnerDrugs) {
        this.recordNumnerDrugs = recordNumnerDrugs;
    }

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc;
    }

    List<OutpatientInfo> outpatientInfoList;

    public Date getClinicDate() {
        return clinicDate;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public String getClinicOrganName() {
        return clinicOrganName;
    }

    public void setClinicOrganName(String clinicOrganName) {
        this.clinicOrganName = clinicOrganName;
    }

    public String getReportCardTypeCode() {
        return reportCardTypeCode;
    }

    public void setReportCardTypeCode(String reportCardTypeCode) {
        this.reportCardTypeCode = reportCardTypeCode;
    }

    public String getMedicalRoomName() {
        return medicalRoomName;
    }

    public void setMedicalRoomName(String medicalRoomName) {
        this.medicalRoomName = medicalRoomName;
    }

    public boolean isDrug() {
        return isDrug;
    }

    public void setDrug(boolean isDrug) {
        this.isDrug = isDrug;
    }

    public boolean isExam() {
        return isExam;
    }

    public void setExam(boolean isExam) {
        this.isExam = isExam;
    }

    public boolean isStydy() {
        return isStydy;
    }

    public void setStydy(boolean isStydy) {
        this.isStydy = isStydy;
    }

    public List<OutpatientInfo> getOutpatientInfoList() {
        return outpatientInfoList;
    }

    public void setOutpatientInfoList(List<OutpatientInfo> outpatientInfoList) {
        this.outpatientInfoList = outpatientInfoList;
    }

    public String getClinicPeopleName() {
        return clinicPeopleName;
    }

    public void setClinicPeopleName(String clinicPeopleName) {
        this.clinicPeopleName = clinicPeopleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
	public String getAge() {
		return age;
	}

	
	public void setAge(String age) {
		this.age = age;
	}

	public String getOutpatientNo() {
        return outpatientNo;
    }

    public void setOutpatientNo(String outpatientNo) {
        this.outpatientNo = outpatientNo;
    }

    public String getPaprovince() {
        return paprovince;
    }

    public void setPaprovince(String paprovince) {
        this.paprovince = paprovince;
    }

    public String getPacity() {
        return pacity;
    }

    public void setPacity(String pacity) {
        this.pacity = pacity;
    }

    public String getPacounty() {
        return pacounty;
    }

    public void setPacounty(String pacounty) {
        this.pacounty = pacounty;
    }

    public String getPatownShip() {
        return patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public String getPastreet() {
        return pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    public String getPahouseNumber() {
        return pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public DiseaseDiagnosisInfo getDiseaseDiagnosisInfo() {
        return diseaseDiagnosisInfo;
    }

    public void setDiseaseDiagnosisInfo(DiseaseDiagnosisInfo diseaseDiagnosisInfo) {
        this.diseaseDiagnosisInfo = diseaseDiagnosisInfo;
    }

    public List<StudyEvent> getStudyEventList() {
        return studyEventList;
    }

    public void setStudyEventList(List<StudyEvent> studyEventList) {
        this.studyEventList = studyEventList;
    }

    public List<ExamineEvent> getExamineEventList() {
        return examineEventList;
    }

    public void setExamineEventList(List<ExamineEvent> examineEventList) {
        this.examineEventList = examineEventList;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public OutpatientInfo getOutpatientInfo() {
        return outpatientInfo;
    }

    public void setOutpatientInfo(OutpatientInfo outpatientInfo) {
        this.outpatientInfo = outpatientInfo;
    }


    public List<DrugUsage> getDrugUsageList() {
        return drugUsageList;
    }

    public void setDrugUsageList(List<DrugUsage> drugUsageList) {
        this.drugUsageList = drugUsageList;
    }

    public ExpenseInfo getExpenseInfo() {
        return expenseInfo;
    }

    public void setExpenseInfo(ExpenseInfo expenseInfo) {
        this.expenseInfo = expenseInfo;
    }

    public String getPrescribeDoctorName() {
        return prescribeDoctorName;
    }

    public void setPrescribeDoctorName(String prescribeDoctorName) {
        this.prescribeDoctorName = prescribeDoctorName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List<DrugUsageDTO> getDrugUsageDTOs() {
        return drugUsageDTOs;
    }

    public void setDrugUsageDTOs(List<DrugUsageDTO> drugUsageDTOs) {
        this.drugUsageDTOs = drugUsageDTOs;
    }

}
