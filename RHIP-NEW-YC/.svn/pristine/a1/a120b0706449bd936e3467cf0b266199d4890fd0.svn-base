package com.founder.rhip.ehr.entity.basic;

import com.founder.rhip.ehr.common.ImageUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UPLOAD_INFO_RECORD")
public class UploadInfoRecord implements Serializable {

	private static final long serialVersionUID = 4695725553512964146L;
	
	private static final String[] IMAGES = new String[] {"jpg", "jpeg", "png", "bmp"};

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "RESOURCE_ID", columnDefinition = "NUMBER|文件来源主键||", length = 11, nullable = true)
	private Long resourceId;

	//用mongoDB之前为文件路径，用mongoDB过后为存在mongoDB中的ID
	@Column(name = "ORIGINAL_FILE_PATH", columnDefinition = "VARCHAR2|文件路径||", length = 200, nullable = true)
	private String originalFilePath;

	@Column(name = "FILE_NAME", columnDefinition = "VARCHAR2|文件名||", length = 100, nullable = true)
	private String fileName;

	@Column(name = "FILE_RESOURCE", columnDefinition = "VARCHAR2|文件来源||", length = 100, nullable = true)
	private String fileResource;

	@Column(name = "FILE_TYPE", columnDefinition = "VARCHAR2|文件类型||", length = 50, nullable = true)
	private String fileType;

	@Column(name = "THUMBNAIL_PATH", columnDefinition = "VARCHAR2|缩略图路径||", length = 200, nullable = true)
	private String thumbnailPath;

	@Column(name = "CREATER", columnDefinition = "VARCHAR2|创建人||", length = 50, nullable = true)
	private String creater;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "ORIGINAL_FILE_NAME", columnDefinition = "VARCHAR2|原始文件名||", length = 100, nullable = true)
	private String originalFileName;

	private boolean imageFlag;
	
	

	public UploadInfoRecord() {
	}

	public UploadInfoRecord(Long resourceId, String originalFilePath, String originalFileName, String fileResource,
			String creater, Date createTime) {
		this.resourceId = resourceId;
		this.originalFilePath = originalFilePath;
		this.originalFileName = originalFileName;
		this.fileResource = fileResource;
		this.creater = creater;
		this.createTime = createTime;
		if (isImageFlag()) {
			this.thumbnailPath = ImageUtil.getThumbnailPath(originalFilePath);
		}
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getOriginalFilePath() {
		return this.originalFilePath;
	}

	public void setOriginalFilePath(String originalFilePath) {
		this.originalFilePath = originalFilePath;
	}

	public String getFileName() {
		if (StringUtils.isNotBlank(originalFilePath)) {
			if (StringUtils.contains(originalFilePath, "/")) {
				this.fileName = StringUtils.substringAfterLast(originalFilePath, "/");
			} else if (StringUtils.contains(originalFilePath, "\\")) {
				this.fileName = StringUtils.substringAfterLast(originalFilePath, "\\");
			}
		}
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileResource() {
		return this.fileResource;
	}

	public void setFileResource(String fileResource) {
		this.fileResource = fileResource;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getThumbnailPath() {
		return this.thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Transient
	public boolean isImageFlag() {
		if (StringUtils.isBlank(originalFileName)) {
			this.imageFlag = false;
			return imageFlag;
		}
		String extendName = StringUtils.substringAfterLast(originalFileName, ".");
		if (ArrayUtils.contains(IMAGES, StringUtils.lowerCase(extendName))) {
			this.imageFlag = true;
		}
		return imageFlag;
	}
	
	public void setImageFlag(boolean imageFlag) {
		this.imageFlag = imageFlag;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public UploadInfoRecord(Long resourceId, String originalFilePath, String fileResource,
							String creater, Date createTime) {
		this.resourceId = resourceId;
		this.originalFilePath = originalFilePath;
		this.fileResource = fileResource;
		this.creater = creater;
		this.createTime = createTime;
		if (isImageFlag()) {
			this.thumbnailPath = ImageUtil.getThumbnailPath(originalFilePath);
		}
	}
}