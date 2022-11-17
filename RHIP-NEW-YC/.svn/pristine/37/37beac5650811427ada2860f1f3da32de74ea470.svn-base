package com.founder.rhip.ehr.entity.summary;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 暴露史
 * @author Jiang Haiying
 *
 */
@Entity
@Table(name = "DHS_EXPOSE_HISTORY")
public class ExposeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 50, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 50, nullable = true)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "EXPOSE_FLAG", columnDefinition = "CHAR|环境危险因素暴露标志||", length = 1, nullable = true)
    private String exposeFlag;

//    CV0300301
    @RecordTrace
    @Column(name = "CHEMICAL", columnDefinition = "CHAR|化学品||", length = 1, nullable = true)
    private String chemical;

//    CV0300301
    @RecordTrace
    @Column(name = "POISON", columnDefinition = "CHAR|毒物||", length = 1, nullable = true)
    private String poison;

//    CV0300301
    @RecordTrace
    @Column(name = "RAY", columnDefinition = "CHAR|射线||", length = 1, nullable = true)
    private String ray;

    @Column(name = "UNKNOWN", columnDefinition = "CHAR|不详||", length = 1, nullable = true)
    private String unknown;

    @Column(name = "OTHER", columnDefinition = "CHAR|其他||", length = 1, nullable = true)
    private String other;

    @Column(name = "OTHER_DESC", columnDefinition = "VARCHAR2|其他说明||", length = 100, nullable = true)
    private String otherDesc;

    @Column(name = "EXPOSE_YEAR", columnDefinition = "NUMBER|累计暴露年限(年)||", length = 3, nullable = true)
    private String exposeYear;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getExposeFlag() {
        return this.exposeFlag;
    }

    public void setExposeFlag(String exposeFlag) {
        this.exposeFlag = exposeFlag;
    }

    public String getChemical() {
        return this.chemical;
    }

    public void setChemical(String chemical) {
        this.chemical = chemical;
    }

    public String getPoison() {
        return this.poison;
    }

    public void setPoison(String poison) {
        this.poison = poison;
    }

    public String getExposeYear() {
        return exposeYear;
    }

    public void setExposeYear(String exposeYear) {
        this.exposeYear = exposeYear;
    }

    public String getRay() {
        return this.ray;
    }

    public void setRay(String ray) {
        this.ray = ray;
    }

    public String getUnknown() {
        return this.unknown;
    }

    public void setUnknown(String unknown) {
        this.unknown = unknown;
    }

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOtherDesc() {
        return this.otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }

    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputIdcard() {
        return this.inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public String getInputOrganCode() {
        return this.inputOrganCode;
    }

    public void setInputOrganCode(String inputOrganCode) {
        this.inputOrganCode = inputOrganCode;
    }

    public String getInputOrganName() {
        return this.inputOrganName;
    }

    public void setInputOrganName(String inputOrganName) {
        this.inputOrganName = inputOrganName;
    }

    public Date getInputDate() {
        return this.inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
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


}
