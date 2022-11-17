package com.founder.rhip.ehr.entity.ep;

import com.founder.rhip.ehr.common.EHRConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EP_IODINE_SAMPLING")
public class IodineNutritionSampling implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String TYPE_TOWN = "1";//乡镇
	
	public static final String TYPE_SCHOOL = "2";//学校

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "SAMPLING_NO", columnDefinition = "VAR2|抽样点序号||", length = 20, nullable = true)
	private String samplingNo;
	
	@Column(name = "CODE", columnDefinition = "VAR2|抽样点编码||", length = 20 , nullable = true)
	private String code;

	@Column(name = "NAME", columnDefinition = "VAR2|抽样点名称||", length = 50 , nullable = true)
	private String name;

	@Column(name = "TYPE", columnDefinition = "VAR2|抽样点类型||", length = 20 , nullable = true)
	private String type;

	@Column(name = "REMARK", columnDefinition = "VAR2|备注||", length = 100 , nullable = true)
	private String remark;

	@Column(name = "SAMPLING_TIME", columnDefinition = "DATE|抽样时间||", nullable = true)
	private Date samplingTime;

	@Column(name = "SAMPLING_YEAR", columnDefinition = "VAR2|抽样年份||", length = 10 , nullable = true)
	private String samplingYear;

	@Column(name = "CREATE_PERSON", columnDefinition = "VAR2|创建人||", length = 50 , nullable = true)
	private String createPerson;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VAR2|创建机构||", length = 50 , nullable = true)
	private String createOrgan;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATE_PERSON", columnDefinition = "VAR2|更新人||", length = 50 , nullable = true)
	private String updatePerson;

	@Column(name = "UPDATE_ORGAN", columnDefinition = "VAR2|更新机构||", length = 50 , nullable = true)
	private String updateOrgan;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "DELETE_FLAG", columnDefinition = "VAR2|删除标识||", length = 1 , nullable = true)
	private Integer deleteFlag = EHRConstants.DELETE_FLG_0;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSamplingNo() {
		return this.samplingNo;
	}

	public void setSamplingNo(String samplingNo) {
		this.samplingNo = samplingNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getSamplingTime() {
		return this.samplingTime;
	}

	public void setSamplingTime(Date samplingTime) {
		this.samplingTime = samplingTime;
	}

	public String getSamplingYear() {
		return this.samplingYear;
	}

	public void setSamplingYear(String samplingYear) {
		this.samplingYear = samplingYear;
	}

	public String getCreatePerson() {
		return this.createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getCreateOrgan() {
		return this.createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdatePerson() {
		return this.updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getUpdateOrgan() {
		return this.updateOrgan;
	}

	public void setUpdateOrgan(String updateOrgan) {
		this.updateOrgan = updateOrgan;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}