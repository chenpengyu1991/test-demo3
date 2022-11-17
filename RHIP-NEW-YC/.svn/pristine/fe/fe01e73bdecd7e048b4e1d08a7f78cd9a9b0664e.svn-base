package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HE_SURVEY")
public class HeSurvey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号|11|", length = 11, nullable = true)
	private Integer id;

	@Column(name = "SURVEY_NAME", columnDefinition = "VARCHAR2|问卷名|100|", length = 100, nullable = true)
	private String surveyName;

	@Column(name = "FILE_NAME", columnDefinition = "VARCHAR2|文件名|100|", length = 100, nullable = true)
	private String fileName;

	@Column(name = "PATH", columnDefinition = "VARCHAR2|路径|100|", length = 100, nullable = true)
	private String path;

	@Column(name = "CREATOR", columnDefinition = "VARCHAR2|发布人|50|", length = 50, nullable = true)
	private String creator;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VARCHAR2|发布机构|50|", length = 50, nullable = true)
	private String createOrgan;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|发布日期||", nullable = true)
	private Date createDate;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态|1|", length = 1, nullable = true)
	private String status;

	@Transient
	private Long attachmentId;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurveyName() {
		return this.surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateOrgan() {
		return createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}
}