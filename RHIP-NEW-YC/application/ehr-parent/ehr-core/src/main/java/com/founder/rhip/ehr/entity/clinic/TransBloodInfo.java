package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_TRANS_BLOOD_INFO")
public class TransBloodInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|编号表主键||", length = 11, nullable = true)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PIX号||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "BLOOD_BAG_NO", columnDefinition = "VARCHAR2|血袋编号||", length = 20, nullable = true)
    private String bloodBagNo;

    @Column(name = "EHR_NAME", columnDefinition = "VARCHAR2|活动名称||", length = 50, nullable = true)
    private String ehrName;

    @Column(name = "BLOOD_SPECIFICATION", columnDefinition = "VARCHAR2|输血规格||", length = 20, nullable = true)
    private String bloodSpecification;

    @Column(name = "UNIT_CODE", columnDefinition = "VARCHAR2|输血单位代码||", length = 1, nullable = true)
    private String unitCode;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|输血单位名称||", length = 50, nullable = true)
    private String unitName;

    @Column(name = "BLOOD_QUANTITY", columnDefinition = "NUMBER|输血数量||", length = 6, nullable = true)
    private Double bloodQuantity;

    @Column(name = "BLOOD_TYPE_CODE", columnDefinition = "VARCHAR2|输血品种代码||", length = 1, nullable = true)
    private String bloodTypeCode;

    @Column(name = "BLOOD_TYPE_NAME", columnDefinition = "VARCHAR2|输血品种名称||", length = 50, nullable = true)
    private String bloodTypeName;

    @Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型代码||", length = 1, nullable = true)
    private String aboBloodType;

    @Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|Rh血型代码||", length = 1, nullable = true)
    private String rhBloodType;

    @Column(name = "BLOOD_REASON", columnDefinition = "VARCHAR2|输血原因||", length = 300, nullable = true)
    private String bloodReason;

    @Column(name = "BLOOD_CODE", columnDefinition = "VARCHAR2|输血者姓名工号||", length = 18, nullable = true)
    private String bloodCode;

    @Column(name = "BLOOD_NAME", columnDefinition = "VARCHAR2|输血者姓名||", length = 50, nullable = true)
    private String bloodName;

    @Column(name = "BLOOD_ORGAN_NAME", columnDefinition = "VARCHAR2|输血机构名称||", length = 70, nullable = true)
    private String bloodOrganName;

    @Column(name = "BLOOD_IDCARD", columnDefinition = "VARCHAR2|输血者姓名身份证||", length = 18, nullable = true)
    private String bloodIdcard;

    @Column(name = "INVALID_DATE", columnDefinition = "DATE|失效日期时间||", nullable = true)
    private Date invalidDate;

    @Column(name = "BLOOD_DATE", columnDefinition = "DATE|输血日期时间||", nullable = true)
    private Date bloodDate;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "DEPT_CODE", columnDefinition = "VARCHAR2|机构科室代码||", length = 5, nullable = true)
    private String deptCode;

    @Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|机构科室名称||", length = 50, nullable = true)
    private String deptName;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|状态||", length = 1, nullable = true)
    private Byte isDelete;
    
    @Column(name = "APPLY_NO", columnDefinition = "VARCHAR2|申请单编号||", length = 24, nullable = true)
    private String applyNo;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理手术史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
    @Transient
    private String opEmHpMark;
    
    @Transient
    private String opEmHpNo;
    
    @Transient 
    private String opEmHpMarkDesc;

    @Transient
    private String aboBloodTypeDesc;
    
    @Transient
    private String rhBloodTypeDesc;

    @Transient
    private String idcard;
    
    public String getRhBloodTypeDesc() {
		return rhBloodTypeDesc;
	}

	public void setRhBloodTypeDesc(String rhBloodTypeDesc) {
		this.rhBloodTypeDesc = rhBloodTypeDesc;
	}

	public String getAboBloodTypeDesc() {
		return aboBloodTypeDesc;
	}

	public void setAboBloodTypeDesc(String aboBloodTypeDesc) {
		this.aboBloodTypeDesc = aboBloodTypeDesc;
	}

	public String getOpEmHpMarkDesc() {
		return opEmHpMarkDesc;
	}

	public void setOpEmHpMarkDesc(String opEmHpMarkDesc) {
		this.opEmHpMarkDesc = opEmHpMarkDesc;
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEhrId() {
        return this.ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
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

	public String getMarriage() {
        return this.marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getBloodBagNo() {
        return this.bloodBagNo;
    }

    public void setBloodBagNo(String bloodBagNo) {
        this.bloodBagNo = bloodBagNo;
    }

    public String getEhrName() {
        return this.ehrName;
    }

    public void setEhrName(String ehrName) {
        this.ehrName = ehrName;
    }

    public String getBloodSpecification() {
        return this.bloodSpecification;
    }

    public void setBloodSpecification(String bloodSpecification) {
        this.bloodSpecification = bloodSpecification;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Double getBloodQuantity() {
        return this.bloodQuantity;
    }

    public void setBloodQuantity(Double bloodQuantity) {
        this.bloodQuantity = bloodQuantity;
    }

    public String getBloodTypeCode() {
        return this.bloodTypeCode;
    }

    public void setBloodTypeCode(String bloodTypeCode) {
        this.bloodTypeCode = bloodTypeCode;
    }

    public String getBloodTypeName() {
        return this.bloodTypeName;
    }

    public void setBloodTypeName(String bloodTypeName) {
        this.bloodTypeName = bloodTypeName;
    }

    public String getAboBloodType() {
        return this.aboBloodType;
    }

    public void setAboBloodType(String aboBloodType) {
        this.aboBloodType = aboBloodType;
    }

    public String getRhBloodType() {
        return this.rhBloodType;
    }

    public void setRhBloodType(String rhBloodType) {
        this.rhBloodType = rhBloodType;
    }

    public String getBloodReason() {
        return this.bloodReason;
    }

    public void setBloodReason(String bloodReason) {
        this.bloodReason = bloodReason;
    }

    public String getBloodCode() {
        return this.bloodCode;
    }

    public void setBloodCode(String bloodCode) {
        this.bloodCode = bloodCode;
    }

    public String getBloodName() {
        return this.bloodName;
    }

    public void setBloodName(String bloodName) {
        this.bloodName = bloodName;
    }

    public String getBloodOrganName() {
        return this.bloodOrganName;
    }

    public void setBloodOrganName(String bloodOrganName) {
        this.bloodOrganName = bloodOrganName;
    }

    public String getBloodIdcard() {
        return this.bloodIdcard;
    }

    public void setBloodIdcard(String bloodIdcard) {
        this.bloodIdcard = bloodIdcard;
    }

    public Date getInvalidDate() {
        return this.invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public Date getBloodDate() {
        return this.bloodDate;
    }

    public void setBloodDate(Date bloodDate) {
        this.bloodDate = bloodDate;
    }

    public String getHospitalCode() {
        return this.hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUpdateName() {
        return this.updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateIdcard() {
        return this.updateIdcard;
    }

    public void setUpdateIdcard(String updateIdcard) {
        this.updateIdcard = updateIdcard;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

	
	public String getOpEmHpMark() {
		return opEmHpMark;
	}

	
	public void setOpEmHpMark(String opEmHpMark) {
		this.opEmHpMark = opEmHpMark;
	}

	
	public String getOpEmHpNo() {
		return opEmHpNo;
	}

	
	public void setOpEmHpNo(String opEmHpNo) {
		this.opEmHpNo = opEmHpNo;
	}

	
	public String getApplyNo() {
		return applyNo;
	}

	
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	
	public Integer getIsAnalyse() {
		return isAnalyse;
	}

	
	public void setIsAnalyse(Integer isAnalyse) {
		this.isAnalyse = isAnalyse;
	}


    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}
    
    
}