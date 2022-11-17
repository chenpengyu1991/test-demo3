package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_TEST_ITEMS")
public class OhTestItems implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ENTERPRISE_INFO_ID", columnDefinition = "NUMBER|企业基本信息ID|11|", length = 11, nullable = true)
	private Long enterpriseInfoId;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|标题|50|", length = 50, nullable = true)
	private String title;

	@Column(name = "MINI_URL", columnDefinition = "VARCHAR2|小图片路径|50|", length = 50, nullable = true)
	private String miniUrl;

	@Column(name = "WORKSHOP_NAME", columnDefinition = "VARCHAR2|车间|50|", length = 50, nullable = true)
	private String workshopName;

	@Column(name = "DRAW_DATE", columnDefinition = "DATE|制图日期||", nullable = true)
	private Date drawDate;

	@Column(name = "CODE", columnDefinition = "VARCHAR2|编号|50|", length = 50, nullable = true)
	private String code;

	@Column(name = "POSITION", columnDefinition = "VARCHAR2|岗位|50|", length = 50, nullable = true)
	private String position;

	@Column(name = "TEST_ITEM", columnDefinition = "VARCHAR2|应测项目|50|", length = 50, nullable = true)
	private String testItem;

	@Column(name = "EXPLAIN", columnDefinition = "VARCHAR2|采机时机说明|50|", length = 50, nullable = true)
	private String explain;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEnterpriseInfoId() {
		return this.enterpriseInfoId;
	}

	public void setEnterpriseInfoId(Long enterpriseInfoId) {
		this.enterpriseInfoId = enterpriseInfoId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMiniUrl() {
		return this.miniUrl;
	}

	public void setMiniUrl(String miniUrl) {
		this.miniUrl = miniUrl;
	}

	public String getWorkshopName() {
		return this.workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public Date getDrawDate() {
		return this.drawDate;
	}

	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTestItem() {
		return this.testItem;
	}

	public void setTestItem(String testItem) {
		this.testItem = testItem;
	}

	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}