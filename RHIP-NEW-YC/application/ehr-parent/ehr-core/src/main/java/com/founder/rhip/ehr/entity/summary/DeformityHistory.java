package com.founder.rhip.ehr.entity.summary;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DHS_DEFORMITY_HISTORY")
public class DeformityHistory implements Serializable {

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

    @Column(name = "DEFORMITY_FLAG", columnDefinition = "CHAR|残疾标志||", length = 1, nullable = true)
    private String deformityFlag;

    @RecordTrace
    @Column(name = "VISION_DEFORMITY", columnDefinition = "CHAR|视力残疾||", length = 1, nullable = true)
    private String visionDeformity;

    @RecordTrace
    @Column(name = "HEARING_DEFORMITY", columnDefinition = "CHAR|听力残疾||", length = 1, nullable = true)
    private String hearingDeformity;

    @RecordTrace
    @Column(name = "SPEECH_DEFORMITY", columnDefinition = "CHAR|言语残疾||", length = 1, nullable = true)
    private String speechDeformity;

    @RecordTrace
    @Column(name = "LIMB_DEFORMITY", columnDefinition = "CHAR|肢体残疾||", length = 1, nullable = true)
    private String limbDeformity;

    @RecordTrace
    @Column(name = "INTELLECT_DEFORMITY", columnDefinition = "CHAR|智力残疾||", length = 1, nullable = true)
    private String intellectDeformity;

    @RecordTrace
    @Column(name = "MIND_DEFORMITY", columnDefinition = "CHAR|精神残疾||", length = 1, nullable = true)
    private String mindDeformity;

    @RecordTrace
    @Column(name = "OTHER", columnDefinition = "CHAR|其他||", length = 1, nullable = true)
    private String other;

    @RecordTrace
    @Column(name = "OTHER_DESC", columnDefinition = "VARCHAR2|其他说明||", length = 100, nullable = true)
    private String otherDesc;

    @Column(name = "DEFORMITY_LEVEL_CODE", columnDefinition = "VARCHAR2|残疾等级代码||", length = 1, nullable = true)
    private String deformityLevelCode;

    @Column(name = "DEFORMITY_CAUSE_CODE", columnDefinition = "VARCHAR2|致残原因代码||", length = 2, nullable = true)
    private String deformityCauseCode;

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

    public String getDeformityFlag() {
        return this.deformityFlag;
    }

    public void setDeformityFlag(String deformityFlag) {
        this.deformityFlag = deformityFlag;
    }

    public String getVisionDeformity() {
        return this.visionDeformity;
    }

    public void setVisionDeformity(String visionDeformity) {
        this.visionDeformity = visionDeformity;
    }

    public String getHearingDeformity() {
        return this.hearingDeformity;
    }

    public void setHearingDeformity(String hearingDeformity) {
        this.hearingDeformity = hearingDeformity;
    }

    public String getSpeechDeformity() {
        return this.speechDeformity;
    }

    public void setSpeechDeformity(String speechDeformity) {
        this.speechDeformity = speechDeformity;
    }

    public String getLimbDeformity() {
        return this.limbDeformity;
    }

    public void setLimbDeformity(String limbDeformity) {
        this.limbDeformity = limbDeformity;
    }

    public String getIntellectDeformity() {
        return this.intellectDeformity;
    }

    public void setIntellectDeformity(String intellectDeformity) {
        this.intellectDeformity = intellectDeformity;
    }

    public String getMindDeformity() {
        return this.mindDeformity;
    }

    public void setMindDeformity(String mindDeformity) {
        this.mindDeformity = mindDeformity;
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

    public String getDeformityLevelCode() {
        return deformityLevelCode;
    }

    public void setDeformityLevelCode(String deformityLevelCode) {
        this.deformityLevelCode = deformityLevelCode;
    }

    public String getDeformityCauseCode() {
        return deformityCauseCode;
    }

    public void setDeformityCauseCode(String deformityCauseCode) {
        this.deformityCauseCode = deformityCauseCode;
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
