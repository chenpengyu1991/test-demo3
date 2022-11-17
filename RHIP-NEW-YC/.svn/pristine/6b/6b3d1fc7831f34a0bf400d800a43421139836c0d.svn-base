package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by f on 2016/11/9.
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class OutpatientInfoReponse {

    @XmlElement(name = "ehrId")
    private String EHR_ID;
    @XmlElement(name = "clinicOrganName")
    private String CLINIC_ORGAN_NAME;
    @XmlElement(name = "medicalRoomName")
    private String MEDICAL_ROOM_NAME;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(name = "clinicDate")
    private Date CLINIC_DATE;
    @XmlElement(name = "clinicPeopleName")
    private String CLINIC_PEOPLE_NAME ;
    @XmlElement(name = "gender")
    private String GENDER;
    @XmlElement(name = "age")
    private String AGE;
    @XmlElement(name = "chiefComplaint")
    private String CHIEF_COMPLAINT;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(name = "pathogenesisDate")
    private Date PATHOGENESIS_DATE;

    @XmlElement(name = "otherMedicalTreatment")
    private String OTHER_MEDICAL_TREATMENT ;
    @XmlElement(name = "outpatientCostSum")
    private BigDecimal OUTPATIENT_COST_SUM;
    @XmlElement(name = "personalExpenses")
    private BigDecimal PERSONAL_EXPENSES;
    @XmlElement(name = "medicalInsuranceCostSum")
    private BigDecimal MEDICAL_INSURANCE_COST_SUM;
    @XmlElement(name = "otherSubsidiesCostSum")
    private BigDecimal OTHER_SUBSIDIES_COST_SUM;
    @XmlElement(name = "manaDoctorName")
    private String MANA_DOCTOR_NAME;
    @XmlElement(name = "outpatientType")
    private Integer OUTPATIENT_TYPE;
    @XmlElement(name = "observedPatientFlag")
    private String OBSERVED_PATIENT_FLAG;
    @XmlElement(name = "visitStatus")
    private Integer VISIT_STATUS;
    @XmlElement(name = "PrescriptionTotalCost")
    private Integer PRESCRIPTION_TOTAL_COST;
    @XmlElement(name = "PrescriptionNote")
    private String PRESCRIPTION_NOTE;
    @XmlElement(name = "DiagnosisDesc")
    private String DIAGNOSIS_DESC;

    public Date getCLINIC_DATE() {
        return CLINIC_DATE;
    }

    public void setCLINIC_DATE(Date CLINIC_DATE) {
        this.CLINIC_DATE = CLINIC_DATE;
    }

    public Date getPATHOGENESIS_DATE() {
        return PATHOGENESIS_DATE;
    }

    public void setPATHOGENESIS_DATE(Date PATHOGENESIS_DATE) {
        this.PATHOGENESIS_DATE = PATHOGENESIS_DATE;
    }

    public String getAGE() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }


    public void setCLINIC_ORGAN_NAME(String CLINIC_ORGAN_NAME) {
        if(CLINIC_ORGAN_NAME==null){this.CLINIC_ORGAN_NAME = "";}
        else{this.CLINIC_ORGAN_NAME = CLINIC_ORGAN_NAME;}
    }

    public void setMEDICAL_ROOM_NAME(String MEDICAL_ROOM_NAME) {
        if(MEDICAL_ROOM_NAME==null){this.MEDICAL_ROOM_NAME = "";}
        else{this.MEDICAL_ROOM_NAME = MEDICAL_ROOM_NAME;}
    }



    public void setCLINIC_PEOPLE_NAME(String CLINIC_PEOPLE_NAME) {
        if(CLINIC_PEOPLE_NAME==null){this.CLINIC_PEOPLE_NAME = "";}
        else{this.CLINIC_PEOPLE_NAME = CLINIC_PEOPLE_NAME;}
    }

    public void setGENDER(String GENDER) {
        if(GENDER==null){this.GENDER = "";}
        else{this.GENDER = GENDER;}
    }

    public void setCHIEF_COMPLAINT(String CHIEF_COMPLAINT) {
        if(CHIEF_COMPLAINT==null){this.CHIEF_COMPLAINT = "";}
        else{this.CHIEF_COMPLAINT = CHIEF_COMPLAINT;}
    }



    public void setOTHER_MEDICAL_TREATMENT(String OTHER_MEDICAL_TREATMENT) {
        if(OTHER_MEDICAL_TREATMENT==null){this.OTHER_MEDICAL_TREATMENT = "";}
        else{this.OTHER_MEDICAL_TREATMENT = OTHER_MEDICAL_TREATMENT;}
    }

    public void setOUTPATIENT_COST_SUM(BigDecimal OUTPATIENT_COST_SUM) {
        this.OUTPATIENT_COST_SUM = OUTPATIENT_COST_SUM;
    }

    public void setPERSONAL_EXPENSES(BigDecimal PERSONAL_EXPENSES) {
        this.PERSONAL_EXPENSES = PERSONAL_EXPENSES;
    }

    public void setMEDICAL_INSURANCE_COST_SUM(BigDecimal MEDICAL_INSURANCE_COST_SUM) {
        this.MEDICAL_INSURANCE_COST_SUM = MEDICAL_INSURANCE_COST_SUM;
    }

    public void setOTHER_SUBSIDIES_COST_SUM(BigDecimal OTHER_SUBSIDIES_COST_SUM) {
        this.OTHER_SUBSIDIES_COST_SUM = OTHER_SUBSIDIES_COST_SUM;
    }

    public void setMANA_DOCTOR_NAME(String MANA_DOCTOR_NAME) {
        if(MANA_DOCTOR_NAME==null){this.MANA_DOCTOR_NAME = "";}
        else{this.MANA_DOCTOR_NAME = MANA_DOCTOR_NAME;}
    }

    public void setOUTPATIENT_TYPE(Integer OUTPATIENT_TYPE) {
        this.OUTPATIENT_TYPE = OUTPATIENT_TYPE;
    }

    public void setOBSERVED_PATIENT_FLAG(String OBSERVED_PATIENT_FLAG) {
        if(OBSERVED_PATIENT_FLAG==null){this.OBSERVED_PATIENT_FLAG = "";}
        else{this.OBSERVED_PATIENT_FLAG = OBSERVED_PATIENT_FLAG;}
    }

    public void setVISIT_STATUS(Integer VISIT_STATUS) {
        this.VISIT_STATUS = VISIT_STATUS;
    }

    public void setPRESCRIPTION_TOTAL_COST(Integer PRESCRIPTION_TOTAL_COST) {
        this.PRESCRIPTION_TOTAL_COST = PRESCRIPTION_TOTAL_COST;
    }

    public void setPRESCRIPTION_NOTE(String PRESCRIPTION_NOTE) {
        if(PRESCRIPTION_NOTE==null){this.PRESCRIPTION_NOTE = "";}
        else{this.PRESCRIPTION_NOTE = PRESCRIPTION_NOTE;}
    }

    public void setDIAGNOSIS_DESC(String DIAGNOSIS_DESC) {
        if(DIAGNOSIS_DESC==null){this.DIAGNOSIS_DESC = "";}
        else{this.DIAGNOSIS_DESC = DIAGNOSIS_DESC;}
    }

    public String getCLINIC_ORGAN_NAME() {
        return CLINIC_ORGAN_NAME;
    }

    public String getMEDICAL_ROOM_NAME() {
        return MEDICAL_ROOM_NAME;
    }



    public String getCLINIC_PEOPLE_NAME() {
        return CLINIC_PEOPLE_NAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public String getCHIEF_COMPLAINT() {
        return CHIEF_COMPLAINT;
    }



    public String getOTHER_MEDICAL_TREATMENT() {
        return OTHER_MEDICAL_TREATMENT;
    }

    public BigDecimal getOUTPATIENT_COST_SUM() {
        return OUTPATIENT_COST_SUM;
    }

    public BigDecimal getPERSONAL_EXPENSES() {
        return PERSONAL_EXPENSES;
    }

    public BigDecimal getMEDICAL_INSURANCE_COST_SUM() {
        return MEDICAL_INSURANCE_COST_SUM;
    }

    public BigDecimal getOTHER_SUBSIDIES_COST_SUM() {
        return OTHER_SUBSIDIES_COST_SUM;
    }

    public String getMANA_DOCTOR_NAME() {
        return MANA_DOCTOR_NAME;
    }

    public Integer getOUTPATIENT_TYPE() {
        return OUTPATIENT_TYPE;
    }

    public String getOBSERVED_PATIENT_FLAG() {
        return OBSERVED_PATIENT_FLAG;
    }

    public Integer getVISIT_STATUS() {
        return VISIT_STATUS;
    }

    public Integer getPRESCRIPTION_TOTAL_COST() {
        return PRESCRIPTION_TOTAL_COST;
    }

    public String getPRESCRIPTION_NOTE() {
        return PRESCRIPTION_NOTE;
    }

    public String getDIAGNOSIS_DESC() {
        return DIAGNOSIS_DESC;
    }

    public String getEHR_ID() {
        return EHR_ID;
    }
    public void setEHR_ID(String EHR_ID) {
        this.EHR_ID = EHR_ID;
    }
}
