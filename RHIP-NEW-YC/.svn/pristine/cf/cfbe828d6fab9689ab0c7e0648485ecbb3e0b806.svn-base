package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_EDD")
public class ListEdd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "CHECK_NUM", columnDefinition = "VARCHAR2|检测次数||", length = 20, nullable = true)
	private String checkNum;

	@Column(name = "CHECK_DT", columnDefinition = "DATE|日期||", length = 200, nullable = true)
	private Date checkDt;

	@Column(name = "FEVER_NUM", columnDefinition = "VARCHAR2|发热人数||", length = 20, nullable = true)
	private String feverNum;

	@Column(name = "FEVER_LOCAL", columnDefinition = "VARCHAR2|发热本地||", length = 20, nullable = true)
	private String feverLocal;

	@Column(name = "FEVER_FOREIGN", columnDefinition = "VARCHAR2|发热外来||", length = 20, nullable = true)
	private String feverForeign;

	@Column(name = "AGUE_NUM", columnDefinition = "VARCHAR2|发虐人数||", length = 20, nullable = true)
	private String agueNum;

	@Column(name = "AGUE_LOCAL", columnDefinition = "VARCHAR2|发虐本地||", length = 20, nullable = true)
	private String agueLocal;

	@Column(name = "AGUE_FOREIGN", columnDefinition = "VARCHAR2|发虐外来||", length = 20, nullable = true)
	private String agueForeign;

	@Column(name = "BLOOD_NUM", columnDefinition = "VARCHAR2|血检人数||", length = 20, nullable = true)
	private String bloodNum;

	@Column(name = "BLOOD_POSITIVE_NUM", columnDefinition = "VARCHAR2|血检阳性人数||", length = 20, nullable = true)
	private String bloodPositiveNum;

	@Column(name = "IFAT_NUM", columnDefinition = "VARCHAR2|IFAT人数||", length = 20, nullable = true)
	private String ifatNum;

	@Column(name = "IFAT_POSITIVE_NUM", columnDefinition = "VARCHAR2|IFAT阳性人数||", length = 20, nullable = true)
	private String ifatPositiveNum;

	@Column(name = "IFAT_PROPORTION_NUM", columnDefinition = "VARCHAR2|IFAT比例人数||", length = 20, nullable = true)
	private String ifatProportionNum;

	@Column(name = "DISPOSE_CONDITION", columnDefinition = "VARCHAR2|处理情况||", length = 200, nullable = true)
	private String disposeCondition;

	@Column(name = "CHECK_USER", columnDefinition = "VARCHAR2|检测人||", length = 50, nullable = true)
	private String checkUser;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String mofigyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
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

	public String getCheckNum() {
		return this.checkNum;
	}

	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}

	public Date getCheckDt() {
		return this.checkDt;
	}

	public void setCheckDt(Date checkDt) {
		this.checkDt = checkDt;
	}

	public String getFeverNum() {
		return this.feverNum;
	}

	public void setFeverNum(String feverNum) {
		this.feverNum = feverNum;
	}

	public String getFeverLocal() {
		return this.feverLocal;
	}

	public void setFeverLocal(String feverLocal) {
		this.feverLocal = feverLocal;
	}

	public String getFeverForeign() {
		return this.feverForeign;
	}

	public void setFeverForeign(String feverForeign) {
		this.feverForeign = feverForeign;
	}

	public String getAgueNum() {
		return this.agueNum;
	}

	public void setAgueNum(String agueNum) {
		this.agueNum = agueNum;
	}

	public String getAgueLocal() {
		return this.agueLocal;
	}

	public void setAgueLocal(String agueLocal) {
		this.agueLocal = agueLocal;
	}

	public String getAgueForeign() {
		return this.agueForeign;
	}

	public void setAgueForeign(String agueForeign) {
		this.agueForeign = agueForeign;
	}

	public String getBloodNum() {
		return this.bloodNum;
	}

	public void setBloodNum(String bloodNum) {
		this.bloodNum = bloodNum;
	}

	public String getBloodPositiveNum() {
		return this.bloodPositiveNum;
	}

	public void setBloodPositiveNum(String bloodPositiveNum) {
		this.bloodPositiveNum = bloodPositiveNum;
	}

	public String getIfatNum() {
		return this.ifatNum;
	}

	public void setIfatNum(String ifatNum) {
		this.ifatNum = ifatNum;
	}

	public String getIfatPositiveNum() {
		return this.ifatPositiveNum;
	}

	public void setIfatPositiveNum(String ifatPositiveNum) {
		this.ifatPositiveNum = ifatPositiveNum;
	}

	public String getIfatProportionNum() {
		return this.ifatProportionNum;
	}

	public void setIfatProportionNum(String ifatProportionNum) {
		this.ifatProportionNum = ifatProportionNum;
	}

	public String getDisposeCondition() {
		return this.disposeCondition;
	}

	public void setDisposeCondition(String disposeCondition) {
		this.disposeCondition = disposeCondition;
	}

	public String getCheckUser() {
		return this.checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
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

	public String getMofigyUser() {
		return this.mofigyUser;
	}

	public void setMofigyUser(String mofigyUser) {
		this.mofigyUser = mofigyUser;
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

}