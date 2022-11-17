package com.founder.rhip.ehr.entity.basic;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.export.Item;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BI_FAMILY_INFO")
public class FamilyInfo implements Serializable {
    private static final long serialVersionUID = -5396614817223620508L;
    @Transient
    private List<FamilyPersonRelation> familyMemberList;                //家庭关系
    @Transient
    private List<FamilyWaterRelation> familyWaterRelationList;        //家庭用水
    @Transient
    private List<FamilyHostoiletRelation> familyHostoiletRelationList;     //家庭户厕
    @Transient
    private String water;     //家庭用水 （多选时做为参数属性）
    @Transient
    private String hastoilet;     //户厕 （多选时做为参数属性）
    @Transient
    private String orgName;      //机构名称  (机构参数)

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER", columnDefinition = "VARCHAR2|户口号||", length = 12, nullable = true)
    private String accountNumber;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 12, nullable = true)
    private String gBCode;

    @Column(name = "ZONE_GBCODE", columnDefinition = "VARCHAR2|10位行政区划代码||", length = 10, nullable = true)
    private String zoneGBCode;

    @Column(name = "HOUSEHOLDER_NAME", columnDefinition = "VARCHAR2|户主姓名||", length = 50, nullable = true)
    private String householderName;

    @Column(name = "HOUSEHOLDER_IDCARD", columnDefinition = "VARCHAR2|户主身份证号||", length = 18, nullable = true)
    private String householderIdcard;

    @Column(name = "FAMILY_TYPE", columnDefinition = "VARCHAR2|户属性代码||", length = 1, nullable = true)
    private String familyType;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住地址一市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住地址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址一乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

/*    @Item(index=6,column ="现住址-组",isDic=true,dicType="FS990001")*/
    @Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
    private String paGroup;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
    private String papostCode;

    @Column(name = "HOME_PHONE", columnDefinition = "VARCHAR2|住宅电话||", length = 20, nullable = true)
    private String homePhone;

    @Column(name = "ADDRESS", columnDefinition = "VARCHAR2|住宅详细地址||", length = 100, nullable = true)
    private String address;

    @Column(name = "PERSON_NUM", columnDefinition = "VARCHAR2|家庭人数(人)||", length = 2, nullable = true)
    private String personNum;

    @Column(name = "INCOME", columnDefinition = "VARCHAR2|家庭年人均收入类别代码||", length = 1, nullable = true)
    private String income;

    @Column(name = "HOUSE_SIZE", columnDefinition = "NUMBER|住房面积(平方米)||", length = 8, nullable = true)
    private Integer houseSize;

    @Column(name = "HOUSE_STRUCTURE", columnDefinition = "VARCHAR2|房屋分类代码||", length = 1, nullable = true)
    private String houseStructure;

    @Column(name = "OUT_WIND", columnDefinition = "VARCHAR2|厨房排风设施类别||", length = 1, nullable = true)
    private String outWind;

    @Column(name = "FUEL", columnDefinition = "VARCHAR2|家庭燃料类别代码||", length = 1, nullable = true)
    private String fuel;

    @Column(name = "FOWL_TYPE", columnDefinition = "VARCHAR2|家庭禽畜栏类别||", length = 1, nullable = true)
    private String fowlType;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人员身份证||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人员姓名||", length = 30, nullable = true)
    private String inputName;

    @Column(name = "INPUT_SUPER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级建档机构编码||", length = 15, nullable = true)
    private String inputSuperOrganCode;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档人员姓名||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
    private Date inputDate;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 15, nullable = true)
    private String updateOrgancode;

    @Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
    private String updateOrganname;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate = new Date();

    @Column(name = "MEMBER_LINK", columnDefinition = "VARCHAR2|成员基本关系表||", nullable = true)
    private String memberLink;

    @Column(name = "MOVED_VACATE_FLAG", columnDefinition = "VARCHAR2|迁入迁出||", length = 1, nullable = true)
    private String movedVacateFlag;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "STATUS", columnDefinition = "NUMBER(1)|家庭状态||", length = 1, nullable = true)
    private Integer status;        //0:已建档  1：审核中   2:已注销  3:退回

	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
    
    @Transient
    private String familyTypeDesc;
    
    @Transient
    private String houseStructureDesc;
    
    @Transient
    private String outWindDesc;
    
    @Transient
    private String hastoiletCode;
    
    @Transient
    private String hastoiletDesc;
    
    @Transient
    private String waterCode;
    
    @Transient
    private String waterDesc; 
    
    @Transient
    private String fuelDesc;
    
    @Transient
    private String fowlTypeDesc;
    
    @Transient
    private String incomeDesc;

    public String getPaGroup() {
        return paGroup;
    }

    public void setPaGroup(String paGroup) {
        this.paGroup = paGroup;
    }

    public String getIncomeDesc() {
		return incomeDesc;
	}

	public void setIncomeDesc(String incomeDesc) {
		this.incomeDesc = incomeDesc;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInputIdcard() {
        return inputIdcard;
    }

    public void setInputIdcard(String inputIdcard) {
        this.inputIdcard = inputIdcard;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputSuperOrganCode() {
        return inputSuperOrganCode;
    }

    public void setInputSuperOrganCode(String inputSuperOrganCode) {
        this.inputSuperOrganCode = inputSuperOrganCode;
    }

    public String getInputOrganCode() {
        return inputOrganCode;
    }

    public void setInputOrganCode(String inputOrganCode) {
        this.inputOrganCode = inputOrganCode;
    }

    public String getInputOrganName() {
        return inputOrganName;
    }

    public void setInputOrganName(String inputOrganName) {
        this.inputOrganName = inputOrganName;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getMovedVacateFlag() {
        return movedVacateFlag;
    }

    public void setMovedVacateFlag(String movedVacateFlag) {
        this.movedVacateFlag = movedVacateFlag;
    }

    public String getZoneGBCode() {
        return this.zoneGBCode;
    }

    public void setZoneGBCode(String zoneGBCode) {
        this.zoneGBCode = zoneGBCode;
    }

    public String getHouseholderName() {
        return this.householderName;
    }

    public void setHouseholderName(String householderName) {
        this.householderName = householderName;
    }

    public String getHouseholderIdcard() {
        return this.householderIdcard;
    }

    public void setHouseholderIdcard(String householderIdcard) {
        this.householderIdcard = householderIdcard;
    }

    public String getFamilyType() {
        return this.familyType;
    }

    public void setFamilyType(String familyType) {
        this.familyType = familyType;
    }

    public String getPaprovince() {
        return this.paprovince;
    }

    public void setPaprovince(String paprovince) {
        this.paprovince = paprovince;
    }

    public String getPacity() {
        return this.pacity;
    }

    public void setPacity(String pacity) {
        this.pacity = pacity;
    }

    public String getPacounty() {
        return this.pacounty;
    }

    public void setPacounty(String pacounty) {
        this.pacounty = pacounty;
    }

    public String getPatownShip() {
        return this.patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public String getPastreet() {
        return this.pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    public String getPahouseNumber() {
        return this.pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public String getPapostCode() {
        return this.papostCode;
    }

    public void setPapostCode(String papostCode) {
        this.papostCode = papostCode;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonNum() {
        return this.personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getIncome() {
        return this.income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public Integer getHouseSize() {
        return this.houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public String getHouseStructure() {
        return this.houseStructure;
    }

    public void setHouseStructure(String houseStructure) {
        this.houseStructure = houseStructure;
    }

    public String getOutWind() {
        return this.outWind;
    }

    public void setOutWind(String outWind) {
        this.outWind = outWind;
    }

    public String getHastoilet() {
        if (ObjectUtil.isNotEmpty(familyHostoiletRelationList)) {
            StringBuffer str = new StringBuffer();

            for (FamilyHostoiletRelation hostoiletRe : familyHostoiletRelationList) {
                str.append(hostoiletRe.getHastoiletCode() + ",");
            }
            if (StringUtils.isNotBlank(str.toString())) {
                this.hastoilet = str.toString().substring(0, str.length() - 1);
            }

        }
        return this.hastoilet;
    }

    public void setHastoilet(String hastoilet) {
        this.hastoilet = hastoilet;
    }

    public String getWater() {
        if (ObjectUtil.isNotEmpty(familyWaterRelationList)) {
            StringBuffer str = new StringBuffer();

            for (FamilyWaterRelation waterRe : familyWaterRelationList) {
                str.append(waterRe.getWaterCode() + ",");
            }
            if (StringUtils.isNotBlank(str.toString())) {
                this.water = str.toString().substring(0, str.length() - 1);
            }

        }
        return this.water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFuel() {
        return this.fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFowlType() {
        return this.fowlType;
    }

    public void setFowlType(String fowlType) {
        this.fowlType = fowlType;
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

    public String getUpdateOrgancode() {
        return this.updateOrgancode;
    }

    public void setUpdateOrgancode(String updateOrgancode) {
        this.updateOrgancode = updateOrgancode;
    }

    public String getUpdateOrganname() {
        return this.updateOrganname;
    }

    public void setUpdateOrganname(String updateOrganname) {
        this.updateOrganname = updateOrganname;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getgBCode() {
        return gBCode;
    }

    public void setgBCode(String gBCode) {
        this.gBCode = gBCode;
    }

    public List<FamilyPersonRelation> getFamilyMemberList() {
        return familyMemberList;
    }

    public void setFamilyMemberList(List<FamilyPersonRelation> familyMemberList) {
        this.familyMemberList = familyMemberList;
    }

    public String getMemberLink() {
        return memberLink;
    }

    public void setMemberLink(String memberLink) {
        this.memberLink = memberLink;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setFamilyRelationWithFamilyId(Long id) {
        if (null == id || null == this.familyMemberList) return;
        for (FamilyPersonRelation fpr : this.familyMemberList) {
            fpr.setFamilyId(id);
        }
    }

    public List<FamilyWaterRelation> getFamilyWaterRelationList() {
        return familyWaterRelationList;
    }

    public void setFamilyWaterRelationList(List<FamilyWaterRelation> familyWaterRelationList) {
        this.familyWaterRelationList = familyWaterRelationList;
    }

    public List<FamilyHostoiletRelation> getFamilyHostoiletRelationList() {
        return familyHostoiletRelationList;
    }

    public void setFamilyHostoiletRelationList(List<FamilyHostoiletRelation> familyHostoiletRelationList) {
        this.familyHostoiletRelationList = familyHostoiletRelationList;
    }

	
	public String getFamilyTypeDesc() {
		return familyTypeDesc;
	}

	
	public void setFamilyTypeDesc(String familyTypeDesc) {
		this.familyTypeDesc = familyTypeDesc;
	}

	
	public String getHouseStructureDesc() {
		return houseStructureDesc;
	}

	
	public void setHouseStructureDesc(String houseStructureDesc) {
		this.houseStructureDesc = houseStructureDesc;
	}

	
	public String getOutWindDesc() {
		return outWindDesc;
	}

	
	public void setOutWindDesc(String outWindDesc) {
		this.outWindDesc = outWindDesc;
	}

	
	public String getHastoiletCode() {
		return hastoiletCode;
	}

	
	public void setHastoiletCode(String hastoiletCode) {
		this.hastoiletCode = hastoiletCode;
	}

	
	public String getHastoiletDesc() {
		return hastoiletDesc;
	}

	
	public void setHastoiletDesc(String hastoiletDesc) {
		this.hastoiletDesc = hastoiletDesc;
	}

	
	public String getWaterCode() {
		return waterCode;
	}

	
	public void setWaterCode(String waterCode) {
		this.waterCode = waterCode;
	}

	
	public String getWaterDesc() {
		return waterDesc;
	}

	
	public void setWaterDesc(String waterDesc) {
		this.waterDesc = waterDesc;
	}

	
	public String getFuelDesc() {
		return fuelDesc;
	}

	
	public void setFuelDesc(String fuelDesc) {
		this.fuelDesc = fuelDesc;
	}

	
	public String getFowlTypeDesc() {
		return fowlTypeDesc;
	}

	
	public void setFowlTypeDesc(String fowlTypeDesc) {
		this.fowlTypeDesc = fowlTypeDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	

}
