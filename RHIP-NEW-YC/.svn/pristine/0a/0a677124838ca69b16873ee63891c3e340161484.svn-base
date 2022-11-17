package com.founder.rhip.fds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ATTACHMENT_RECORD")
public class AttachmentRecord implements Serializable {

	private static final long serialVersionUID = 4695725553512964146L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|业务主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONGO_ID", columnDefinition = "NUMBER|MONGODB主键||", length = 11, nullable = true)
	private String mongoId;

	@Column(name = "BUSINESS_ID", columnDefinition = "NUMBER|关联业务表主键||", length = 11, nullable = true)
	private Long businessId;

	@Column(name = "FILE_SRC", columnDefinition = "VARCHAR2|文件来源||", length = 100, nullable = true)
	private String fileSrc;

	@Column(name = "FILE_SIZE", columnDefinition = "VARCHAR2|文件来源||", length = 100, nullable = true)
	private Long fileSize;

	@Column(name = "FILE_NAME", columnDefinition = "VARCHAR2|附件名称||", length = 100, nullable = true)
	private String fileName;

	@Column(name = "FILE_MD5", columnDefinition = "VARCHAR2|附件MD5||", length = 100, nullable = true)
	private String fileMd5;

	@Column(name = "CONTENT_TYPE", columnDefinition = "VARCHAR2|附件类型||", length = 100, nullable = true)
	private String contentType;

	@Column(name = "UPLOAD_DATE", columnDefinition = "DATE|上传时间||", nullable = true)
	private Date uploadDate;

	@Column(name = "USER_NAME", columnDefinition = "VARCHAR2|用户名||", length = 100, nullable = true)
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileMd5() {
		return fileMd5;
	}

	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}