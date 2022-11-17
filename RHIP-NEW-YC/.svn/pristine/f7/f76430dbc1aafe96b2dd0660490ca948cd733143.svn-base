package com.founder.rhip.ehr.entity.control;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DC_CHILDREN_SIDE_EFFECT")
public class ChildrenSideEffect implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
    private Long id;
    
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|儿童身份证/健康卡号||", length = 18 , nullable = true)
	private String idcard;

	@Column(name = "CHILD_NO", columnDefinition = "VARCHAR2|预防接种证编号||", length = 18 , nullable = true)
	private String childNo;

	@Column(name = "SIDE_REACTION_DATE", columnDefinition = "DATE|副反应日期||", nullable = true)
	private Date sideReactionDate;

	@Column(name = "BACTERIN_NO", columnDefinition = "VARCHAR2|接种疫苗代码||", length = 4 , nullable = true)
	private String bacterinNo;

	@Column(name = "VACCINE_NAME", columnDefinition = "VARCHAR2|疫苗名称||", length = 50 , nullable = true)
	private String vaccineName;
	
	@Column(name = "SEQU_CODE", columnDefinition = "VARCHAR2|副反应编码||", length = 4 , nullable = true)
	private String sequCode;

	@Column(name = "SEQU_NAME", columnDefinition = "VARCHAR2|副反应名称||", length = 100 , nullable = true)
	private String sequName;

	@Column(name = "INPUT_ORGANCODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15 , nullable = true)
	private String inputOrgancode;

	@Column(name = "INPUT_ORGAN", columnDefinition = "VARCHAR2|建档机构名称||", length = 70 , nullable = true)
	private String inputOrgan;

	@Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18 , nullable = true)
	private String inputIdcard;

	@Column(name = "INPUT_MAN", columnDefinition = "VARCHAR2|建档人姓名||", length = 50 , nullable = true)
	private String inputMan;

	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
	private Date inputDate;
	
	@Column(name = "VACCINATION_CODE", columnDefinition = "VARCHAR2|预防接种卡号||", length = 18, nullable = true)
	private String vaccinationCode;
	
	@Column(name = "VACCINATION_ORGANCODE", columnDefinition = "VARCHAR2|预防接种机构编码||", length = 18, nullable = true)
	private String vaccinationOrgancode;
	
	@Column(name = "VACCINATION_ORGANNAME", columnDefinition = "VARCHAR2|预防接种机构名称||", length = 70, nullable = true)
	private String vaccinationOrganname;
	
	@Transient
	private String sideReactionDateDesc;

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getChildNo() {
		return this.childNo;
	}

	public void setChildNo(String childNo) {
		this.childNo = childNo;
	}

	public Date getSideReactionDate() {
		return sideReactionDate;
	}

	public void setSideReactionDate(Date sideReactionDate) {
		this.sideReactionDate = sideReactionDate;
	}

	public String getBacterinNo() {
		return this.bacterinNo;
	}

	public void setBacterinNo(String bacterinNo) {
		this.bacterinNo = bacterinNo;
	}

	public String getSequCode() {
		return this.sequCode;
	}

	public void setSequCode(String sequCode) {
		this.sequCode = sequCode;
	}

	public String getSequName() {
		return this.sequName;
	}

	public void setSequName(String sequName) {
		this.sequName = sequName;
	}

	public String getInputOrgancode() {
		return this.inputOrgancode;
	}

	public void setInputOrgancode(String inputOrgancode) {
		this.inputOrgancode = inputOrgancode;
	}

	public String getInputOrgan() {
		return this.inputOrgan;
	}

	public void setInputOrgan(String inputOrgan) {
		this.inputOrgan = inputOrgan;
	}

	public String getInputIdcard() {
		return this.inputIdcard;
	}

	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

	public String getInputMan() {
		return this.inputMan;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getVaccinationCode() {
		return vaccinationCode;
	}

	
	public void setVaccinationCode(String vaccinationCode) {
		this.vaccinationCode = vaccinationCode;
	}

	
	public String getVaccinationOrgancode() {
		return vaccinationOrgancode;
	}

	
	public void setVaccinationOrgancode(String vaccinationOrgancode) {
		this.vaccinationOrgancode = vaccinationOrgancode;
	}

	
	public String getVaccineName() {
		return vaccineName;
	}

	
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	
	public String getVaccinationOrganname() {
		return vaccinationOrganname;
	}

	
	public void setVaccinationOrganname(String vaccinationOrganname) {
		this.vaccinationOrganname = vaccinationOrganname;
	}

	
	public String getSideReactionDateDesc() {
		return sideReactionDateDesc;
	}

	
	public void setSideReactionDateDesc(String sideReactionDateDesc) {
		this.sideReactionDateDesc = sideReactionDateDesc;
	}

	
}