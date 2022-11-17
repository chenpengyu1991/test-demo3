package com.founder.rhip.ehr.entity.nc;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NC_LOG")
public class NcLog implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;
    
	@Column(name = "LOG_TYPE", columnDefinition = "VARCHAR2|接口类别|2|", length = 2, nullable = false)
	private String logType;
    
	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号码|18|", length = 18, nullable = false)
	private String idCard;

	@Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String personName;

	@Column(name = "BRITHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date brithday;
	
	@Column(name = "PARENT_NAME", columnDefinition = "VARCHAR2|父亲姓名/母亲姓名|50|", length = 50, nullable = true)
	private String parentName;
	
	@Column(name = "OPERATE_DATE", columnDefinition = "DATE|参数时间||", nullable = true)
	private Date operateDate;
	
	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = false)
	private Date createDate;

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
