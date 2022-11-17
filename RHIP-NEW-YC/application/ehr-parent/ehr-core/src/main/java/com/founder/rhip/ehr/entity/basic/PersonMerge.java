package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PERSON_MERGE")
public class PersonMerge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号(自增长)|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|患者ID(主)|11|", length = 11, nullable = false)
	private Long personId;

	@Column(name = "RELATION_PERSON_ID", columnDefinition = "NUMBER|患者ID(关联)|11|", length = 11, nullable = false)
	private Long relationPersonId;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码(主)|20|", length = 20, nullable = true)
	private String idCard;

	@Column(name = "CREATOR_LOGIN_NAME", columnDefinition = "VARCHAR2|创建人登录名|50|", length = 50, nullable = true)
	private String creatorLoginName;

	@Column(name = "CREATOR_NAME", columnDefinition = "VARCHAR2|创建人昵称|50|", length = 50, nullable = true)
	private String creatorName;

	@Column(name = "CREATE_TIME", columnDefinition = "TIMESTAMP|创建人操作时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATER_LOGIN_NAME", columnDefinition = "VARCHAR2|更新人登录名|50|", length = 50, nullable = true)
	private String updaterLoginName;

	@Column(name = "UPDATER_NAME", columnDefinition = "VARCHAR2|更新人昵称|50|", length = 50, nullable = true)
	private String updaterName;

	@Column(name = "UPDATE_TIME", columnDefinition = "TIMESTAMP|更新人操作时间||", nullable = true)
	private Date updateTime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getRelationPersonId() {
		return this.relationPersonId;
	}

	public void setRelationPersonId(Long relationPersonId) {
		this.relationPersonId = relationPersonId;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCreatorLoginName() {
		return this.creatorLoginName;
	}

	public void setCreatorLoginName(String creatorLoginName) {
		this.creatorLoginName = creatorLoginName;
	}

	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdaterLoginName() {
		return this.updaterLoginName;
	}

	public void setUpdaterLoginName(String updaterLoginName) {
		this.updaterLoginName = updaterLoginName;
	}

	public String getUpdaterName() {
		return this.updaterName;
	}

	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}