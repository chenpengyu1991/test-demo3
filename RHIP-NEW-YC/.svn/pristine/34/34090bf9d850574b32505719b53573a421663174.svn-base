package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_REPORT_DESCRIPTION")
public class IdmReportDesc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|本表唯一编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编号|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "CONTACT_HISTORY", columnDefinition = "VARCHAR2|接触史|100|", length = 100, nullable = true)
	private String contactHistory;

	@Column(name = "VD_HISTORY", columnDefinition = "VARCHAR2|性病史|20|", length = 20, nullable = true)
	private String vdHistory;

	@Column(name = "INFECTION_WAY", columnDefinition = "VARCHAR2|感染途径|20|", length = 20, nullable = true)
	private String infectionWay;

	@Column(name = "SAMPLE_SOURCE", columnDefinition = "VARCHAR2|样本来源|20|", length = 20, nullable = true)
	private String sampleSource;

	@Column(name = "CHECK_CONCLUSION", columnDefinition = "VARCHAR2|实验室监测结论|20|", length = 20, nullable = true)
	private String checkConclusion;

	@Column(name = "CHECK_POSITIVE_DT", columnDefinition = "DATE|监测阳性日期||", nullable = true)
	private Date checkPositiveDt;

	@Column(name = "CHECK_POSITIVE_UNIT", columnDefinition = "VARCHAR2|监测阳性单位|100|", length = 100, nullable = true)
	private String checkPositiveUnit;

	@Column(name = "HIV_DIAGNOSE_DT", columnDefinition = "DATE|艾滋病确诊日期||", nullable = true)
	private Date hivDiagnoseDt;

	@Column(name = "CONDITION_WAY", columnDefinition = "VARCHAR2|病情轻重|20|", length = 20, nullable = true)
	private String conditionWay;

	@Column(name = "IN_HOSPITAL", columnDefinition = "VARCHAR2|是否住院|20|", length = 20, nullable = true)
	private String inHospital;

	@Column(name = "IN_HOSPITAL_DT", columnDefinition = "DATE|住院日期||", nullable = true)
	private Date inHospitalDt;

	@Column(name = "OUT_HOSPITAL_DT", columnDefinition = "DATE|出院日期||", nullable = true)
	private Date outHospitalDt;

	@Column(name = "CURE", columnDefinition = "VARCHAR2|是否治愈|20|", length = 20, nullable = true)
	private String cure;

	@Column(name = "OVERSEAS", columnDefinition = "VARCHAR2|是否境外输入|20|", length = 20, nullable = true)
	private String overseas;

	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|实验室检测结果|20|", length = 20, nullable = true)
	private String checkResult;

	@Column(name = "SEVERE_CASE", columnDefinition = "VARCHAR2|重症患者|20|", length = 20, nullable = true)
	private String severeCase;

	@Column(name = "HBSAG_POSITIVE_DT", columnDefinition = "VARCHAR2|HBsAg阳性时间|20|", length = 20, nullable = true)
	private String hbsagPositiveDt;

	@Column(name = "HBV_SIGN", columnDefinition = "VARCHAR2|乙肝体征是否|20|", length = 20, nullable = true)
	private String hbvSign;

	@Column(name = "HBV_SIGN_DT", columnDefinition = "DATE|乙肝体征时间||", nullable = true)
	private Date hbvSignDt;

	@Column(name = "ALT", columnDefinition = "VARCHAR2|本次ALT|20|", length = 20, nullable = true)
	private String alt;

	@Column(name = "HBC_CHECK_RESULT", columnDefinition = "VARCHAR2|抗HBc检测结果|20|", length = 20, nullable = true)
	private String hbcCheckResult;

	@Column(name = "PUNCTURE_CHECK_RESULT", columnDefinition = "VARCHAR2|肝穿检测结果|20|", length = 20, nullable = true)
	private String punctureCheckResult;

    @Column(name = "HBS_TO_POSITIVE", columnDefinition = "VARCHAR2|抗HBs转阳|20|", length = 20, nullable = true)
    private String hbsToPositive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdmId() {
        return idmId;
    }

    public void setIdmId(Long idmId) {
        this.idmId = idmId;
    }

    public String getContactHistory() {
        return contactHistory;
    }

    public void setContactHistory(String contactHistory) {
        this.contactHistory = contactHistory;
    }

    public String getVdHistory() {
        return vdHistory;
    }

    public void setVdHistory(String vdHistory) {
        this.vdHistory = vdHistory;
    }

    public String getInfectionWay() {
        return infectionWay;
    }

    public void setInfectionWay(String infectionWay) {
        this.infectionWay = infectionWay;
    }

    public String getSampleSource() {
        return sampleSource;
    }

    public void setSampleSource(String sampleSource) {
        this.sampleSource = sampleSource;
    }

    public String getCheckConclusion() {
        return checkConclusion;
    }

    public void setCheckConclusion(String checkConclusion) {
        this.checkConclusion = checkConclusion;
    }

    public Date getCheckPositiveDt() {
        return checkPositiveDt;
    }

    public void setCheckPositiveDt(Date checkPositiveDt) {
        this.checkPositiveDt = checkPositiveDt;
    }

    public String getCheckPositiveUnit() {
        return checkPositiveUnit;
    }

    public void setCheckPositiveUnit(String checkPositiveUnit) {
        this.checkPositiveUnit = checkPositiveUnit;
    }

    public Date getHivDiagnoseDt() {
        return hivDiagnoseDt;
    }

    public void setHivDiagnoseDt(Date hivDiagnoseDt) {
        this.hivDiagnoseDt = hivDiagnoseDt;
    }

    public String getConditionWay() {
        return conditionWay;
    }

    public void setConditionWay(String conditionWay) {
        this.conditionWay = conditionWay;
    }

    public String getInHospital() {
        return inHospital;
    }

    public void setInHospital(String inHospital) {
        this.inHospital = inHospital;
    }

    public Date getInHospitalDt() {
        return inHospitalDt;
    }

    public void setInHospitalDt(Date inHospitalDt) {
        this.inHospitalDt = inHospitalDt;
    }

    public Date getOutHospitalDt() {
        return outHospitalDt;
    }

    public void setOutHospitalDt(Date outHospitalDt) {
        this.outHospitalDt = outHospitalDt;
    }

    public String getCure() {
        return cure;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    public String getOverseas() {
        return overseas;
    }

    public void setOverseas(String overseas) {
        this.overseas = overseas;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getSevereCase() {
        return severeCase;
    }

    public void setSevereCase(String severeCase) {
        this.severeCase = severeCase;
    }

    public String getHbsagPositiveDt() {
        return hbsagPositiveDt;
    }

    public void setHbsagPositiveDt(String hbsagPositiveDt) {
        this.hbsagPositiveDt = hbsagPositiveDt;
    }

    public String getHbvSign() {
        return hbvSign;
    }

    public void setHbvSign(String hbvSign) {
        this.hbvSign = hbvSign;
    }

    public Date getHbvSignDt() {
        return hbvSignDt;
    }

    public void setHbvSignDt(Date hbvSignDt) {
        this.hbvSignDt = hbvSignDt;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getHbcCheckResult() {
        return hbcCheckResult;
    }

    public void setHbcCheckResult(String hbcCheckResult) {
        this.hbcCheckResult = hbcCheckResult;
    }

    public String getPunctureCheckResult() {
        return punctureCheckResult;
    }

    public void setPunctureCheckResult(String punctureCheckResult) {
        this.punctureCheckResult = punctureCheckResult;
    }

    public String getHbsToPositive() {
        return hbsToPositive;
    }

    public void setHbsToPositive(String hbsToPositive) {
        this.hbsToPositive = hbsToPositive;
    }
}