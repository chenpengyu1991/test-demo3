package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.rhip.ehr.entity.basic.User;

@Entity
@Table(name = "POLL_TEXT")
public class PollText implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "VALUE", columnDefinition = "VARCHAR2|选项值|1024|", length = 1024, nullable = true)
	private String value;

	@Column(name = "POLL_ID", columnDefinition = "NUMBER|调查结果ID|11|", length = 11, nullable = true)
	private Long pollId;

	@Column(name = "ITEM_ID", columnDefinition = "NUMBER|调查项选项ID|11|", length = 11, nullable = true)
	private Long itemId;

	@Transient
	private SurveyItem surveyItem;

	@Transient
	private User user;

	String type;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getPollId() {
		return this.pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public SurveyItem getSurveyItem() {
		return surveyItem;
	}

	public void setSurveyItem(SurveyItem surveyItem) {
		this.surveyItem = surveyItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}