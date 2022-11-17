package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_STATISTICS")
public class HaStatistics implements Serializable {

	private static final long serialVersionUID = -338542802889169836L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 12, nullable = false)
	private String orgCode;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称||", length = 100, nullable = true)
	private String orgName;

	@Column(name = "STATISTICS_DATE", columnDefinition = "DATE|统计时间||", nullable = false)
	private Date statisticsDate;

	@Column(name = "HR_SIX_CHILD", columnDefinition = "NUMBER|户籍0~6岁儿童||", length = 8, nullable = true)
	private Integer hrSixChild;

	@Column(name = "HR_FERTILE_WOMAN", columnDefinition = "NUMBER|户籍育龄妇女||", length = 8, nullable = true)
	private Integer hrFertileWoman;

	@Column(name = "HR_SIXO_TO_SIXF", columnDefinition = "NUMBER|户籍≥60岁老人||", length = 8, nullable = true)
	private Integer hrSixoToSixf;

	@Column(name = "HR_GREAT_SIXF", columnDefinition = "NUMBER|户籍≥65岁老人||", length = 8, nullable = true)
	private Integer hrGreatSixf;

	@Column(name = "HR_ARCHIVE_NEW", columnDefinition = "NUMBER|户籍新增个人档案||", length = 8, nullable = true)
	private Integer hrArchiveNew;

	@Column(name = "HR_ARCHIVE_TOTAL", columnDefinition = "NUMBER|户籍更新份数||", length = 8, nullable = true)
	private Integer hrArchiveTotal;

	@Column(name = "HR_ARCHIVE_COUNT", columnDefinition = "NUMBER|户籍档案更新次数||", length = 8, nullable = true)
	private Integer hrArchiveCount;

	@Column(name = "HR_ARCHIVE_CANCEL", columnDefinition = "NUMBER|户籍档案注销||", length = 8, nullable = true)
	private Integer hrArchiveCancel;

	@Column(name = "HR_ARCHIVE_EMIGRATION", columnDefinition = "NUMBER|户籍档案迁出||", length = 8, nullable = true)
	private Integer hrArchiveEmigration;

	@Column(name = "HR_HBP", columnDefinition = "NUMBER|户籍高血压||", length = 8, nullable = true)
	private Integer hrHbp;

	@Column(name = "HR_DM", columnDefinition = "NUMBER|户籍糖尿病||", length = 8, nullable = true)
	private Integer hrDm;

	@Column(name = "HR_CA", columnDefinition = "NUMBER|户籍肿瘤||", length = 8, nullable = true)
	private Integer hrCa;

	@Column(name = "HR_HD", columnDefinition = "NUMBER|户籍冠心病||", length = 8, nullable = true)
	private Integer hrHd;

	@Column(name = "HR_STROKE", columnDefinition = "NUMBER|户籍脑卒中||", length = 8, nullable = true)
	private Integer hrStroke;

	@Column(name = "HR_OUTPATIENT", columnDefinition = "NUMBER|户籍门诊||", length = 8, nullable = true)
	private Integer hrOutpatient;

	@Column(name = "HR_IN_HOSPITAL", columnDefinition = "NUMBER|户籍住院||", length = 8, nullable = true)
	private Integer hrInHospital;

	@Column(name = "HR_PE", columnDefinition = "NUMBER|户籍体检||", length = 8, nullable = true)
	private Integer hrPe;
	
	@Column(name = "HR_ONE_STAR", columnDefinition = "NUMBER|户籍一星||", length = 8, nullable = true)
	private Integer hrOneStar;
	
	@Column(name = "HR_TWO_STAR", columnDefinition = "NUMBER|户籍二星||", length = 8, nullable = true)
	private Integer hrTwoStar;
	
	@Column(name = "HR_THREE_STAR", columnDefinition = "NUMBER|户籍三星||", length = 8, nullable = true)
	private Integer hrThreeStar;

	@Column(name = "UNHR_SIX_CHILD", columnDefinition = "NUMBER|非户籍0~6岁儿童||", length = 8, nullable = true)
	private Integer unhrSixChild;

	@Column(name = "UNHR_FERTILE_WOMAN", columnDefinition = "NUMBER|非户籍育龄妇女||", length = 8, nullable = true)
	private Integer unhrFertileWoman;

	@Column(name = "UNHR_SIXO_TO_SIXF", columnDefinition = "NUMBER|非户籍≥60岁老人||", length = 8, nullable = true)
	private Integer unhrSixoToSixf;

	@Column(name = "UNHR_GREAT_SIXF", columnDefinition = "NUMBER|非户籍≥65岁老人||", length = 8, nullable = true)
	private Integer unhrGreatSixf;

	@Column(name = "UNHR_ARCHIVE_NEW", columnDefinition = "NUMBER|非户籍新增个人档案||", length = 8, nullable = true)
	private Integer unhrArchiveNew;

	@Column(name = "UNHR_ARCHIVE_TOTAL", columnDefinition = "NUMBER|非户籍档案更新份数||", length = 8, nullable = true)
	private Integer unhrArchiveTotal;

	@Column(name = "UNHR_ARCHIVE_COUNT", columnDefinition = "NUMBER|非户籍档案更新次数||", length = 8, nullable = true)
	private Integer unhrArchiveCount;

	@Column(name = "UNHR_ARCHIVE_CANCEL", columnDefinition = "NUMBER|非户籍档案注销||", length = 8, nullable = true)
	private Integer unhrArchiveCancel;

	@Column(name = "UNHR_ARCHIVE_EMIGRATION", columnDefinition = "NUMBER|非户籍档案迁出||", length = 8, nullable = true)
	private Integer unhrArchiveEmigration;

	@Column(name = "UNHR_HBP", columnDefinition = "NUMBER|非户籍高血压||", length = 8, nullable = true)
	private Integer unhrHbp;

	@Column(name = "UNHR_DM", columnDefinition = "NUMBER|非户籍糖尿病||", length = 8, nullable = true)
	private Integer unhrDm;

	@Column(name = "UNHR_CA", columnDefinition = "NUMBER|非户籍肿瘤||", length = 8, nullable = true)
	private Integer unhrCa;

	@Column(name = "UNHR_HD", columnDefinition = "NUMBER|非户籍冠心病||", length = 8, nullable = true)
	private Integer unhrHd;

	@Column(name = "UNHR_STROKE", columnDefinition = "NUMBER|非户籍脑卒中||", length = 8, nullable = true)
	private Integer unhrStroke;

	@Column(name = "UNHR_OUTPATIENT", columnDefinition = "NUMBER|非户籍门诊||", length = 8, nullable = true)
	private Integer unhrOutpatient;

	@Column(name = "UNHR_IN_HOSPITAL", columnDefinition = "NUMBER|非户籍住院||", length = 8, nullable = true)
	private Integer unhrInHospital;

	@Column(name = "UNHR_PE", columnDefinition = "NUMBER|非户籍体检||", length = 8, nullable = true)
	private Integer unhrPe;
	
	@Column(name = "UNHR_ONE_STAR", columnDefinition = "NUMBER|非户籍一星||", length = 8, nullable = true)
	private Integer unhrOneStar;
	
	@Column(name = "HR_TWO_STAR", columnDefinition = "NUMBER|非户籍二星||", length = 8, nullable = true)
	private Integer unhrTwoStar;
	
	@Column(name = "HR_THREE_STAR", columnDefinition = "NUMBER|非户籍三星||", length = 8, nullable = true)
	private Integer unhrThreeStar;

	@Column(name = "NOFILE", columnDefinition = "NUMBER|未建档||", length = 8, nullable = true)
	private Integer nofile;

	@Column(name = "TRANSFERRED", columnDefinition = "NUMBER|已转入档案||", length = 8, nullable = true)
	private Integer transferred;

	@Column(name = "CANCELLED", columnDefinition = "NUMBER|已注销||", length = 8, nullable = true)
	private Integer cancelled;

	@Column(name = "ROLLOUT", columnDefinition = "NUMBER|已转出||", length = 8, nullable = true)
	private Integer rollout;
	
	@Column(name = "PERSON_WAIT_CREATE", columnDefinition = "NUMBER|待建档||", length = 8, nullable = true)
	private Integer personWaitCreate;
	
	@Column(name = "PERSON_HAD_CREATE", columnDefinition = "NUMBER|已建档||", length = 8, nullable = true)
	private Integer personHadCreate;
	
	@Column(name = "PERSON_HAD_WRITEOFF", columnDefinition = "NUMBER|已注销||", length = 8, nullable = true)
	private Integer personHadWriteoff;
	
	@Column(name = "FAMILY_HAD_CREATE", columnDefinition = "NUMBER|已建档||", length = 8, nullable = true)
	private Integer familyHadCreate;
	
	@Column(name = "FAMILY_HAD_WRITEOFF", columnDefinition = "NUMBER|已注销||", length = 8, nullable = true)
	private Integer familyHadWriteoff;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR|行政区划CODE||", length = 12, nullable = true)
	private String gbcode;
	
	@Column(name = "TOWN_NAME", columnDefinition = "VARCHAR|镇名称||", length = 150, nullable = true)
	private String townName;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
	}

	public Integer getHrSixChild() {
		return this.hrSixChild;
	}

	public void setHrSixChild(Integer hrSixChild) {
		this.hrSixChild = hrSixChild;
	}

	public Integer getHrFertileWoman() {
		return this.hrFertileWoman;
	}

	public void setHrFertileWoman(Integer hrFertileWoman) {
		this.hrFertileWoman = hrFertileWoman;
	}

	public Integer getHrSixoToSixf() {
		return this.hrSixoToSixf;
	}

	public void setHrSixoToSixf(Integer hrSixoToSixf) {
		this.hrSixoToSixf = hrSixoToSixf;
	}

	public Integer getHrGreatSixf() {
		return this.hrGreatSixf;
	}

	public void setHrGreatSixf(Integer hrGreatSixf) {
		this.hrGreatSixf = hrGreatSixf;
	}

	public Integer getHrArchiveNew() {
		return this.hrArchiveNew;
	}

	public void setHrArchiveNew(Integer hrArchiveNew) {
		this.hrArchiveNew = hrArchiveNew;
	}

	public Integer getHrArchiveTotal() {
		return this.hrArchiveTotal;
	}

	public void setHrArchiveTotal(Integer hrArchiveTotal) {
		this.hrArchiveTotal = hrArchiveTotal;
	}

	public Integer getHrArchiveCount() {
		return this.hrArchiveCount;
	}

	public void setHrArchiveCount(Integer hrArchiveCount) {
		this.hrArchiveCount = hrArchiveCount;
	}

	public Integer getHrArchiveCancel() {
		return this.hrArchiveCancel;
	}

	public void setHrArchiveCancel(Integer hrArchiveCancel) {
		this.hrArchiveCancel = hrArchiveCancel;
	}

	public Integer getHrArchiveEmigration() {
		return this.hrArchiveEmigration;
	}

	public void setHrArchiveEmigration(Integer hrArchiveEmigration) {
		this.hrArchiveEmigration = hrArchiveEmigration;
	}

	public Integer getHrHbp() {
		return this.hrHbp;
	}

	public void setHrHbp(Integer hrHbp) {
		this.hrHbp = hrHbp;
	}

	public Integer getHrDm() {
		return this.hrDm;
	}

	public void setHrDm(Integer hrDm) {
		this.hrDm = hrDm;
	}

	public Integer getHrCa() {
		return this.hrCa;
	}

	public void setHrCa(Integer hrCa) {
		this.hrCa = hrCa;
	}

	public Integer getHrHd() {
		return this.hrHd;
	}

	public void setHrHd(Integer hrHd) {
		this.hrHd = hrHd;
	}

	public Integer getHrStroke() {
		return this.hrStroke;
	}

	public void setHrStroke(Integer hrStroke) {
		this.hrStroke = hrStroke;
	}

	public Integer getHrOutpatient() {
		return this.hrOutpatient;
	}

	public void setHrOutpatient(Integer hrOutpatient) {
		this.hrOutpatient = hrOutpatient;
	}

	public Integer getHrInHospital() {
		return this.hrInHospital;
	}

	public void setHrInHospital(Integer hrInHospital) {
		this.hrInHospital = hrInHospital;
	}

	public Integer getHrPe() {
		return this.hrPe;
	}

	public void setHrPe(Integer hrPe) {
		this.hrPe = hrPe;
	}

	public Integer getUnhrSixChild() {
		return this.unhrSixChild;
	}

	public void setUnhrSixChild(Integer unhrSixChild) {
		this.unhrSixChild = unhrSixChild;
	}

	public Integer getUnhrFertileWoman() {
		return this.unhrFertileWoman;
	}

	public void setUnhrFertileWoman(Integer unhrFertileWoman) {
		this.unhrFertileWoman = unhrFertileWoman;
	}

	public Integer getUnhrSixoToSixf() {
		return this.unhrSixoToSixf;
	}

	public void setUnhrSixoToSixf(Integer unhrSixoToSixf) {
		this.unhrSixoToSixf = unhrSixoToSixf;
	}

	public Integer getUnhrGreatSixf() {
		return this.unhrGreatSixf;
	}

	public void setUnhrGreatSixf(Integer unhrGreatSixf) {
		this.unhrGreatSixf = unhrGreatSixf;
	}

	public Integer getUnhrArchiveNew() {
		return this.unhrArchiveNew;
	}

	public void setUnhrArchiveNew(Integer unhrArchiveNew) {
		this.unhrArchiveNew = unhrArchiveNew;
	}

	public Integer getUnhrArchiveTotal() {
		return this.unhrArchiveTotal;
	}

	public void setUnhrArchiveTotal(Integer unhrArchiveTotal) {
		this.unhrArchiveTotal = unhrArchiveTotal;
	}

	public Integer getUnhrArchiveCount() {
		return this.unhrArchiveCount;
	}

	public void setUnhrArchiveCount(Integer unhrArchiveCount) {
		this.unhrArchiveCount = unhrArchiveCount;
	}

	public Integer getUnhrArchiveCancel() {
		return this.unhrArchiveCancel;
	}

	public void setUnhrArchiveCancel(Integer unhrArchiveCancel) {
		this.unhrArchiveCancel = unhrArchiveCancel;
	}

	public Integer getUnhrArchiveEmigration() {
		return this.unhrArchiveEmigration;
	}

	public void setUnhrArchiveEmigration(Integer unhrArchiveEmigration) {
		this.unhrArchiveEmigration = unhrArchiveEmigration;
	}

	public Integer getUnhrHbp() {
		return this.unhrHbp;
	}

	public void setUnhrHbp(Integer unhrHbp) {
		this.unhrHbp = unhrHbp;
	}

	public Integer getUnhrDm() {
		return this.unhrDm;
	}

	public void setUnhrDm(Integer unhrDm) {
		this.unhrDm = unhrDm;
	}

	public Integer getUnhrCa() {
		return this.unhrCa;
	}

	public void setUnhrCa(Integer unhrCa) {
		this.unhrCa = unhrCa;
	}

	public Integer getUnhrHd() {
		return this.unhrHd;
	}

	public void setUnhrHd(Integer unhrHd) {
		this.unhrHd = unhrHd;
	}

	public Integer getUnhrStroke() {
		return this.unhrStroke;
	}

	public void setUnhrStroke(Integer unhrStroke) {
		this.unhrStroke = unhrStroke;
	}

	public Integer getUnhrOutpatient() {
		return this.unhrOutpatient;
	}

	public void setUnhrOutpatient(Integer unhrOutpatient) {
		this.unhrOutpatient = unhrOutpatient;
	}

	public Integer getUnhrInHospital() {
		return this.unhrInHospital;
	}

	public void setUnhrInHospital(Integer unhrInHospital) {
		this.unhrInHospital = unhrInHospital;
	}

	public Integer getUnhrPe() {
		return this.unhrPe;
	}

	public void setUnhrPe(Integer unhrPe) {
		this.unhrPe = unhrPe;
	}

	public Integer getNofile() {
		return this.nofile;
	}

	public void setNofile(Integer nofile) {
		this.nofile = nofile;
	}

	public Integer getTransferred() {
		return this.transferred;
	}

	public void setTransferred(Integer transferred) {
		this.transferred = transferred;
	}

	public Integer getCancelled() {
		return this.cancelled;
	}

	public void setCancelled(Integer cancelled) {
		this.cancelled = cancelled;
	}

	public Integer getRollout() {
		return this.rollout;
	}

	public void setRollout(Integer rollout) {
		this.rollout = rollout;
	}

	public Integer getHrOneStar() {
		return hrOneStar;
	}

	public void setHrOneStar(Integer hrOneStar) {
		this.hrOneStar = hrOneStar;
	}

	public Integer getHrTwoStar() {
		return hrTwoStar;
	}

	public void setHrTwoStar(Integer hrTwoStar) {
		this.hrTwoStar = hrTwoStar;
	}

	public Integer getHrThreeStar() {
		return hrThreeStar;
	}

	public void setHrThreeStar(Integer hrThreeStar) {
		this.hrThreeStar = hrThreeStar;
	}

	public Integer getUnhrOneStar() {
		return unhrOneStar;
	}

	public void setUnhrOneStar(Integer unhrOneStar) {
		this.unhrOneStar = unhrOneStar;
	}

	public Integer getUnhrTwoStar() {
		return unhrTwoStar;
	}

	public void setUnhrTwoStar(Integer unhrTwoStar) {
		this.unhrTwoStar = unhrTwoStar;
	}

	public Integer getUnhrThreeStar() {
		return unhrThreeStar;
	}

	public void setUnhrThreeStar(Integer unhrThreeStar) {
		this.unhrThreeStar = unhrThreeStar;
	}

	public Integer getPersonHadCreate() {
		return personHadCreate;
	}

	public void setPersonHadCreate(Integer personHadCreate) {
		this.personHadCreate = personHadCreate;
	}

	public Integer getPersonHadWriteoff() {
		return personHadWriteoff;
	}

	public void setPersonHadWriteoff(Integer personHadWriteoff) {
		this.personHadWriteoff = personHadWriteoff;
	}

	public Integer getFamilyHadCreate() {
		return familyHadCreate;
	}

	public void setFamilyHadCreate(Integer familyHadCreate) {
		this.familyHadCreate = familyHadCreate;
	}

	public Integer getFamilyHadWriteoff() {
		return familyHadWriteoff;
	}

	public void setFamilyHadWriteoff(Integer familyHadWriteoff) {
		this.familyHadWriteoff = familyHadWriteoff;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Integer getPersonWaitCreate() {
		return personWaitCreate;
	}

	public void setPersonWaitCreate(Integer personWaitCreate) {
		this.personWaitCreate = personWaitCreate;
	}

}