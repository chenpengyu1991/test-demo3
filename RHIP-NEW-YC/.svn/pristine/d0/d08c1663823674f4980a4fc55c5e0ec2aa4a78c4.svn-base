package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SERVICE_INFO")
public class ServiceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "INFO_TYPE", columnDefinition = "NUMBER|信息分类|11|", length = 11, nullable = true)
	private Long infoType;

	@Column(name = "DETAIL_TYPE", columnDefinition = "NUMBER|细节分类|11|", length = 11, nullable = true)
	private Long detailType;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|标题|50|", length = 50, nullable = true)
	private String title;

	@Column(name = "AUTHOR", columnDefinition = "VARCHAR2|作者|20|", length = 20, nullable = true)
	private String author;

	@Column(name = "SOURCE", columnDefinition = "VARCHAR2|来源|20|", length = 20, nullable = true)
	private String source;

	@Column(name = "IS_RECOMMEND", columnDefinition = "VARCHAR2|是否推荐|20|", length = 20, nullable = true)
	private String isRecommend;

	@Column(name = "CREAT_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date creatTime;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "CREATOR", columnDefinition = "VARCHAR2|创建者|20|", length = 20, nullable = true)
	private String creator;

	@Column(name = "CONTENTS", columnDefinition = "CLOB|内容|2000|", length = 2000, nullable = true)
	private String contents;

	@Column(name = "TIMES", columnDefinition = "NUMBER|次数|11|", length = 11, nullable = true)
	private Long times;

	@Column(name = "PATH", columnDefinition = "VARCHAR2|地址|200|", length = 200, nullable = true)
	private String path;
	
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除|1|", length = 1, nullable = true)
	private Integer isDelete = 0;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER|发布状态：未发布：0, 已发布：1|1|", length = 1, nullable = true)
	private Integer status = 0;

	@Column(name = "IS_ROLL_PICTURE", columnDefinition = "VARCHAR2|是否滚动图片: 否：0, 是：1|20|", length = 20, nullable = true)
	private String isRollPicture;
	
	@Column(name = "ROLL_PICTURE_INFO", columnDefinition = "VARCHAR2|滚动图片描述|200|", length = 200, nullable = true)
	private String rollPictureInfo;

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

	private String infoTypeName;
	private String detailTypeName;
	private String operatorType;//1查看2修改3新增
	
	private Date beginTime;
	private Date endTime;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInfoType() {
		return this.infoType;
	}

	public void setInfoType(Long infoType) {
		this.infoType = infoType;
	}

	public Long getDetailType() {
		return this.detailType;
	}

	public void setDetailType(Long detailType) {
		this.detailType = detailType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getTimes() {
		return this.times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getInfoTypeName() {
		return infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		this.infoTypeName = infoTypeName;
	}

	public String getDetailTypeName() {
		return detailTypeName;
	}

	public void setDetailTypeName(String detailTypeName) {
		this.detailTypeName = detailTypeName;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIsRollPicture() {
		return isRollPicture;
	}

	public void setIsRollPicture(String isRollPicture) {
		this.isRollPicture = isRollPicture;
	}

	public String getRollPictureInfo() {
		return rollPictureInfo;
	}

	public void setRollPictureInfo(String rollPictureInfo) {
		this.rollPictureInfo = rollPictureInfo;
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

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
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

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}
}