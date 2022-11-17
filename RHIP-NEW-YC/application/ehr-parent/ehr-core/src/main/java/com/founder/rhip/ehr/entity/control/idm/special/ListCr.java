package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_CR")
public class ListCr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|传染病唯一编码|11|", length = 11, nullable = true)
	private Long idmId;

	@Column(name = "CHANGE_CONTENT", columnDefinition = "VARCHAR2|变更内容|400|", length = 400, nullable = true)
	private String changeContent;

	@Column(name = "CHANGE_DT", columnDefinition = "DATE|变更时间||", nullable = true)
	private Date changeDt;

	@Column(name = "CHANGE_UNIT", columnDefinition = "VARCHAR2|变更机构|100|", length = 100, nullable = true)
	private String changeUnit;

	@Column(name = "CHANGE_USER", columnDefinition = "VARCHAR2|变更者|50|", length = 50, nullable = true)
	private String changeUser;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位|100|", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人|50|", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位|100|", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人|50|", length = 50, nullable = true)
	private String modifyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识|1|", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型|20|", length = 20, nullable = true)
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

	public String getCreateUnit() {
		return this.createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUnit() {
		return this.modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the changeContent
	 */
	public String getChangeContent() {
		return changeContent;
	}

	/**
	 * @param changeContent the changeContent to set
	 */
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}

	/**
	 * @return the changeDt
	 */
	public Date getChangeDt() {
		return changeDt;
	}

	/**
	 * @param changeDt the changeDt to set
	 */
	public void setChangeDt(Date changeDt) {
		this.changeDt = changeDt;
	}

	/**
	 * @return the changeUser
	 */
	public String getChangeUser() {
		return changeUser;
	}

	/**
	 * @param changeUser the changeUser to set
	 */
	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}

	/**
	 * @return the changeUnit
	 */
	public String getChangeUnit() {
		return changeUnit;
	}

	/**
	 * @param changeUnit the changeUnit to set
	 */
	public void setChangeUnit(String changeUnit) {
		this.changeUnit = changeUnit;
	}

}