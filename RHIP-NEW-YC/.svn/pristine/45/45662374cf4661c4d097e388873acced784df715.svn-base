package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CDM_STATUS_INFO")
public class CdmStatusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|状态表ID|11|", length = 11, nullable = false)
	private Integer id;

	@Column(name = "PIX_ID", columnDefinition = "VARCHAR2|患者唯一编码|32|", length = 32, nullable = false)
	private String pixId;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|慢病类型|20|", length = 20, nullable = true)
	private String type;

	@Column(name = "REPORT_STATUS", columnDefinition = "VARCHAR2|上报审批状态|20|", length = 20, nullable = true)
	private String reportStatus;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|是否删除|1|", length = 1, nullable = true)
	private Integer isDelete;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPixId() {
		return this.pixId;
	}

	public void setPixId(String pixId) {
		this.pixId = pixId;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReportStatus() {
		return this.reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}