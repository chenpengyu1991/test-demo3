package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by f on 2016/11/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class InpatientInfoResponse {

    private String ehrId;
    private String admissionNo;
    private String referralHospitalName;
    private String referralDeptName;
    private String inhosReason;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date inhosDate;
    private String name;
    private String gender;
    private String age;
    private String otherMedicalTreatment;
    private String sickroomNo;
    private String sickbedNo;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date pathogenesisDate;
    private String treatmentResultsCode;
    private String attendingPhysicianName;
    private BigDecimal personalExpenses;
    private BigDecimal medicalInsuranceCostSum;
    private BigDecimal otherSubsidiesCostSum;
    private BigDecimal inhosCostSum;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date outHospitalDate;


    public String getReferralHospitalName() {
        return referralHospitalName;
    }

    public void setReferralHospitalName(String referralHospitalName) {
        this.referralHospitalName = referralHospitalName;
    }

    public void setAdmissionNo(String admissionNo) {
        if(admissionNo == null){this.admissionNo = "";}
        else {this.admissionNo = admissionNo;}
    }

    public void setReferralDeptName(String referralDeptName) {
        if(referralDeptName == null){this.referralDeptName = "";}
        else {this.referralDeptName = referralDeptName;}
    }

    public void setInhosReason(String inhosReason) {
        if(inhosReason == null){this.inhosReason = "";}
        else {this.inhosReason = inhosReason;}
    }

    public void setInhosDate(Date inhosDate) {
        this.inhosDate = inhosDate;
    }

    public void setName(String name) {
        if(name == null){this.name = "";}
        else {this.name = name;}
    }

    public void setGender(String gender) {
        if(gender == null){this.gender = "";}
        else {this.gender = gender;}
    }

    public void setAge(String age) {
        if(age == null){this.age = "";}
        else {this.age = age;}
    }

    public void setOtherMedicalTreatment(String otherMedicalTreatment) {
        if(otherMedicalTreatment == null){this.otherMedicalTreatment = "";}
        else {this.otherMedicalTreatment = otherMedicalTreatment;}
    }

    public void setSickroomNo(String sickroomNo) {
        if(sickroomNo == null){this.sickroomNo = "";}
        else {this.sickroomNo = sickroomNo;}
    }

    public void setSickbedNo(String sickbedNo) {
        if(sickbedNo == null){this.sickbedNo = "";}
        else {this.sickbedNo = sickbedNo;}
    }

    public void setPathogenesisDate(Date pathogenesisDate) {
        this.pathogenesisDate = pathogenesisDate;
    }

    public void setTreatmentResultsCode(String treatmentResultsCode) {
        if(treatmentResultsCode == null){this.treatmentResultsCode = "";}
        else {this.treatmentResultsCode = treatmentResultsCode;}
    }

    public void setAttendingPhysicianName(String attendingPhysicianName) {
        if(attendingPhysicianName == null){this.attendingPhysicianName = "";}
        else {this.attendingPhysicianName = attendingPhysicianName;}
    }

    public void setPersonalExpenses(BigDecimal personalExpenses) {
        this.personalExpenses = personalExpenses;
    }

    public void setMedicalInsuranceCostSum(BigDecimal medicalInsuranceCostSum) {
        this.medicalInsuranceCostSum = medicalInsuranceCostSum;
    }

    public void setOtherSubsidiesCostSum(BigDecimal otherSubsidiesCostSum) {
        this.otherSubsidiesCostSum = otherSubsidiesCostSum;
    }

    public void setInhosCostSum(BigDecimal inhosCostSum) {
        this.inhosCostSum = inhosCostSum;
    }

    public void setOutHospitalDate(Date outHospitalDate) {
        this.outHospitalDate = outHospitalDate;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public String getReferralDeptName() {
        return referralDeptName;
    }

    public String getInhosReason() {
        return inhosReason;
    }

    public Date getInhosDate() {
        return inhosDate;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getOtherMedicalTreatment() {
        return otherMedicalTreatment;
    }

    public String getSickroomNo() {
        return sickroomNo;
    }

    public String getSickbedNo() {
        return sickbedNo;
    }

    public Date getPathogenesisDate() {
        return pathogenesisDate;
    }

    public String getTreatmentResultsCode() {
        return treatmentResultsCode;
    }

    public String getAttendingPhysicianName() {
        return attendingPhysicianName;
    }

    public BigDecimal getPersonalExpenses() {
        return personalExpenses;
    }

    public BigDecimal getMedicalInsuranceCostSum() {
        return medicalInsuranceCostSum;
    }

    public BigDecimal getOtherSubsidiesCostSum() {
        return otherSubsidiesCostSum;
    }

    public BigDecimal getInhosCostSum() {
        return inhosCostSum;
    }

    public Date getOutHospitalDate() {
        return outHospitalDate;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }
}
