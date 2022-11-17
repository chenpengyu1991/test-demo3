package com.founder.rhip.ehr.entity.file;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * FileDo 文档类.
 *
 */
@Document
public class FileDo {
	/**
	 * 主键
	 */
	@Id
	private String _id;
	/**
	 * 文件名称
	 */
    private String name;
	/**
	 * 文件类型
	 */
	private String contentType;
	/**
	 * 文件大小
	 */
	private long size;
	/**
	 * 文件上传时间
	 */
    private Date uploadDate;
    private String md5;
	/**
	 * 文件内容
	 */
	private byte[] content;
	/**
	 * 文件路径
	 */
	private String path;
	/**
	 * 文件来源
	 */
	private String fileSrc;

	/**
	 * 业务ID
	 */
	private Long businessId;
    
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public FileDo() {
    }
    
    public FileDo(String name, String contentType, long size, byte[] content) {
    	this.name = name;
    	this.contentType = contentType;
    	this.size = size;
    	this.uploadDate = new Date();
    	this.content = content;
    }
   
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FileDo fileDoInfo = (FileDo) object;
        return java.util.Objects.equals(size, fileDoInfo.size)
                && java.util.Objects.equals(name, fileDoInfo.name)
                && java.util.Objects.equals(contentType, fileDoInfo.contentType)
                && java.util.Objects.equals(uploadDate, fileDoInfo.uploadDate)
                && java.util.Objects.equals(md5, fileDoInfo.md5)
				&& java.util.Objects.equals(md5, fileDoInfo.md5)
                && java.util.Objects.equals(fileSrc, fileDoInfo.fileSrc);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, contentType, size, uploadDate, md5, fileSrc, _id);
    }

    @Override
    public String toString() {
        return "FileDo{"
                + "name='" + name + '\''
                + ", contentType='" + contentType + '\''
                + ", size=" + size
                + ", uploadDate=" + uploadDate
                + ", md5='" + md5 + '\''
				+ ", srcType='" + fileSrc + '\''
                + ", id='" + _id + '\''
                + '}';
    }
}
