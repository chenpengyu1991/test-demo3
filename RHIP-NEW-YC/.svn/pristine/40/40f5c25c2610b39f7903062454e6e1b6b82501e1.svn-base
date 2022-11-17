package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IDM_NCP")
public class IdmNcp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2200239954163991223L;
	
	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
    private Long id;

	@Item(index=1,column = "姓名")
	@Column(name = "NAME", columnDefinition = "VARCHAR2|调查者姓名||", length = 50, nullable = false)
    private String name;

	@Item(index=2,column ="身份证件号码")
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|调查者身份证号码||", length = 20, nullable = true)
    private String idcard;

	@Item(index=5,column ="住址")
	@Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址详细地址||", length = 200, nullable = false)
    private String paAddress;

	@Item(index=6,column ="调查结果",isDic=true,dicType="WHCH00034")
	@Column(name = "SURVEY_RESULT", columnDefinition = "NUMBER|调查结果|0正常，1疑似，2确诊 IDM00645|", nullable = false)
    private Integer surveyResult;

	@Item(index=4,column ="联系电话")
	@Column(name = "TEL", columnDefinition = "VARCHAR2|电话号码||", length = 20, nullable = false)
	private String tel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPaAddress() {
		return paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public Integer getSurveyResult() {
		return surveyResult;
	}

	public void setSurveyResult(Integer surveyResult) {
		this.surveyResult = surveyResult;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
