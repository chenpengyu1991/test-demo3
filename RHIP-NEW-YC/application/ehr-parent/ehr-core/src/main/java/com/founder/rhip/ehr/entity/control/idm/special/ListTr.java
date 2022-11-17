package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_TR")
public class ListTr implements Serializable {

	private static final long serialVersionUID = 4203402739712445240L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "TRANSFER_DAYS", columnDefinition = "NUMBER|转诊天数||", length = 8, nullable = true)
	private Integer transferDays;

    @Column(name = "TRANSFER_DT", columnDefinition = "DATE|到诊时间||", nullable = true)
    private Date transferDt;

    @Column(name = "TRANSFER_STATUS", columnDefinition = "VARCHAR2|转诊状态|2|", length = 2, nullable = true)
    private String transferStatus;
    
	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String modfiyUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识|2|", length = 2, nullable = true)
    private Integer isDelete=0;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|类型|20|", length = 2, nullable = true)
    private String flag;
    
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public Integer getTransferDays() {
		return transferDays;
	}

	public void setTransferDays(Integer transferDays) {
		this.transferDays = transferDays;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUnit() {
		return createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getModfiyUser() {
		return modfiyUser;
	}

	public void setModfiyUser(String modfiyUser) {
		this.modfiyUser = modfiyUser;
	}

	public String getModifyUnit() {
		return modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}