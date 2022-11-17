package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.util.StringUtil;

@Entity
@Table(name = "SURVEY_ITEM")
public class SurveyItem implements Serializable, Comparable<SurveyItem> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|调查描述|500|", length = 500, nullable = true)
	private String description;

	@Column(name = "LABEL_TYPE_CODE", columnDefinition = "VARCHAR2|创建标签的类型编码|50|", length = 50, nullable = true)
	private String labelTypeCode;

	@Column(name = "SURVEY_ID", columnDefinition = "NUMBER|调查表ID|11|", length = 11, nullable = true)
	private Long surveyId;

	@Column(name = "ORDER_NUM", columnDefinition = "NUMBER|调查项序号|11|", length = 11, nullable = true)
	private Long orderNum;
	
	@Transient
	private List<SurveyOption> surveyOptions;

	@Transient
	private List<PollText> pollTexts;

	@Transient
	private List<PollOption> pollOptions;
	
	@Transient
	private String pollOptionValue;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabelTypeCode() {
		return this.labelTypeCode;
	}

	public void setLabelTypeCode(String labelTypeCode) {
		this.labelTypeCode = labelTypeCode;
	}

	public Long getSurveyId() {
		return this.surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public List<SurveyOption> getSurveyOptions() {
		if(null == surveyOptions || surveyOptions.isEmpty())
			return new ArrayList<SurveyOption>();
		for (SurveyOption surveyOption : surveyOptions) {
			surveyOption.setItemId(id);
		}
		return surveyOptions;
	}

	public void setSurveyOptions(List<SurveyOption> surveyOptions) {
		this.surveyOptions = surveyOptions;
	}

	public List<PollText> getPollTexts() {
		return pollTexts;
	}

	public void setPollTexts(List<PollText> pollTexts) {
		this.pollTexts = pollTexts;
	}

	public List<PollOption> getPollOptions() {
		return pollOptions;
	}

	public void setPollOptions(List<PollOption> pollOptions) {
		this.pollOptions = pollOptions;
	}

	public String getPollOptionValue() {
		return pollOptionValue;
	}

	public void setPollOptionValue(String pollOptionValue) {
		this.pollOptionValue = pollOptionValue;
	}

	/**
	 * is empty
	 */
	public boolean isEmpty() {
		 
		if(StringUtils.isEmpty(this.getDescription())
				|| StringUtils.isEmpty(getLabelTypeCode())
				|| isEmptyOption()){
			return true;
		}
		
		return false;
	}
	
	private boolean isEmptyOption(){
		for(SurveyOption optionOne: this.getSurveyOptions()){
			if(null == optionOne || optionOne.isEmpty()){
				return true;
			}
		}
		
		return false;
	}

	public String toHtml() {
		StringBuilder sb = new StringBuilder();
		
		if(this.getLabelTypeCode().equalsIgnoreCase("TEXT")){
			generateTextHtml(sb);
		}else if(this.getLabelTypeCode().equalsIgnoreCase("RADIO")){
			generateRadioHtml(sb);
		}else if(this.getLabelTypeCode().equalsIgnoreCase("CHECKBOX")){
			generateCheckboxHtml(sb);
		}
		
		return sb.toString();
	}

	private void generateCheckboxHtml(StringBuilder sb) {
		StringBuilder sbTmp = new StringBuilder();
		for(SurveyOption optionOne: this.getSurveyOptions()){
			sbTmp.append("&nbsp;&nbsp;<input type=\"checkbox\" value=\""+optionOne.getId()+"\" name=\"chk_"+this.getSurveyId()+"_"+this.getId()+"_"+optionOne.getId()+"\" />&nbsp;&nbsp;"+optionOne.getItem());
		}
		
		sb.append("<tr><td>"+this.getDescription()+"</td><td>" +sbTmp.toString() +"</td></tr>");
	}

	private void generateRadioHtml(StringBuilder sb) {
		StringBuilder sbTmp = new StringBuilder();
		for(SurveyOption optionOne: this.getSurveyOptions()){
			sbTmp.append("&nbsp;&nbsp;<input type=\"radio\" value=\""+optionOne.getId()+"\" name=\"radio_"+this.getSurveyId()+"_"+this.getId()+"\" />&nbsp;&nbsp;"+optionOne.getItem());
		}
		
		sb.append("<tr><td>"+this.getDescription()+"</td><td>" +sbTmp.toString() +"</td></tr>");
	}

	private void generateTextHtml(StringBuilder sb) {
		sb.append("<tr><td>"+this.getDescription()+"</td><td><textarea name=\"text_"+this.getSurveyId()+"_"+this.getId()+"\"></textarea></td></tr>");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurveyItem other = (SurveyItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	//重写toString()方法，因为如果不重写，打印出来的是16进制代码
	@Override
    public String toString() {
        return id + " " + description;
    }
	
	//使用treeSet时按照 主键的升序排序
	@Override
	public int compareTo(SurveyItem o) {
		return (int) (this.id - o.id);
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	
	
}