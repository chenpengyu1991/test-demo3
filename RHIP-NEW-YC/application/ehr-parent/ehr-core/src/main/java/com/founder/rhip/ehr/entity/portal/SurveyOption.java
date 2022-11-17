package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.fasf.util.ObjectUtil;

@Entity
@Table(name = "SURVEY_OPTION")
public class SurveyOption implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ITEM", columnDefinition = "VARCHAR2|选项描述|100|", length = 100, nullable = true)
	private String item;

	@Column(name = "VALUE", columnDefinition = "VARCHAR2|选项值|50|", length = 50, nullable = true)
	private String value;
	
	@Column(name = "IS_DEFAULT", columnDefinition = "NUMBER|是否默认选中|2|", length = 2, nullable = true)
	private Long isDefault;

	@Column(name = "ITEM_ID", columnDefinition = "NUMBER|调查项ID|11|", length = 11, nullable = true)
	private Long itemId;

	@Transient
	private BigDecimal score;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Long isDefault) {
		this.isDefault = isDefault;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public boolean isEmpty() {
		if(ObjectUtil.isNullOrEmpty(this.getItem())){
			return true;
		}
		return false;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}