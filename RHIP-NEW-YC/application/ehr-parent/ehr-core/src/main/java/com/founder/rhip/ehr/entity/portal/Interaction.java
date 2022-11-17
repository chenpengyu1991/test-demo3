package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INTERACTION")
public class Interaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|100|", length = 100, nullable = true)
	private String name;
	
		@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|联系地址|200|", length = 200, nullable = true)
	private String address;

	@Column(name = "POSTCODE", columnDefinition = "VARCHAR2|邮编|10|", length = 10, nullable = true)
	private String postcode;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|邮箱|50|", length = 50, nullable = true)
	private String email;

	@Column(name = "IDCARD_TYPE", columnDefinition = "VARCHAR2|证件类型|2|", length = 2, nullable = true)
	private String idcardType;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|证件号|20|", length = 20, nullable = true)
	private String idcard;

	@Column(name = "EVENT_TYPE", columnDefinition = "VARCHAR2|办件类型|2|", length = 2, nullable = true)
	private String eventType;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构编码|50|", length = 50, nullable = true)
	private String orgCode;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|标题|100|", length = 100, nullable = true)
	private String title;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|内容|500|", length = 500, nullable = true)
	private String content;

	@Column(name = "INSERT_DATE", columnDefinition = "DATE|日期||", nullable = true)
	private Date insertDate;

	@Column(name = "REPLY_CONTENT", columnDefinition = "VARCHAR2|回复内容|500|", length = 500, nullable = true)
	private String replyContent;

	@Column(name = "REPLY_DATE", columnDefinition = "DATE|回复时间||", nullable = true)
	private Date replyDate;

	@Column(name = "REPLY_NAME", columnDefinition = "VARCHAR2|回复人|11|", length = 11, nullable = true)
	private String replyName;

	@Column(name = "UNIT_CODE", columnDefinition = "VARCHAR2|回复单位|50|", length = 50, nullable = true)
	private String unitCode;

	@Column(name = "NEXT_UNIT", columnDefinition = "VARCHAR2|下一步回复单位|50|", length = 50, nullable = true)
	private String nextUnit;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态 01：已分派； 02：已接受； 03：已退回；04：已回复; 05：新增|2|", length = 2, nullable = true)
	private String status;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|是否删除|1|", length = 1, nullable = true)
	private Integer isDelete = 0;
	
	private Date beginTime;
	private Date endTime;
	private String operatorType;//1 查看 2 修改
	
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcardType() {
		return this.idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyName() {
		return this.replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getNextUnit() {
		return this.nextUnit;
	}

	public void setNextUnit(String nextUnit) {
		this.nextUnit = nextUnit;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}