package com.founder.rhip.ehr.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SR_VACCINATION_SERVICE")
@XmlRootElement
public class VaccinationService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1398047229946590341L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String orgCode;
	
	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 50, nullable = true)
    private String orgName;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|中心名称||", length = 50, nullable = true)
	private String centerOrgCode;		

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|区名称||", length = 50, nullable = true)
	private String gbCode;	
	
	@Column(name = "YEAR", columnDefinition = "NUMBER|年||", length = 2, nullable = true)
    private Integer year;
	
	@Column(name = "MONTH", columnDefinition = "NUMBER|月||", length = 2, nullable = true)
    private Integer month;
	
	@Column(name = "REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date reportingTime;
	
	@Column(name = "CERTIFICATE_SHOULD_NUM", columnDefinition = "NUMBER|应建立预防接种证数(人)||", nullable = true)
    private Integer certificateShouldNum=0;
	
	@Column(name = "CERTIFICATE_HAS_NUM", columnDefinition = "NUMBER|已建立预防接种证数(人)||", nullable = true)
    private Integer certificateHasNum=0;
	
	@Column(name = "SUSPECTED_CERTIFICATE_NUM", columnDefinition = "NUMBER|处理疑似预防接种异常反应例数(例)||", nullable = true)
    private Integer suspectedCertificateNum=0;
	
	@Column(name = "HEPATITIS_SHOULD_NUM", columnDefinition = "NUMBER|乙肝疫苗应种剂次||", nullable = true)
    private Integer hepatitisShouldNum=0;
	
	@Column(name = "HEPATITIS_HAS_NUM", columnDefinition = "NUMBER|乙肝疫苗实种剂次||", nullable = true)
    private Integer hepatitisHasNum=0;
	
	@Column(name = "BCG_SHOULD_NUM", columnDefinition = "NUMBER|卡介苗应种人数||", nullable = true)
    private Integer bcgShouldNum=0;
	
	@Column(name = "BCG_HAS_NUM", columnDefinition = "NUMBER|卡介苗实种人数||", nullable = true)
    private Integer bcgHasNum=0;
	
	@Column(name = "POLIO_SHOULD_NUM", columnDefinition = "NUMBER|脊灰疫苗应种剂次||", nullable = true)
    private Integer polioShouldNum=0;
	
	@Column(name = "POLIO_HAS_NUM", columnDefinition = "NUMBER|脊灰疫苗实种剂次||", nullable = true)
    private Integer polioHasNum=0;
	
	@Column(name = "DPT_SHOULD_NUM", columnDefinition = "NUMBER|百白破疫苗应种剂次||", nullable = true)
    private Integer dptShouldNum=0;
	
	@Column(name = "DPT_HAS_NUM", columnDefinition = "NUMBER|百白破疫苗实种剂次||", nullable = true)
    private Integer dptHasNum=0;
	
	@Column(name = "WHITE_VACCINE_SHOULD_NUM", columnDefinition = "NUMBER|白破疫苗应种人数||", nullable = true)
    private Integer whiteVaccineShouldNum=0;
	
	@Column(name = "WHITE_VACCINE_HAS_NUM", columnDefinition = "NUMBER|白破疫苗实种人数||", nullable = true)
    private Integer whiteVaccineHasNum=0;
	
	@Column(name = "LEPROSY_SHOULD_NUM", columnDefinition = "NUMBER|麻风疫苗应种人数||", nullable = true)
    private Integer leprosyShouldNum=0;
	
	@Column(name = "LEPROSY_HAS_NUM", columnDefinition = "NUMBER|麻风疫苗实种人数||", nullable = true)
    private Integer leprosyHasNum=0;
	
	@Column(name = "MEASLES_SHOULD_NUM", columnDefinition = "NUMBER|麻腮风疫苗应种人数||", nullable = true)
    private Integer measlesShouldNum=0;
	
	@Column(name = "MEASLES_HAS_NUM", columnDefinition = "NUMBER|麻腮风疫苗实种人数||", nullable = true)
    private Integer measlesHasNum=0;

	@Column(name = "AMENINGOCOCCAL_SHOULD_NUM", columnDefinition = "NUMBER|A群流脑疫苗应种剂次||", nullable = true)
    private Integer ameningococcalShouldNum=0;
	
	@Column(name = "AMENINGOCOCCAL_HAS_NUM", columnDefinition = "NUMBER|A群流脑疫苗实种剂次||", nullable = true)
    private Integer ameningococcalHasNum=0;
	
	@Column(name = "ACMENINGOCOCCAL_SHOULD_NUM", columnDefinition = "NUMBER|A+C群流脑疫苗应种剂次||", nullable = true)
    private Integer acmeningococcalShouldNum=0;
	
	@Column(name = "ACMENINGOCOCCAL_HAS_NUM", columnDefinition = "NUMBER|A+C群流脑疫苗实种剂次||", nullable = true)
    private Integer acmeningococcalHasNum=0;
	
	@Column(name = "ENCEPHALITIS_SHOULD_NUM", columnDefinition = "NUMBER|乙脑疫苗应种剂次||", nullable = true)
    private Integer encephalitisShouldNum=0;
	
	@Column(name = "ENCEPHALITIS_HAS_NUM", columnDefinition = "NUMBER|乙脑疫苗实种剂次||", nullable = true)
    private Integer encephalitisHasNum=0;
	
	@Column(name = "HAV_SHOULD_NUM", columnDefinition = "NUMBER|甲肝疫苗应种人数||", nullable = true)
    private Integer havShouldNum=0;
	
	@Column(name = "HAV_HAS_NUM", columnDefinition = "NUMBER|甲肝疫苗实种人数||", nullable = true)
    private Integer havHasNum=0;

	@Column(name = "MEASLESCONSTIT_SHOULD_NUM", columnDefinition = "NUMBER|含麻疹成分疫苗应种人数||", nullable = true)
    private Integer measlesconstitShouldNum=0;
	
	@Column(name = "MEASLESCONSTIT_HAS_NUM", columnDefinition = "NUMBER|含麻疹成分疫苗实种人数||", nullable = true)
    private Integer measlesconstitHasNum=0;
	
	@Column(name = "UPDATE_REPORTING_TIME", columnDefinition = "NUMBER|修改时间||", nullable = true)
    private Date updateReportingTime;


	public Date getUpdateReportingTime() {
		return updateReportingTime;
	}

	public void setUpdateReportingTime(Date updateReportingTime) {
		this.updateReportingTime = updateReportingTime;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public void setWhiteVaccineShouldNum(Integer whiteVaccineShouldNum) {
		this.whiteVaccineShouldNum = whiteVaccineShouldNum;
	}

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
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}


	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
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

	public Integer getWhiteVaccineShouldNum() {
		return whiteVaccineShouldNum;
	}

	public void setWhitVaccineShouldNum(Integer whiteVaccineShouldNum) {
		this.whiteVaccineShouldNum = whiteVaccineShouldNum;
	}

	public Integer getWhiteVaccineHasNum() {
		return whiteVaccineHasNum;
	}

	public void setWhiteVaccineHasNum(Integer whiteVaccineHasNum) {
		this.whiteVaccineHasNum = whiteVaccineHasNum;
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

	public Integer getMeaslesconstitShouldNum() {
		return measlesconstitShouldNum;
	}

	public void setMeaslesconstitShouldNum(Integer measlesconstitShouldNum) {
		this.measlesconstitShouldNum = measlesconstitShouldNum;
	}

	public Integer getMeaslesconstitHasNum() {
		return measlesconstitHasNum;
	}

	public void setMeaslesconstitHasNum(Integer measlesconstitHasNum) {
		this.measlesconstitHasNum = measlesconstitHasNum;
	}

}
