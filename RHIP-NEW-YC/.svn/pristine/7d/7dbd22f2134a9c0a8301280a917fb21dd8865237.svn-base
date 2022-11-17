package com.founder.rhip.ehr.dto;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SR_Vaccination_Service")
@XmlRootElement
public class VaccinationServiceEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1398047229946590341L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String orgCode;
	
	@Column(name = "ORG_Name", columnDefinition = "VARCHAR2|填报单位名称||", length = 50, nullable = true)
    private String orgName;
	
	@Column(name = "YEAR", columnDefinition = "NUMBER|年||", length = 2, nullable = true)
    private Integer Year;
	
	@Column(name = "QUARTER", columnDefinition = "NUMBER|季度||", length = 1, nullable = true)
    private Integer Quarter;
	
	@Column(name = "REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date reportingTime;
	
	@Column(name = "CERTIFICATE_SHOULD_NUM", columnDefinition = "NUMBER|应建立预防接种证数(人)||", nullable = true)
    private Integer certificateShouldNum;
	
	@Column(name = "CERTIFICATE_HAS_NUM", columnDefinition = "NUMBER|已建立预防接种证数(人)||", nullable = true)
    private Integer certificateHasNum;
	
	@Column(name = "SUSPECTED_CERTIFICATE_NUM", columnDefinition = "NUMBER|处理疑似预防接种异常反应例数(例)||", nullable = true)
    private Integer suspectedCertificateNum;
	
	@Column(name = "HEPATITIS_SHOULD_NUM", columnDefinition = "NUMBER|乙肝疫苗应种剂次||", nullable = true)
    private Integer hepatitisShouldNum;
	
	@Column(name = "HEPATITIS_HAS_NUM", columnDefinition = "NUMBER|乙肝疫苗实种剂次||", nullable = true)
    private Integer hepatitisHasNum;
	
	@Column(name = "BCG_SHOULD_NUM", columnDefinition = "NUMBER|卡介苗应种人数||", nullable = true)
    private Integer bcgShouldNum;
	
	@Column(name = "BCG_HAS_NUM", columnDefinition = "NUMBER|卡介苗实种人数||", nullable = true)
    private Integer bcgHasNum;
	
	@Column(name = "POLIO_SHOULD_NUM", columnDefinition = "NUMBER|脊灰疫苗应种剂次||", nullable = true)
    private Integer polioShouldNum;
	
	@Column(name = "POLIO_HAS_NUM", columnDefinition = "NUMBER|脊灰疫苗实种剂次||", nullable = true)
    private Integer polioHasNum;
	
	@Column(name = "DPT_SHOULD_NUM", columnDefinition = "NUMBER|百白破疫苗应种剂次||", nullable = true)
    private Integer dptShouldNum;
	
	@Column(name = "DPT_HAS_NUM", columnDefinition = "NUMBER|百白破疫苗实种剂次||", nullable = true)
    private Integer dptHasNum;
	
	@Column(name = "WHITE_VACCINE_SHOULD_NUM", columnDefinition = "NUMBER|白破疫苗应种人数||", nullable = true)
    private Integer whitVaccineShouldNum;
	
	@Column(name = "WHITE_VACCINE_HAS_NUM", columnDefinition = "NUMBER|白破疫苗实种人数||", nullable = true)
    private Integer whitVaccineHasNum;
	
	@Column(name = "LEPROSY_SHOULD_NUM", columnDefinition = "NUMBER|麻风疫苗应种人数||", nullable = true)
    private Integer leprosyShouldNum;
	
	@Column(name = "LEPROSY_HAS_NUM", columnDefinition = "NUMBER|麻风疫苗实种人数||", nullable = true)
    private Integer leprosyHasNum;
	
	@Column(name = "MEASLES_SHOULD_NUM", columnDefinition = "NUMBER|麻腮风疫苗应种人数||", nullable = true)
    private Integer measlesShouldNum;
	
	@Column(name = "MEASLES_HAS_NUM", columnDefinition = "NUMBER|麻腮风疫苗实种人数||", nullable = true)
    private Integer measlesHasNum;

	@Column(name = "AMENINGOCOCCAL_SHOULD_NUM", columnDefinition = "NUMBER|A群流脑疫苗应种剂次||", nullable = true)
    private Integer ameningococcalShouldNum;
	
	@Column(name = "AMENINGOCOCCAL_HAS_NUM", columnDefinition = "NUMBER|A群流脑疫苗实种剂次||", nullable = true)
    private Integer ameningococcalHasNum;
	
	@Column(name = "ACMENINGOCOCCAL_SHOULD_NUM", columnDefinition = "NUMBER|A+C群流脑疫苗应种剂次||", nullable = true)
    private Integer acmeningococcalShouldNum;
	
	@Column(name = "ACMENINGOCOCCAL_HAS_NUM", columnDefinition = "NUMBER|A+C群流脑疫苗实种剂次||", nullable = true)
    private Integer acmeningococcalHasNum;
	
	@Column(name = "ENCEPHALITIS_SHOULD_NUM", columnDefinition = "NUMBER|乙脑疫苗应种剂次||", nullable = true)
    private Integer encephalitisShouldNum;
	
	@Column(name = "ENCEPHALITIS_HAS_NUM", columnDefinition = "NUMBER|乙脑疫苗实种剂次||", nullable = true)
    private Integer encephalitisHasNum;
	
	@Column(name = "HAV_SHOULD_NUM", columnDefinition = "NUMBER|甲肝疫苗应种剂次||", nullable = true)
    private Integer havShouldNum;
	
	@Column(name = "HAV_HAS_NUM", columnDefinition = "NUMBER|甲肝疫苗实种剂次||", nullable = true)
    private Integer havHasNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public Integer getQuarter() {
		return Quarter;
	}

	public void setQuarter(Integer quarter) {
		Quarter = quarter;
	}

	public Date getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}

	public Integer getCertificateShouldNum() {
		return certificateShouldNum;
	}

	public void setCertificateShouldNum(Integer certificateShouldNum) {
		this.certificateShouldNum = certificateShouldNum;
	}

	public Integer getCertificateHasNum() {
		return certificateHasNum;
	}

	public void setCertificateHasNum(Integer certificateHasNum) {
		this.certificateHasNum = certificateHasNum;
	}

	public Integer getSuspectedCertificateNum() {
		return suspectedCertificateNum;
	}

	public void setSuspectedCertificateNum(Integer suspectedCertificateNum) {
		this.suspectedCertificateNum = suspectedCertificateNum;
	}

	public Integer getHepatitisShouldNum() {
		return hepatitisShouldNum;
	}

	public void setHepatitisShouldNum(Integer hepatitisShouldNum) {
		this.hepatitisShouldNum = hepatitisShouldNum;
	}

	public Integer getHepatitisHasNum() {
		return hepatitisHasNum;
	}

	public void setHepatitisHasNum(Integer hepatitisHasNum) {
		this.hepatitisHasNum = hepatitisHasNum;
	}

	public Integer getBcgShouldNum() {
		return bcgShouldNum;
	}

	public void setBcgShouldNum(Integer bcgShouldNum) {
		this.bcgShouldNum = bcgShouldNum;
	}

	public Integer getBcgHasNum() {
		return bcgHasNum;
	}

	public void setBcgHasNum(Integer bcgHasNum) {
		this.bcgHasNum = bcgHasNum;
	}

	public Integer getPolioShouldNum() {
		return polioShouldNum;
	}

	public void setPolioShouldNum(Integer polioShouldNum) {
		this.polioShouldNum = polioShouldNum;
	}

	public Integer getPolioHasNum() {
		return polioHasNum;
	}

	public void setPolioHasNum(Integer polioHasNum) {
		this.polioHasNum = polioHasNum;
	}

	public Integer getDptShouldNum() {
		return dptShouldNum;
	}

	public void setDptShouldNum(Integer dptShouldNum) {
		this.dptShouldNum = dptShouldNum;
	}

	public Integer getDptHasNum() {
		return dptHasNum;
	}

	public void setDptHasNum(Integer dptHasNum) {
		this.dptHasNum = dptHasNum;
	}

	public Integer getWhitVaccineShouldNum() {
		return whitVaccineShouldNum;
	}

	public void setWhitVaccineShouldNum(Integer whitVaccineShouldNum) {
		this.whitVaccineShouldNum = whitVaccineShouldNum;
	}

	public Integer getWhitVaccineHasNum() {
		return whitVaccineHasNum;
	}

	public void setWhitVaccineHasNum(Integer whitVaccineHasNum) {
		this.whitVaccineHasNum = whitVaccineHasNum;
	}

	public Integer getLeprosyShouldNum() {
		return leprosyShouldNum;
	}

	public void setLeprosyShouldNum(Integer leprosyShouldNum) {
		this.leprosyShouldNum = leprosyShouldNum;
	}

	public Integer getLeprosyHasNum() {
		return leprosyHasNum;
	}

	public void setLeprosyHasNum(Integer leprosyHasNum) {
		this.leprosyHasNum = leprosyHasNum;
	}

	public Integer getMeaslesShouldNum() {
		return measlesShouldNum;
	}

	public void setMeaslesShouldNum(Integer measlesShouldNum) {
		this.measlesShouldNum = measlesShouldNum;
	}

	public Integer getMeaslesHasNum() {
		return measlesHasNum;
	}

	public void setMeaslesHasNum(Integer measlesHasNum) {
		this.measlesHasNum = measlesHasNum;
	}

	public Integer getAmeningococcalShouldNum() {
		return ameningococcalShouldNum;
	}

	public void setAmeningococcalShouldNum(Integer ameningococcalShouldNum) {
		this.ameningococcalShouldNum = ameningococcalShouldNum;
	}

	public Integer getAmeningococcalHasNum() {
		return ameningococcalHasNum;
	}

	public void setAmeningococcalHasNum(Integer ameningococcalHasNum) {
		this.ameningococcalHasNum = ameningococcalHasNum;
	}

	public Integer getAcmeningococcalShouldNum() {
		return acmeningococcalShouldNum;
	}

	public void setAcmeningococcalShouldNum(Integer acmeningococcalShouldNum) {
		this.acmeningococcalShouldNum = acmeningococcalShouldNum;
	}

	public Integer getAcmeningococcalHasNum() {
		return acmeningococcalHasNum;
	}

	public void setAcmeningococcalHasNum(Integer acmeningococcalHasNum) {
		this.acmeningococcalHasNum = acmeningococcalHasNum;
	}

	public Integer getEncephalitisShouldNum() {
		return encephalitisShouldNum;
	}

	public void setEncephalitisShouldNum(Integer encephalitisShouldNum) {
		this.encephalitisShouldNum = encephalitisShouldNum;
	}

	public Integer getEncephalitisHasNum() {
		return encephalitisHasNum;
	}

	public void setEncephalitisHasNum(Integer encephalitisHasNum) {
		this.encephalitisHasNum = encephalitisHasNum;
	}

	public Integer getHavShouldNum() {
		return havShouldNum;
	}

	public void setHavShouldNum(Integer havShouldNum) {
		this.havShouldNum = havShouldNum;
	}

	public Integer getHavHasNum() {
		return havHasNum;
	}

	public void setHavHasNum(Integer havHasNum) {
		this.havHasNum = havHasNum;
	}
	
	
}
