package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "MHM_STATUS_INFO")
public class MhmStatusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "PIX_ID", columnDefinition = "VARCHAR2|患者唯一编码|32|", length = 32, nullable = false)
	private String pixId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|BI_PERSON_INFO表ID|11|", length = 11, nullable = false)
	private Long personId;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER|状态（0未审核，1中心审核，2诊断确诊，3复核确诊，4管理，5不通过，6诊断排除，7复核排除）|1|", length = 1, nullable = true)
	private Integer status;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态（0正常，1删除）|1|0", length = 1, nullable = false)
	private Integer isDelete;

    @Column(name = "PATIENT_RESOURCE", columnDefinition = "VARCHAR2|患者来源（1出院，2门诊，3线索登记）|2|", length = 2, nullable = false)
    private String patientResource;

    @Column(name = "LOGOFF", columnDefinition = "NUMBER|注销标志（0正常，1注销）|1|", length = 1, nullable = false)
    private Integer logoff = 0;

    public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPixId() {
		return this.pixId;
	}

	public void setPixId(String pixId) {
		this.pixId = pixId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

    public String getPatientResource() {
        return patientResource;
    }

    public void setPatientResource(String patientResource) {
        this.patientResource = patientResource;
    }

    public Integer getLogoff() {
        return logoff == null?0:logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}