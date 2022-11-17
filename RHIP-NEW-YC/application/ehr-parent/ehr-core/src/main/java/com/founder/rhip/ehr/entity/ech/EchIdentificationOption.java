package com.founder.rhip.ehr.entity.ech;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECH_IDENTIFICATION_OPTION")
public class EchIdentificationOption implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDENTIFICATION_ID", columnDefinition = "NUMBER|辨识表ID|11|", length = 11, nullable = false)
	private Long identificationId;

	@Column(name = "OPTION_NO", columnDefinition = "NUMBER|题目编号|2|", length = 2, nullable = false)
	private Integer optionNo;

	@Column(name = "SCORE", columnDefinition = "NUMBER|得分|2|", length = 2, nullable = true)
	private Integer score;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdentificationId() {
		return this.identificationId;
	}

	public void setIdentificationId(Long identificationId) {
		this.identificationId = identificationId;
	}

	public Integer getOptionNo() {
		return this.optionNo;
	}

	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}