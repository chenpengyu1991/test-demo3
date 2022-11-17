package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_ACTIVITY_NOTICE")
public class HeActivityNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号|11|", length = 11, nullable = true)
	private Integer id;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|通知内容|500|", length = 500, nullable = true)
	private String content;

	@Column(name = "CREATOR", columnDefinition = "VARCHAR2|发布人|50|", length = 50, nullable = true)
	private String creator;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VARCHAR2|发布机构|50|", length = 50, nullable = true)
	private String createOrgan;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|发布日期||", nullable = true)
	private Date createDate;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态|1|", length = 1, nullable = true)
	private String status;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

}