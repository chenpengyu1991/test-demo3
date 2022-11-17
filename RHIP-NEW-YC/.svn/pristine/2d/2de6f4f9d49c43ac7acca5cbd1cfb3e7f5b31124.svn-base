package com.founder.rhip.im.entity.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="RD_DATA_COLLECTION_LOG")
public class RdDataCollectionLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="GB_CODE",columnDefinition="VARCHAR2|镇code|50|",length=50,nullable=true)
	private String gbCode;

	@Column(name="CENTER_CODE",columnDefinition="VARCHAR2|中心code|50|",length=50,nullable=true)
	private String centerCode;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构code|50|",length=50,nullable=true)
	private String organCode;

	@Column(name="ORG_NAME",columnDefinition="VARCHAR2|机构名称|100|",length=100,nullable=false)
	private String orgName;

	@Column(name="GENRE_CODE",columnDefinition="VARCHAR2|机构类型|50|",length=50,nullable=true)
	private String genreCode;

	@Column(name="TABLE_NAME",columnDefinition="VARCHAR2|监管表名|60|",length=60,nullable=false)
	private String tableName;

	@Column(name="MODEL_NAME",columnDefinition="VARCHAR2|实体类名|100|",length=100,nullable=false)
	private String modelName;

	@Column(name="LOGIC_DATE",columnDefinition="NUMBER|业务发生日期（如：出院日期）|8|",length=8,nullable=false)
	private Integer logicDate;

	@Column(name="UPLOAD_DATE",columnDefinition="NUMBER|上传日期（数据上传前置机的时间）|8|",length=8,nullable=false)
	private Integer uploadDate;

	@Column(name="COLLECT_DATE",columnDefinition="NUMBER|抽取日期（从前置机对应表抽取数据到统计业务表）|8|",length=8,nullable=false)
	private Integer collectDate;

	@Column(name="MODEL_OJBECT_DATA",columnDefinition="CLOB|实体对象数据（json格式）||",nullable=false)
	private String modelOjbectData;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;

	@Column(name="LOGIC_TYPE",columnDefinition="VARCHAR2|业务类型|100|",length=100,nullable=true)
	private String logicType;


	public RdDataCollectionLog(){
	}
	/**
	 *
	 * @param tableName
	 * @param logicDate
	 *            业务发生日期（如：出院日期）
	 * @param modelName
	 * @param modelOjbectData
	 * @param createDate
	 */
	public RdDataCollectionLog(String tableName, Integer logicDate, String modelName, String modelOjbectData, Timestamp createDate) {
		super();
		this.tableName = tableName;
		this.logicDate = logicDate;
		this.modelName = modelName;
		this.modelOjbectData = modelOjbectData;
		this.createDate = createDate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getGenreCode() {
		return this.genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Integer getLogicDate() {
		return this.logicDate;
	}

	public void setLogicDate(Integer logicDate) {
		this.logicDate = logicDate;
	}

	public Integer getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Integer uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getCollectDate() {
		return this.collectDate;
	}

	public void setCollectDate(Integer collectDate) {
		this.collectDate = collectDate;
	}

	public String getModelOjbectData() {
		return this.modelOjbectData;
	}

	public void setModelOjbectData(String modelOjbectData) {
		this.modelOjbectData = modelOjbectData;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getLogicType() {
		return this.logicType;
	}

	public void setLogicType(String logicType) {
		this.logicType = logicType;
	}

}