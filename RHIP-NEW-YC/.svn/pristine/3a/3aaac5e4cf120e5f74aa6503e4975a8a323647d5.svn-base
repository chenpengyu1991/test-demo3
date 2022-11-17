
package com.founder.rhip.ehr.entity.control;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DC_CHILDREN_TABOO")
public class ChildrenTaboo implements Serializable {

	private static final long serialVersionUID = 4015238303260250688L;
	
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
    private Long id;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR|儿童身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "CHILD_NO", columnDefinition = "VARCHAR|预防接种证编号||", length = 18, nullable = true)
	private String childNo;

	@Column(name = "TABU_CODE", columnDefinition = "VARCHAR|禁忌症编码||", length = 2, nullable = true)
	private String tabuCode;

	@Column(name = "TABU_NAME", columnDefinition = "VARCHAR|禁忌症名称||", length = 100, nullable = true)
	private String tabuName;

	@Column(name = "INPUT_ORGANCODE", columnDefinition = "VARCHAR|建档机构编码||", length = 15, nullable = true)
	private String inputOrgancode;

	@Column(name = "INPUT_ORGAN", columnDefinition = "VARCHAR|建档机构名称||", length = 70, nullable = true)
	private String inputOrgan;

	@Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR|建档人身份证号||", length = 18, nullable = true)
	private String inputIdcard;

	@Column(name = "INPUT_MAN", columnDefinition = "VARCHAR|建档人姓名||", length = 50, nullable = true)
	private String inputMan;

	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
	private Date inputDate;

	@Column(name = "VACCINATION_CODE", columnDefinition = "VARCHAR2|预防接种卡号||", length = 18, nullable = true)
	private String vaccinationCode;
	
	@Column(name = "VACCINATION_ORGANCODE", columnDefinition = "VARCHAR2|预防接种机构编码||", length = 18, nullable = true)
	private String vaccinationOrgancode;
	
	@Column(name = "VACCINATION_ORGANNAME", columnDefinition = "VARCHAR2|预防接种机构名称||", length = 70, nullable = true)
	private String vaccinationOrganname;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Transient
	private String inputDateDesc;
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getChildNo() {
		return childNo;
	}

	public void setChildNo(String childNo) {
		this.childNo = childNo;
	}

	public String getTabuCode() {
		return tabuCode;
	}

	public void setTabuCode(String tabuCode) {
		this.tabuCode = tabuCode;
	}

	public String getTabuName() {
		return tabuName;
	}

	public void setTabuName(String tabuName) {
		this.tabuName = tabuName;
	}

	public String getInputOrgancode() {
		return inputOrgancode;
	}

	public void setInputOrgancode(String inputOrgancode) {
		this.inputOrgancode = inputOrgancode;
	}

	public String getInputOrgan() {
		return inputOrgan;
	}

	public void setInputOrgan(String inputOrgan) {
		this.inputOrgan = inputOrgan;
	}

	public String getInputIdcard() {
		return inputIdcard;
	}

	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

	public String getInputMan() {
		return inputMan;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
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


	
	public String getVaccinationOrganname() {
		return vaccinationOrganname;
	}


	
	public void setVaccinationOrganname(String vaccinationOrganname) {
		this.vaccinationOrganname = vaccinationOrganname;
	}


	
	public String getInputDateDesc() {
		return inputDateDesc;
	}


	
	public void setInputDateDesc(String inputDateDesc) {
		this.inputDateDesc = inputDateDesc;
	}


	
	public String getProcessStatus() {
		return processStatus;
	}


	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	
}
