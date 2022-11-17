package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "EHR_DOC_LEVEL")
public class EhrDocLevel implements Serializable {

	private static final long serialVersionUID = -338542802889169830L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|personId||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "OLD_STAR", columnDefinition = "NUMBER|原星级||", length = 1, nullable = false)
	private Integer oldStar;

	@Column(name = "NEW_STAR", columnDefinition = "NUMBER|新星级||", length = 1, nullable = false)
	private Integer newStar;

	@Column(name = "UPDATE_ORG_CODE", columnDefinition = "VARCHAR2|修改机构编码||", length = 15, nullable = false)
	private String updateOrgCode;

	@Column(name = "UPDATE_STAFF_CODE", columnDefinition = "VARCHAR2|更新人staff编码||", length = 50, nullable = false)
	private String updateStaffCode;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = false)
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Integer getOldStar() {
		return oldStar;
	}

	public void setOldStar(Integer oldStar) {
		this.oldStar = oldStar;
	}

	public Integer getNewStar() {
		return newStar;
	}

	public void setNewStar(Integer newStar) {
		this.newStar = newStar;
	}

	public String getUpdateOrgCode() {
		return updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public String getUpdateStaffCode() {
		return updateStaffCode;
	}

	public void setUpdateStaffCode(String updateStaffCode) {
		this.updateStaffCode = updateStaffCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}