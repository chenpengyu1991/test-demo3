package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.util.ObjectUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_OUTPATIENT_PRESCRIPTION")
public class OutpatientPrescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号||", length = 18, nullable = true)
    private String outpatientNo;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|处方号／记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 20, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "PRESCRIBE_ROOM_CODE", columnDefinition = "VARCHAR2|开具处方科室代码||", length = 5, nullable = true)
    private String prescribeRoomCode;

    @Column(name = "PRESCRIBE_ROOM_NAME", columnDefinition = "VARCHAR2|开具处方科室名称||", length = 50, nullable = true)
    private String prescribeRoomName;

    @Column(name = "CM_TYPE", columnDefinition = "VARCHAR2|中药类别代码||", length = 2, nullable = true)
    private String cmType;

    @Column(name = "DRUG_TYPE", columnDefinition = "VARCHAR2|药物类型||", length = 20, nullable = true)
    private String drugType;

    @Column(name = "DRUG_TYPE_NAME", columnDefinition = "VARCHAR2|药物类型名称||", length = 100, nullable = true)
    private String drugTypeName;

    @Column(name = "PRESCRIPTION_NOTE", columnDefinition = "VARCHAR2|处方说明||", length = 200, nullable = true)
    private String prescriptionNote;

    @Column(name = "PRESCRIPTION_TOTAL_COST", columnDefinition = "NUMBER|处方总费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal prescriptionTotalCost;

    @Column(name = "PRESCRIBE_DOCTOR_NO", columnDefinition = "VARCHAR2|开具处方医师工号||", length = 18, nullable = true)
    private String prescribeDoctorNo;

    @Column(name = "PRESCRIBE_DOCTOR_NAME", columnDefinition = "VARCHAR2|开具处方医师姓名||", length = 50, nullable = true)
    private String prescribeDoctorName;

    @Column(name = "PRESCRIBE_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|开具处方医生身份证号||", length = 18, nullable = true)
    private String prescribeDoctorIdCard;

    @Column(name = "PRESCRIBE_DATE", columnDefinition = "TIMESTAMP|开具处方时间||", nullable = true)
    private Date prescribeDate;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_USER_IDCARD", columnDefinition = "VARCHAR2|填报身份证号||", length = 18, nullable = true)
    private String fillUserIdCard;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 24, nullable = true)
	private String othercardno;

	@Column(name = "OP_EM_HP_MARK", columnDefinition = "VARCHAR2|门诊/急诊/住院标志||", length = 1, nullable = true)
	private String opEmHpMark;

	@Column(name = "IF_CHARGE", columnDefinition = "VARCHAR2|是否已经收费||", length = 1, nullable = true)
	private String ifCharge;

	@Column(name = "IF_DISPENSE", columnDefinition = "VARCHAR2|是否已经发药||", length = 1, nullable = true)
	private String ifDispense;

	@Column(name = "TCM_DECOCT", columnDefinition = "VARCHAR2|中药饮片煎煮法||", length = 100, nullable = true)
	private String tcmDecoct;

	@Column(name = "TCM_USE", columnDefinition = "VARCHAR2|中药用药方法||", length = 100, nullable = true)
	private String tcmUse;

	@Column(name = "TCM_ODRNO", columnDefinition = "NUMBER|中药处方帖数||", length = 2 , nullable = true)
	private Long tcmOdrno;
    
/*    @Column(name = "PRESCRIPTION_TOTAL_COUNT", columnDefinition = "NUMBER|处方品种数|", length = 5, nullable = true)
    private Integer prescriptionTotalCount;
 
    @Column(name = "PRESCRIPTION_MAX_DOSE", columnDefinition = "NUMBER|处方中药物使用最大剂量||", scale = 12, precision = 2, nullable = true)
    private BigDecimal prescriptionMaxDose;
 
    @Column(name = "PRESCRIPTION_MAX_USE_DAYS", columnDefinition = "NUMBER|处方中药物使用最大天数|", length = 5, nullable = true)
    private Integer prescriptionMaxUseDays;*/
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
    @Column(name = "ANTIBIOTIC_FLAG", columnDefinition = "VARCHAR2|抗生素标志-0非抗生素，1抗生素||", length = 1, nullable = true)
    private String antibioticFlag;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
    /*医疗付款方式代码*/
    @Transient
    private String medicalCostPayWay; 
    
    @Transient
    private String type;
    
    @Transient
    private String prescribeDateDesc;
    
    @Transient
    private String ifChargeDesc;
    
    @Transient
    private String ifDispenseDesc;
    
    @Transient
    private String idcard;
    
	public String getPrescribeDateDesc() {
		return prescribeDateDesc;
	}

	
	public void setPrescribeDateDesc(String prescribeDateDesc) {
		this.prescribeDateDesc = prescribeDateDesc;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEhrId() {
        return this.ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
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

	public String getOutpatientNo() {
        return outpatientNo;
    }

    public void setOutpatientNo(String outpatientNo) {
        this.outpatientNo = outpatientNo;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
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

    public String getPrescribeRoomCode() {
        return this.prescribeRoomCode;
    }

    public void setPrescribeRoomCode(String prescribeRoomCode) {
        this.prescribeRoomCode = prescribeRoomCode;
    }

    public String getPrescribeRoomName() {
        return this.prescribeRoomName;
    }

    public void setPrescribeRoomName(String prescribeRoomName) {
        this.prescribeRoomName = prescribeRoomName;
    }

    public String getCmType() {
        return this.cmType;
    }

    public void setCmType(String cmType) {
        this.cmType = cmType;
    }

    public String getDrugType() {
        return this.drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getDrugTypeName() {
        return this.drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
    }

    public String getPrescriptionNote() {
        return this.prescriptionNote;
    }

    public void setPrescriptionNote(String prescriptionNote) {
        this.prescriptionNote = prescriptionNote;
    }

    public BigDecimal getPrescriptionTotalCost() {
        return this.prescriptionTotalCost;
    }

    public void setPrescriptionTotalCost(BigDecimal prescriptionTotalCost) {
        this.prescriptionTotalCost = prescriptionTotalCost;
    }

    public String getPrescribeDoctorNo() {
        return this.prescribeDoctorNo;
    }

    public void setPrescribeDoctorNo(String prescribeDoctorNo) {
        this.prescribeDoctorNo = prescribeDoctorNo;
    }

    public String getPrescribeDoctorName() {
        return this.prescribeDoctorName;
    }

    public void setPrescribeDoctorName(String prescribeDoctorName) {
        this.prescribeDoctorName = prescribeDoctorName;
    }

    public String getPrescribeDoctorIdCard() {
        return this.prescribeDoctorIdCard;
    }

    public void setPrescribeDoctorIdCard(String prescribeDoctorIdCard) {
        this.prescribeDoctorIdCard = prescribeDoctorIdCard;
    }

    public Date getPrescribeDate() {
        return this.prescribeDate;
    }

    public void setPrescribeDate(Date prescribeDate) {
        this.prescribeDate = prescribeDate;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public String getFillUserIdCard() {
        return this.fillUserIdCard;
    }

    public void setFillUserIdCard(String fillUserIdCard) {
        this.fillUserIdCard = fillUserIdCard;
    }

    public Date getFillTime() {
        return this.fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

/*	public Integer getPrescriptionTotalCount() {
		return prescriptionTotalCount;
	}

	public void setPrescriptionTotalCount(Integer prescriptionTotalCount) {
		this.prescriptionTotalCount = prescriptionTotalCount;
	}

	public BigDecimal getPrescriptionMaxDose() {
		return prescriptionMaxDose;
	}

	public void setPrescriptionMaxDose(BigDecimal prescriptionMaxDose) {
		this.prescriptionMaxDose = prescriptionMaxDose;
	}

	public Integer getPrescriptionMaxUseDays() {
		return prescriptionMaxUseDays;
	}

	public void setPrescriptionMaxUseDays(Integer prescriptionMaxUseDays) {
		this.prescriptionMaxUseDays = prescriptionMaxUseDays;
	}*/

	public String getMedicalCostPayWay() {
		return medicalCostPayWay;
	}

	public void setMedicalCostPayWay(String medicalCostPayWay) {
		this.medicalCostPayWay = medicalCostPayWay;
	}
	public String getOthercardtype() {
		return this.othercardtype;
	}

	public void setOthercardtype(String othercardtype) {
		this.othercardtype = othercardtype;
	}

	public String getOthercardno() {
		return this.othercardno;
	}

	public void setOthercardno(String othercardno) {
		this.othercardno = othercardno;
	}

	public String getOpEmHpMark() {
		return this.opEmHpMark;
	}

	public void setOpEmHpMark(String opEmHpMark) {
		this.opEmHpMark = opEmHpMark;
	}

	public String getIfCharge() {
		return this.ifCharge;
	}

	public void setIfCharge(String ifCharge) {
		this.ifCharge = ifCharge;
	}

	public String getIfDispense() {
		return this.ifDispense;
	}

	public void setIfDispense(String ifDispense) {
		this.ifDispense = ifDispense;
	}

	public String getTcmDecoct() {
		return this.tcmDecoct;
	}

	public void setTcmDecoct(String tcmDecoct) {
		this.tcmDecoct = tcmDecoct;
	}

	public String getTcmUse() {
		return this.tcmUse;
	}

	public void setTcmUse(String tcmUse) {
		this.tcmUse = tcmUse;
	}

	public Long getTcmOdrno() {
		return this.tcmOdrno;
	}

	public void setTcmOdrno(Long tcmOdrno) {
		this.tcmOdrno = tcmOdrno;
	}

	
	public String getType() {
		if (ObjectUtil.isNullOrEmpty(opEmHpMark) || StringUtils.equals("1", opEmHpMark)) {
			type = "门诊";
		} else if (StringUtils.equals("2", opEmHpMark)) {
			type = "急诊";
		} else if (StringUtils.equals("3", opEmHpMark)) {
			type = "住院";
		}
		type = new StringBuilder().append(type).append(ObjectUtil.isNullOrEmpty(tcmOdrno) ? "西药" : "中药").append("处方").toString();
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
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


	
	public String getAntibioticFlag() {
		return antibioticFlag;
	}


	
	public void setAntibioticFlag(String antibioticFlag) {
		this.antibioticFlag = antibioticFlag;
	}


	
	public String getIfChargeDesc() {
		return ifChargeDesc;
	}


	
	public void setIfChargeDesc(String ifChargeDesc) {
		this.ifChargeDesc = ifChargeDesc;
	}


	
	public String getIfDispenseDesc() {
		return ifDispenseDesc;
	}


	
	public void setIfDispenseDesc(String ifDispenseDesc) {
		this.ifDispenseDesc = ifDispenseDesc;
	}


	public Date getGatherDate() {
		return gatherDate;
	}


	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}


	public String getIdcard() {
		return idcard;
	}


	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
}
