package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IDM_LABOR_CAPACITY")
public class LaborCapacity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "LUBOUR_INCAPACITY", columnDefinition = "VARCHAR2|劳动力丧失||", length = 2, nullable = true)
	private String lubourIncapacity;

	@Column(name = "LOSS_ADL", columnDefinition = "VARCHAR2|生活自理能力丧失||", length = 2, nullable = true)
	private String lossAdl;

	@Column(name = "RELENISH_SUGGESTION", columnDefinition = "VARCHAR2|补充意见||", length = 4000, nullable = true)
	private String replenishSuggestion;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getLubourIncapacity() {
		return this.lubourIncapacity;
	}

	public void setLubourIncapacity(String lubourIncapacity) {
		this.lubourIncapacity = lubourIncapacity;
	}

	public String getLossAdl() {
		return this.lossAdl;
	}

	public void setLossAdl(String lossAdl) {
		this.lossAdl = lossAdl;
	}

	public String getReplenishSuggestion() {
		return this.replenishSuggestion;
	}

	public void setReplenishSuggestion(String replenishSuggestion) {
		this.replenishSuggestion = replenishSuggestion;
	}

}