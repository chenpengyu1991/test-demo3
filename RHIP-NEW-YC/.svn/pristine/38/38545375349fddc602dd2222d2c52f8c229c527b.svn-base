package com.founder.rhip.ehr.entity.portal;

import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SURVEY")
public class Survey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|标题|100|", length = 100, nullable = true)
	private String title;

	@Column(name = "PURPOSE", columnDefinition = "VARCHAR2|目的|200|", length = 200, nullable = true)
	private String purpose;

	@Column(name = "DIRECTIONS", columnDefinition = "VARCHAR2|说明|500|", length = 500, nullable = true)
	private String directions;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|调查表状态|2|", length = 2, nullable = true)
	private String status = "0";

	@Column(name = "SUBMIT_TIME", columnDefinition = "DATE|发布时间||", nullable = true)
	private Date submitTime;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构编码|50|", length = 50, nullable = true)
	private String orgCode;

	@Column(name = "USER_CODE", columnDefinition = "VARCHAR2|发布人|50|", length = 50, nullable = true)
	private String userCode;

	@Column(name = "START_DATE", columnDefinition = "DATE|调查开始日期||", nullable = true)
	private Date startDate;

	@Column(name = "END_DATE", columnDefinition = "DATE|调查结束日期||", nullable = true)
	private Date endDate;

	@Column(name = "count", columnDefinition = "DATE|参与调查问卷的人数||", nullable = true)
	private Integer count=0;

	private List<SurveyItem> items;
	
	@Transient
	private String targetNames;
	
	@Transient
	private String organization;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDirections() {
		return this.directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public List<SurveyItem> getItems() {
		return items;
	}

	public void setItems(List<SurveyItem> items) {
		this.items = items;
	}
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setTargetNames(String targetNames) {
		this.targetNames = targetNames;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String toHtml(){
		
		if(null == this.getItems() || this.getItems().isEmpty()){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		List<SurveyItem> surveyItems = this.getItems();
		for(SurveyItem itemOne: surveyItems){
			if(null != itemOne){
				sb.append(itemOne.toHtml());
			}
		}
		
		return "<table>"+sb.toString()+"</table>";
	}
	
	/**
	 * is Empty
	 * @return
	 */
	public boolean isEmpty() {
		if(StringUtils.isEmpty(this.getTitle())
				|| StringUtils.isEmpty(this.getPurpose())
				|| StringUtils.isEmpty(this.getDirections())
				|| isEmptyItems()
				|| null == this.getUserCode()){
			return true;
		}
		
		return false;
	}
	
	private boolean isEmptyItems(){
		if(null == this.getItems() || this.getItems().isEmpty()){
			return true;
		}
		for(SurveyItem itemOne: this.getItems()){
			if(null == itemOne || itemOne.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
}