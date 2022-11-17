package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_AI")
public class ListAi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "SERIAL_NO", columnDefinition = "VARCHAR2|编号|100|", length = 100, nullable = true)
	private String serialNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "HEAD_HOUSEHOLD_NAME", columnDefinition = "VARCHAR2|户主|50|", length = 50, nullable = true)
	private String headHouseholdName;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|2|", length = 2, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
	private String age;

	@Column(name = "VISIT_RESULT", columnDefinition = "VARCHAR2|走访结果|2|", length = 2, nullable = true)
	private String visitResult;

	@Column(name = "VISIT_RESULT_OTHER", columnDefinition = "VARCHAR2|走访结果其他|100|", length = 100, nullable = true)
	private String visitResultOther;

	@Column(name = "CHECK_TYPE", columnDefinition = "VARCHAR2|血检方式|2|", length = 2, nullable = true)
	private String checkType;

	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|血检结果|100|", length = 100, nullable = true)
	private String checkResult;

	@Column(name = "DIAGNOSIS_RESULT", columnDefinition = "VARCHAR2|诊断结果|100|", length = 100, nullable = true)
	private String diagnosisResult;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|400|", length = 400, nullable = true)
	private String comments;

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

    @Column(name = "CHECK_TOWN_SHIP", columnDefinition = "VARCHAR2|调查住地乡街道|100|", length = 100, nullable = true)
    private String checkTownShip;

    @Column(name = "CHECK_STREET", columnDefinition = "VARCHAR2|调查住地村社区|100|", length = 100, nullable = true)
    private String checkStreet;

    @Column(name = "CHECK_HOUSE_NUMBER", columnDefinition = "VARCHAR2|调查住地详细|100|", length = 100, nullable = true)
    private String checkHouseNumber;

    @Column(name = "CHECK_USER", columnDefinition = "VARCHAR2|调查人|50|", length = 50, nullable = true)
    private String checkUser;

    @Column(name = "REPORT_DT", columnDefinition = "DATE|上报日期||", nullable = true)
    private Date reportDt;

    @Column(name = "ACCEPT_TOWN", columnDefinition = "VARCHAR2|所属城镇|100|", length = 100, nullable = true)
    private String acceptTown;

    @Column(name = "ACCEPT_UNIT", columnDefinition = "VARCHAR2|所属机构|100|", length = 100, nullable = true)
    private String acceptUnit;

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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadHouseholdName() {
        return headHouseholdName;
    }

    public void setHeadHouseholdName(String headHouseholdName) {
        this.headHouseholdName = headHouseholdName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVisitResult() {
        return visitResult;
    }

    public void setVisitResult(String visitResult) {
        this.visitResult = visitResult;
    }

    public String getVisitResultOther() {
        return visitResultOther;
    }

    public void setVisitResultOther(String visitResultOther) {
        this.visitResultOther = visitResultOther;
    }

    public String getCheckType() {
        return this.checkType;
    }

    public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

    public String getDiagnosisResult() {
        return diagnosisResult;
    }

    public void setDiagnosisResult(String diagnosisResult) {
        this.diagnosisResult = diagnosisResult;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getCheckTownShip() {
        return checkTownShip;
    }

    public void setCheckTownShip(String checkTownShip) {
        this.checkTownShip = checkTownShip;
    }

    public String getCheckStreet() {
        return checkStreet;
    }

    public void setCheckStreet(String checkStreet) {
        this.checkStreet = checkStreet;
    }

    public String getCheckHouseNumber() {
        return checkHouseNumber;
    }

    public void setCheckHouseNumber(String checkHouseNumber) {
        this.checkHouseNumber = checkHouseNumber;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public Date getReportDt() {
        return reportDt;
    }

    public void setReportDt(Date reportDt) {
        this.reportDt = reportDt;
    }

    public String getAcceptTown() {
        return acceptTown;
    }

    public void setAcceptTown(String acceptTown) {
        this.acceptTown = acceptTown;
    }

    public String getAcceptUnit() {
        return acceptUnit;
    }

    public void setAcceptUnit(String acceptUnit) {
        this.acceptUnit = acceptUnit;
    }
}