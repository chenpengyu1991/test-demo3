package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DM_TUMOR_FOLLOWUP")
public class TumorFollowup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|PIX号||", length = 50, nullable = true)
    private String smpiId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = false)
    private String recordNumber;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = false)
    private String idcard;

    @Column(name = "VISIT_DATE", columnDefinition = "DATE|本次随访日期||", nullable = true)
    private Date visitDate;

    @Column(name = "VISIT_WAY_CODE", columnDefinition = "VARCHAR2|随访方式代码||", length = 1, nullable = true)
    private String visitWayCode;

    @Column(name = "FIRST_DATE", columnDefinition = "DATE|首次发病日期||", nullable = true)
    private Date firstDate;

    @Column(name = "RECUR_DATE", columnDefinition = "DATE|最近复发日期||", nullable = true)
    private Date recurDate;

    @Column(name = "CUR_STATE", columnDefinition = "VARCHAR2|目前病情状况代码||", length = 1, nullable = true)
    private String curState;

    @Column(name = "CURE", columnDefinition = "VARCHAR2|肿瘤患者治疗标志||", length = 1, nullable = true)
    private String cure;

    @Column(name = "CURE_PROJECT", columnDefinition = "VARCHAR2|肿瘤患者治疗方式代码组合||", length = 100, nullable = true)
    private String cureProject;

    @Column(name = "OTHER_CURE", columnDefinition = "VARCHAR2|患者其他治疗方式||", length = 100, nullable = true)
    private String otherCure;

    @Column(name = "THERIOMA_HISTORY_FLAG", columnDefinition = "VARCHAR2|肿瘤家族史标志||", length = 1, nullable = true)
    private String theriomaHistoryFlag;

    @Column(name = "OPS", columnDefinition = "VARCHAR2|肿瘤手术标志||", length = 1, nullable = true)
    private String ops;

    @Column(name = "THERIOMA_OPERATION", columnDefinition = "VARCHAR2|肿瘤手术性质代码||", length = 1, nullable = true)
    private String theriomaOperation;

    @Column(name = "METASTASIS", columnDefinition = "VARCHAR2|肿瘤患者转移标志||", length = 1, nullable = true)
    private String metastasis;

    @Column(name = "METASTASIS_PART", columnDefinition = "VARCHAR2|肿瘤患者转移部位||", length = 100, nullable = true)
    private String metastasisPart;

    @Column(name = "OPS_HOSPITAL", columnDefinition = "VARCHAR2|肿瘤手术医院名称||", length = 70, nullable = true)
    private String opsHospital;

    @Column(name = "OPS_DATE", columnDefinition = "DATE|手术日期||", nullable = true)
    private Date opsDate;

    @Column(name = "CRTESIAN_VALUE", columnDefinition = "NUMBER|卡氏评分值||", length = 5, nullable = true)
    private Integer crtesianValue;

    @Column(name = "NEXT_SUPERVISION_DATE", columnDefinition = "DATE|下次随访日期||", nullable = true)
    private Date nextSupervisionDate;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|随访机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|随访机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|随访人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|随访人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|录入日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitWayCode() {
        return this.visitWayCode;
    }

    public void setVisitWayCode(String visitWayCode) {
        this.visitWayCode = visitWayCode;
    }

    public Date getFirstDate() {
        return this.firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getRecurDate() {
        return this.recurDate;
    }

    public void setRecurDate(Date recurDate) {
        this.recurDate = recurDate;
    }

    public String getCurState() {
        return this.curState;
    }

    public void setCurState(String curState) {
        this.curState = curState;
    }

    public String getCure() {
        return this.cure;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    public String getCureProject() {
        return this.cureProject;
    }

    public void setCureProject(String cureProject) {
        this.cureProject = cureProject;
    }

    public String getOtherCure() {
        return this.otherCure;
    }

    public void setOtherCure(String otherCure) {
        this.otherCure = otherCure;
    }

    public String getTheriomaHistoryFlag() {
        return this.theriomaHistoryFlag;
    }

    public void setTheriomaHistoryFlag(String theriomaHistoryFlag) {
        this.theriomaHistoryFlag = theriomaHistoryFlag;
    }

    public String getOps() {
        return this.ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public String getTheriomaOperation() {
        return this.theriomaOperation;
    }

    public void setTheriomaOperation(String theriomaOperation) {
        this.theriomaOperation = theriomaOperation;
    }

    public String getMetastasis() {
        return this.metastasis;
    }

    public void setMetastasis(String metastasis) {
        this.metastasis = metastasis;
    }

    public String getMetastasisPart() {
        return this.metastasisPart;
    }

    public void setMetastasisPart(String metastasisPart) {
        this.metastasisPart = metastasisPart;
    }

    public String getOpsHospital() {
        return this.opsHospital;
    }

    public void setOpsHospital(String opsHospital) {
        this.opsHospital = opsHospital;
    }

    public Date getOpsDate() {
        return this.opsDate;
    }

    public void setOpsDate(Date opsDate) {
        this.opsDate = opsDate;
    }

    public Integer getCrtesianValue() {
        return this.crtesianValue;
    }

    public void setCrtesianValue(Integer crtesianValue) {
        this.crtesianValue = crtesianValue;
    }

    public Date getNextSupervisionDate() {
        return this.nextSupervisionDate;
    }

    public void setNextSupervisionDate(Date nextSupervisionDate) {
        this.nextSupervisionDate = nextSupervisionDate;
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

    public String getInputIdcard() {
        return this.inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public String getInputName() {
        return this.inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
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


    public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

}
