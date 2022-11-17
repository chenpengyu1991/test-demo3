package com.founder.rhip.ehr.entity.portal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SMS_RECORD")
public class SmsRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|发送对象姓名|50|", length = 100, nullable = true)
	private String name;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|发送对象联系电话|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|发送内容|200|", length = 500, nullable = true)
	private String content;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|短信类型|20|", length = 2, nullable = true)
	private String type;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|发送短信时间||", nullable = true)
	private Date createTime;

	@Transient
	private Date createTimeBegin;

	@Transient
	private Date createTimeEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Criteria getCriteria(){
		Criteria criteria = new Criteria();

		if(ObjectUtil.isNotEmpty(name)){
			criteria.add("name", OP.LIKE, name);
		}

		if(ObjectUtil.isNotEmpty(phoneNumber)){
			criteria.add("phoneNumber", OP.LIKE, phoneNumber);
		}

		if(ObjectUtil.isNotEmpty(type)){
			criteria.add("type", type);
		}


		DateUtil.getCriteriaByDateRange(criteria, "CREATE_TIME", this.getCreateTimeBegin(), this.getCreateTimeEnd());
		return criteria;
	}
}