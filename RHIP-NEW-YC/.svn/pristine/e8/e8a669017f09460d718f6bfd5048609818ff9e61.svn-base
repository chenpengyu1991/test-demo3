package com.founder.rhip.ehr.entity.ta;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 指标结果
 * @author liuk
 * @since 2014年4月3日 16:51:00
 */

@Table(name = "DHS_TARGET_RESULT_VALUE")
public class TargetResultValue {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|EHR平台人员ID||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "VALUE_A", columnDefinition = "NUMBER|收缩压值||", scale = 2, precision =6, nullable = true)
	private BigDecimal valueA;

	@Column(name = "RESULT_A", columnDefinition = "VARCHAR2|收缩压结果||", length = 50, nullable = true)
	private String resultA;

	@Column(name = "VALUE_B", columnDefinition = "NUMBER|舒张压值||", scale = 2, precision = 6, nullable = true)
	private BigDecimal valueB;

	@Column(name = "RESULT_B", columnDefinition = "VARCHAR2|舒张压结果||", length = 50, nullable = true)
	private String resultB;

	@Column(name = "VALUE_C", columnDefinition = "NUMBER|空腹血糖值||", scale = 2, precision = 6, nullable = true)
	private BigDecimal valueC;

	@Column(name = "RESULT_C", columnDefinition = "VARCHAR2|空腹血糖结果||", length = 50, nullable = true)
	private String resultC;

	@Column(name = "VALUE_D", columnDefinition = "NUMBER|餐后血糖||", scale = 2, precision = 6, nullable = true)
	private BigDecimal valueD;

	@Column(name = "RESULT_D", columnDefinition = "VARCHAR2|餐后血糖结果||", length = 50, nullable = true)
	private String resultD;

    @Column(name = "TYPE", columnDefinition = "VARCHAR2|检查项目||", length = 100, nullable = true)
    private String type;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码||", length = 50, nullable = true)
    private String createOrganCode;

    @Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建用户||", length = 50, nullable = true)
    private String createUserCode;

    @Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|创建日期||", nullable = true)
    private Date createDate;


    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
    private String updateOrganCode;

    @Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新用户||", length = 50, nullable = true)
    private String updateUserCode;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;


    public String getUpdateOrganCode() {
        return updateOrganCode;
    }

    public void setUpdateOrganCode(String updateOrganCode) {
        this.updateOrganCode = updateOrganCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public BigDecimal getValueA() {
        return valueA;
    }

    public void setValueA(BigDecimal valueA) {
        this.valueA = valueA;
    }

    public String getResultA() {
        return resultA;
    }

    public void setResultA(String resultA) {
        this.resultA = resultA;
    }

    public BigDecimal getValueB() {
        return valueB;
    }

    public void setValueB(BigDecimal valueB) {
        this.valueB = valueB;
    }

    public String getResultB() {
        return resultB;
    }

    public void setResultB(String resultB) {
        this.resultB = resultB;
    }

    public BigDecimal getValueC() {
        return valueC;
    }

    public void setValueC(BigDecimal valueC) {
        this.valueC = valueC;
    }

    public String getResultC() {
        return resultC;
    }

    public void setResultC(String resultC) {
        this.resultC = resultC;
    }

    public BigDecimal getValueD() {
        return valueD;
    }

    public void setValueD(BigDecimal valueD) {
        this.valueD = valueD;
    }

    public String getResultD() {
        return resultD;
    }

    public void setResultD(String resultD) {
        this.resultD = resultD;
    }

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
