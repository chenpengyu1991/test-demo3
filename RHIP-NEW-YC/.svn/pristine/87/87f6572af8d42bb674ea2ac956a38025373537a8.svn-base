package com.founder.rhip.ehr.entity.control;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DC_VACCINATION_EVENT")
public class VaccinationEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 50, nullable = true)
    private String ehrId;
    @Item(index =23, code = "CREATE_DATE", column = "创建日期")
    @Column(name = "CREATE_DATE", columnDefinition = "VARCHAR2|创建日期||", nullable = true)
    private Date createDate;
    @Item(index =11, code = "CREATOR", column = "首诊医生")
    @Column(name = "CREATOR", columnDefinition = "VARCHAR2|创建者||", length = 25, nullable = true)
    private String creator;
    @Item(index =19, code = "CREATE_ORG", column = "接诊单位", isOrganization = true)
    @Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构||", length = 25, nullable = true)
    private String createOrg;
    
    @Column(name = "IMMU_TYPE", columnDefinition = "VARCHAR2|EHR号||", length = 1, nullable = true)
    private String immuType;
    
    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete = 0;
    
    @Column(name = "COMMENTS", columnDefinition = "VARCHAR2||", length = 500, nullable = true)
    private String comments;
   // @Item(index =16, code = "BARCODE", column = "条码编码")
    @Column(name = "BARCODE", columnDefinition = "VARCHAR2|条码编码||", length = 20, nullable = true)
    private String barcode;
    
    @Column(name = "CREATE_IDCARD", columnDefinition = "VARCHAR2|建卡人IDCARD||", length = 50, nullable = true)
    private String createIdcard;
    
    @Column(name = "UPDATE_ORG", columnDefinition = "VARCHAR2|更新机构||", length = 25, nullable = true)
    private String updateOrg;
  //  @Item(index =12, code = "UPDATE_DATE", column = "更新时间")
    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
    private Date updateDate;
    
    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人IDCARD||", length = 50, nullable = true)
    private String updateIdcard;
    //@Item(index =11, code = "UPDATE_NAME", column = "更新人姓名")
    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;
    @Item(index =10, code = "IS_INJECTED", column = "是否曾经接种狂犬疫苗")
    @Column(name = "IS_INJECTED", columnDefinition = "VARCHAR2|是否曾经接种||", length = 1, nullable = true)
    private String isInjected;
    @Item(index =12, code = "LAST_INJECTED_DATE", column = "最近接种时间")
    @Column(name = "LAST_INJECTED_DATE", columnDefinition = "DATE|最近接种时间||", nullable = true)
    private Date lastInjectedDate;
   // @Item(index =15, code = "COUNT", column = "接种针次数")
    @Column(name = "COUNT", columnDefinition = "NUMBER|接种针次数||", nullable = true)
    private Integer count;
   
    @Column(name = "FACTORY", columnDefinition = "VARCHAR2|生产厂家||", length = 20, nullable = true)
    private String factory;
    
    @Column(name = "other_note", columnDefinition = "VARCHAR2|其他情况||", length = 500, nullable = true)
    private String otherNote;
    
    @Column(name = "IS_ONE_YEAR_INJECTED", columnDefinition = "VARCHAR2|一年内是否全程接种过狂犬病疫苗||", length = 1, nullable = true)
  	private String isOneYearInjected;
    
    @Column(name = "IS_THREE_YEAR_INJECTED", columnDefinition = "VARCHAR2|一年前三年内是否全程接种过狂犬病疫苗||", length = 1, nullable = true)
  	private String isThreeYearInjected;
    
    @Column(name = "IS_POWER_INJECTED", columnDefinition = "VARCHAR2|三年内是否加强接种过狂犬病疫苗||", length = 1, nullable = true)
  	private String isPowerInjected;
    
    @Column(name = "LAST_FULL_INJECTED_DATE", columnDefinition = "VARCHAR2|全程接种最后一剂接种时间||",  nullable = true)
  	private Date lastFullInjectedDate;
    
    @Column(name = "LAST_POWER_INJECTED_DATE", columnDefinition = "VARCHAR2|加强接种最后一剂接种时间||",  nullable = true)
  	private Date lastPowerInjectedDate;
  	
    @Column(name = "FLAG", columnDefinition = "NUMBER|本次事件的性质。0、5、8表示重新接种，其他表示加强接种。|2|", length = 2, nullable = true)
    private Integer flag;

    @Column(name = "PRINT_FLAG", columnDefinition = "NUMBER|本次事件的打印表示：1表示打印的加强针，2表示打印的是非加强针，为空表示本事件没有提示选择|", length = 1, nullable = true)
    private Integer printFlag;
    
    @Item(index =13, code = "COMPLETE_FLAG", column = "全程接种是否完成")
    @Column(name = "COMPLETE_FLAG", columnDefinition = "NUMBER|全程接种标志位：1表示全程接种，0表示未全程接种" ,nullable = true)
    private Integer completeFlag;
    
    /**
     * 联系电话:从VaccinationMgmt读取
     */
 
    //@Item(index =6, code = "", column = "联系电话")
    @Transient
    private String phoneNumber;
    
    @Item(index =3, code = "", column = "患者姓名")
    @Transient
    private String name;
 
    @Item(index =5, code = "", column = "出生日期")
    @Transient   
    private Date birthday;
     
    @Item(index =25, code = "", column = "狂犬疫苗预约日期（第一次）")
    @Transient
    private Date firstdate;
    
    @Item(index =26, code = "", column = "狂犬疫苗预约日期（第二次）")
    @Transient
    private Date seconddate;
    
    @Item(index =29, code = "", column = "狂犬疫苗预约日期（第三次）")
    @Transient
    private Date thirddate;
    
    @Item(index =5, code = "", column = "年龄")
    @Transient
    private String age;
    @Item(index =2, code = "", column = "身份证")
    @Transient
    private String idcard;
    @Item(index =4, code = "", column = "性别", isDic = true, dicType = "GBT226112003")
    @Transient
    private String gender;
    
    @Transient
    private String patownShip;
  //  @Item(index =6, code = "", column = "村委会", isDic = true, dicType = "FS990001")
    @Transient
    private String pastreet;
  //  @Item(index =7, code = "", column = "门牌号")
    @Transient
    private String pahouseNumber;
    
    @Transient
    private String paaddress;
    
    @Item(index =7, code = "", column = "伤人动物")
    @Transient
    private String hurtType;

    @Item(index =9, code = "", column = "就诊日期")
    @Transient		
    private Date treatmentTime;
    
    @Item(index =8, code = "", column = "伤人日期")
    @Transient		
    private Date opsDate;
    //没有 用的咬伤级别
    @Item(index =14, code = "", column = "分级")
    @Transient		
    private String biteLevel;
    
    @Item(index =18, code = "", column = "接种日期")
    @Transient		
    private Date vaccinationDate;
    
	@Item(index =15, code = "", column = "接种剂量（支）")
    @Transient		
    private String vaccineMeasurement;

    @Item(index =16, code = "", column = "生产厂家")
    @Transient
    private String vaccineFactory;
    
    @Item(index =17, code = "", column = "疫苗批号")
    @Transient
    private String vaccineLotNumber;
    
    @Item(index =22, code = "", column = "患者体重")
    @Transient
    private String vaccinationWeight;
    
    @Item(index =23, code = "", column = "注射医生")
    @Transient
    private String vaccinationDoctorName;
    
    @Item(index =20, code = "IMMU_UNIT_ID", column = "接种单位", isOrganization = true)
    @Transient
    private String immuUnitId;
 
    @Column(name = "PNEUMONIA_VACC_FLAG", columnDefinition = "VARCHAR2|23价疫苗接种标记|2|", length = 2, nullable = true)
    private String pneumoniaVaccFlag = "0"; // 23价疫苗接种标记  1:已接种 0：未接种   添加人：高飞  添加日期：20180403
    
    @Column(name = "RABIES_TYPE", columnDefinition = "NUMBER|狂犬疫苗注射分类|2|", length = 2, nullable = true)
    private Integer rabiesType; // 
    
    
	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getImmuType() {
		return immuType;
	}

	public void setImmuType(String immuType) {
		this.immuType = immuType;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getAge() {
		this.age = DateUtil.getAgeByBirthday(this.birthday) + "";
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public Date getFirstdate() {
		return firstdate;
	}

	public void setFirstdate(Date firstdate) {
		this.firstdate = firstdate;
	}

	

	public Date getSeconddate() {
		return seconddate;
	}

	public void setSeconddate(Date seconddate) {
		this.seconddate = seconddate;
	}

	public Date getThirddate() {
		return thirddate;
	}

	public void setThirddate(Date thirddate) {
		this.thirddate = thirddate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCreateIdcard() {
		return createIdcard;
	}

	public void setCreateIdcard(String createIdcard) {
		this.createIdcard = createIdcard;
	}

	public String getUpdateOrg() {
		return updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateIdcard() {
		return updateIdcard;
	}

	public void setUpdateIdcard(String updateIdcard) {
		this.updateIdcard = updateIdcard;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getIsInjected() {
		return isInjected;
	}

	public void setIsInjected(String isInjected) {
		this.isInjected = isInjected;
	}

	public Date getLastInjectedDate() {
		return lastInjectedDate;
	}

	public void setLastInjectedDate(Date lastInjectedDate) {
		this.lastInjectedDate = lastInjectedDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getOtherNote() {
		return otherNote;
	}

	public void setOtherNote(String otherNote) {
		this.otherNote = otherNote;
	}

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	public Integer getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(Integer completeFlag) {
		this.completeFlag = completeFlag;
	}

	public String getPneumoniaVaccFlag() {
		return pneumoniaVaccFlag;
	}

	public void setPneumoniaVaccFlag(String pneumoniaVaccFlag) {
		this.pneumoniaVaccFlag = pneumoniaVaccFlag;
	}

	public String getBiteLevel() {
		return biteLevel;
	}

	public void setBiteLevel(String biteLevel) {
		this.biteLevel = biteLevel;
	}

	public String getPaaddress() {
		return paaddress;
	}

	public void setPaaddress(String paaddress) {
		this.paaddress = paaddress;
	}

	public Integer getRabiesType() {
		return rabiesType;
	}

	public void setRabiesType(Integer rabiesType) {
		this.rabiesType = rabiesType;
	}

	public String getIsOneYearInjected() {
		return isOneYearInjected;
	}

	public void setIsOneYearInjected(String isOneYearInjected) {
		this.isOneYearInjected = isOneYearInjected;
	}

	public String getIsThreeYearInjected() {
		return isThreeYearInjected;
	}

	public void setIsThreeYearInjected(String isThreeYearInjected) {
		this.isThreeYearInjected = isThreeYearInjected;
	}

	public String getIsPowerInjected() {
		return isPowerInjected;
	}

	public void setIsPowerInjected(String isPowerInjected) {
		this.isPowerInjected = isPowerInjected;
	}

	public Date getLastFullInjectedDate() {
		return lastFullInjectedDate;
	}

	public void setLastFullInjectedDate(Date lastFullInjectedDate) {
		this.lastFullInjectedDate = lastFullInjectedDate;
	}

	public Date getLastPowerInjectedDate() {
		return lastPowerInjectedDate;
	}

	public void setLastPowerInjectedDate(Date lastPowerInjectedDate) {
		this.lastPowerInjectedDate = lastPowerInjectedDate;
	}
	
}
