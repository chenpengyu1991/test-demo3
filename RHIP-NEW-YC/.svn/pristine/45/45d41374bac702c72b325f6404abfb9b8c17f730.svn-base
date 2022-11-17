package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FILE_MANAGER")
public class FileManager implements Serializable {

	private static final long serialVersionUID = -6687578393695379836L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|标题|100|", length = 50, nullable = true)
	private String title;

	@Column(name = "FILE_TYPE", columnDefinition = "VARCHAR2|文档类型|2|", length = 50, nullable = true)
	private String fileType;

	@Column(name = "keyword", columnDefinition = "VARCHAR2|关键字|100|", length = 18, nullable = true)
	private String keyword;
	
	@Column(name = "path", columnDefinition = "VARCHAR2|路径|200|", length = 50, nullable = true)
	private String path;

	@Column(name = "CONTENTS", columnDefinition = "CLOB|内容||", length = 50, nullable = true)
	private String contents;

	@Column(name = "IS_DELETE", columnDefinition = "VARCHAR2|是否删除|2|", length = 18, nullable = true)
	private String isDelete = "0";
	
	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建日期", length = 50, nullable = true)
	private Date createDate;

	@Column(name = "CREATE_ORG_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrgCode;

	@Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建人|50|", length = 18, nullable = true)
	private String createUserCode;
	
	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期|", length = 50, nullable = true)
	private Date updateDate;

	@Column(name = "UPDATE_ORG_CODE", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrgCode;

	@Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新人|50|", length = 18, nullable = true)
	private String updateUserCode;

	@Column(name = "TIMES", columnDefinition = "NUMBER|次数|11|", length = 11, nullable = true)
	private Long times = 0l;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER|状态|1|", length = 1, nullable = true)
    private Integer status = 0;// 0表示未审核 1表示已审核
	
	@Transient
	private String dateFrom;

	@Transient
    private String dateTo;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrgCode() {
		return createOrgCode;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrgCode() {
		return updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
